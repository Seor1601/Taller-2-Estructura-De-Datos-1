public static void crearPedido(Pedido pedido) throws IOException {
    FileWriter FW = new FileWriter("Pedidos.CSV", true);
    BufferedWriter BW = new BufferedWriter(FW);
    BW.write(pedido.toString());
    BW.newLine();
    BW.close();
}
public class Pedido {
    private int precio;
    private String nombre;
    private int cantidad;
    private int id;
    private int id_pedido;
    private int activo_p;
    private int total;

    public Pedido(int precio, String nombre, int cantidad, int id_pedido, int activo_p, int id) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.id_pedido = id_pedido;
        this.id = id;
        this.total= cantidad * precio;
        this.activo_p = activo_p;
        
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + cantidad + "," + id_precio+ "," + precio + "," + total + ", " + activo_p;
    }
}
