public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private int activo;

    public Cliente(int id, String nombre, String apellido, String telefono, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo == 1;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Telefono: " + telefono + " Activo: " + activo;
    }
}