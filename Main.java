
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

        System.out.println("Hola elija una funcion: ");
        System.out.println("Bienvenido");
        System.out.println("1. Registrar clientes");
        System.out.println("2. Listar clientes");
        System.out.println("3. Eliminar clientes");
        System.out.println("4. Actualizar datos de clientes");
        System.out.println("5. Listar pedidos de clientes");
        System.out.println("6. Salir");

        int op = read.nextInt();

        switch(op){

            case 1:
                break;

            case 2:
                listarClientes();
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                Pedidos.listarPedidos();
                break;

            case 6:
                System.out.println("Gracias por usarme <3");
                break;

            default:
                System.out.println("Opcion invalida");
        }

        read.close();
    }

    public static List<Clientes> leerClientes() throws IOException {

        List<Clientes> lista = new ArrayList<>();
        File archivo = new File("clientes.csv");

        if (!archivo.exists()) return lista;

        Scanner sc = new Scanner(archivo);

        if (sc.hasNextLine()) sc.nextLine();

        while (sc.hasNextLine()) {

            String[] datos = sc.nextLine().split(",");

            lista.add(new Clientes(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    datos[2],
                    datos[3],
                    Boolean.parseBoolean(datos[4])
            ));
        }

        sc.close();
        return lista;
    }

    public static void listarClientes() throws IOException {

        List<Clientes> lista = leerClientes();

        System.out.println("~~Listado de clientes (activos)~~");

        for (Clientes c : lista) {
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
