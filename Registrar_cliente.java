
public static void crearCliente(Cliente cliente)throws IOException {
    FileWriter fw = new FileWriter("Clientes.CSV", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(cliente.toString());
    bw.newLine();
    bw.close();
}
public class Cliente {
    private int telefono;
    private String nombre;
    private String apellido;
    private int activo_c;
    private int id_cliente;

    public Cliente(int telefono, String nombre, String apellido, int activo_c,int id_cliente) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activo = activo;
        this.id = id_cliente;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + apellido + "," + telefono + "," +activo;
    }
}
