import java.io.File;
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
    private boolean activo;

    public Pedidos(int idPedido, int idCliente, String producto,
                   double precio, int cantidad, boolean activo) {

        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }
    public static List<Pedidos> leerPedidos() throws IOException {

        List<Pedidos> lista = new ArrayList<>();
        File archivo = new File("pedidos.csv");

        if (!archivo.exists()) return lista;

        Scanner sc = new Scanner(archivo);

        if (sc.hasNextLine()) sc.nextLine(); // saltar encabezado

        while (sc.hasNextLine()) {

            String[] datos = sc.nextLine().split(",");

            lista.add(new Pedidos(
                    Integer.parseInt(datos[0]),
                    Integer.parseInt(datos[1]),
                    datos[2],
                    Double.parseDouble(datos[3]),
                    Integer.parseInt(datos[4]),
                    Boolean.parseBoolean(datos[5]) // ahora sí boolean real
            ));
        }

        sc.close();
        return lista;
    }

    public static void listarPedidos() throws IOException {

        List<Pedidos> lista = leerPedidos();
System.out.println("-------Listado de pedidos------");
        for (Pedidos p : lista) {
            if (p.isActivo()) {
                
                System.out.println(
                    
                        "ID Pedido: " + p.idPedido +
                        " ID Cliente: " + p.idCliente +
                        " Producto: " + p.producto +
                        " Precio: " + p.precio +
                        " Cantidad: " + p.cantidad
                );
            }
        }
    }
}