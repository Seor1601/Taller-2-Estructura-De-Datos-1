
public class Cliente {

    private int id;
    public String nombre;
    public String apellido;
    public String telefono;
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

    public void setActivo(int activo) {
        this.activo = activo;

    }
    @Override

    public String toString() {
        return id + "," + nombre + "," + apellido + "," + telefono + "," + activo;
    }

 }
