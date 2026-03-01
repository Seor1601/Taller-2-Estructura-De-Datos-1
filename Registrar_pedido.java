public static void crearPedido(Usuario usuario) throws IOException {
    FileWriter fw = new FileWriter("Pedidos.CSV", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(usuario.toString());
    bw.newLine();
    bw.close();
}
public class Usuario {
    private int precio;
    private String nombre;
    private int cantidad;
    private int id;
    private int id_pedido;
    private int activo_p;

    public Usuario(int precio, String nombre, int cantidad, int id_pedido, int activo_p) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.id_pedido = id_pedido;
        this.total= cantidad * precio;
        this.activo_p = activo_p;
    }

    @Override
    public String toString() {
        return nombre + "," + cantidad + "," + precio + "," + total;
    }
}