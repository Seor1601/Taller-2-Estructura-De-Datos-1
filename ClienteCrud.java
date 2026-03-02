import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class ClienteCrud {

    private static final String ARCHIVO = "clientes.csv";

    public static List<Cliente> listarClientes() throws IOException {
        List<Cliente> lista = new ArrayList<>();
        Path ruta = Paths.get(ARCHIVO);

        if (!Files.exists(ruta)) return lista;

        try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(",", -1);

                lista.add(new Cliente(
                        Integer.parseInt(datos[0].trim()),
                        datos[1].trim(),
                        datos[2].trim(),
                        datos[3].trim(),
                        Integer.parseInt(datos[4].trim())
                ));
            }
        }

        return lista;
    }

    public static void eliminarCliente(int id) throws IOException {
        List<Cliente> lista = listarClientes();

        try (BufferedWriter bw = Files.newBufferedWriter(
                Paths.get(ARCHIVO),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        )) {
            bw.write("id_cliente,nombre,apellido,telefono,activo");
            bw.newLine();

            for (Cliente c : lista) {
                if (c.getId() == id) {
                    c.setActivo(0);
                }

                bw.write(
                        c.getId() + "," +
                        c.getNombre() + "," +
                        c.getApellido() + "," +
                        c.getTelefono() + "," +
                        c.getActivo()
                );
                bw.newLine();
            }
        }

        System.out.println("Cliente " + id + " marcado como inactivo.");
    }

    public static void imprimirClientesActivos() throws IOException {
        List<Cliente> lista = listarClientes();
        System.out.println("~~Listado de clientes (activos)~~");

        for (Cliente c : lista) {
            if (c.isActivo()) {
                System.out.println(
                        "ID: " + c.getId() +
                        " Nombre: " + c.getNombre() +
                        " Apellido: " + c.getApellido() +
                        " Telefono: " + c.getTelefono()
                );
            }
        }
    }
}