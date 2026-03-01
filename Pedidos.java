import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedidos {

    private int idPedido;
    private int idCliente;
    private String producto;
    private double precio;
    private int cantidad;

    public Pedidos(int idPedido, int idCliente, String producto, double precio, int cantidad) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdCliente() { return idCliente; }

    public String toCSV() {
        return idPedido + "," + idCliente + "," + producto + "," + precio + "," + cantidad;
    }

    public static void registrarPedido() throws IOException {

        Scanner sc = new Scanner(System.in);

        int idCliente = sc.nextInt();
        String producto = sc.next();
        double precio = sc.nextDouble();
        int cantidad = sc.nextInt();

        int nuevoId = leerPedidos().size() + 1;

        BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.csv", true));
        bw.write(nuevoId + "," + idCliente + "," + producto + "," + precio + "," + cantidad);
        bw.newLine();
        bw.close();
    }

    public static List<Pedidos> leerPedidos() throws IOException {

        List<Pedidos> lista = new ArrayList<>();
        File archivo = new File("pedidos.csv");

        if (!archivo.exists()) return lista;

        Scanner sc = new Scanner(archivo);

        if (sc.hasNextLine()) sc.nextLine();

        while (sc.hasNextLine()) {

            String[] datos = sc.nextLine().split(",");

            lista.add(new Pedidos(
                    Integer.parseInt(datos[0]),
                    Integer.parseInt(datos[1]),
                    datos[2],
                    Double.parseDouble(datos[3]),
                    Integer.parseInt(datos[4])
            ));
        }

        sc.close();
        return lista;
    }

    public static void listarPedidosPorCliente(int idCliente) throws IOException {

        List<Pedidos> lista = leerPedidos();

        for (Pedidos p : lista) {
            if (p.getIdCliente() == idCliente) {
                System.out.println(p.toCSV());
            }
        }
    }
}