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
                String[] datos = linea.split(",");
                lista.add(new Cliente(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    datos[2],
                    datos[3],
                    Integer.parseInt(datos[4])
                ));
            }
        }

        return lista;
    }

    
    public static void eliminarCliente(int id) throws IOException {
        List<Cliente> lista = listarClientes();

        Path out = Paths.get(ARCHIVO);

        try (BufferedWriter bw = Files.newBufferedWriter(
                out,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            bw.write("id_cliente,nombre,apellido,telefono,activo\n"); 

            for (Cliente c : lista) {
                if (c.getId() == id) {
                    c.setActivo(0); 
                }
                bw.write(c.toString() + "\n");
            }
        }
    }
}