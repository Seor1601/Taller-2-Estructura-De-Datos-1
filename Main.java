
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\nHola elija una funcion:");
            System.out.println("1. Registrar clientes");
            System.out.println("2. Listar clientes");
            System.out.println("3. Eliminar clientes");
            System.out.println("4. Actualizar datos de clientes");
            System.out.println("5. Listar pedidos de clientes");
            System.out.println("6. Salir");

            String s = read.nextLine().trim();
            if (s.isEmpty()) continue;

            try {
                op = Integer.parseInt(s);

                switch (op) {
                    case 1:
                        System.out.println("Pendiente");
                        break;
                    case 2:
                        ClienteCrud.imprimirClientesActivos();
                        break;
                    case 3:
                        System.out.print("ID a eliminar: ");
                        int id = Integer.parseInt(read.nextLine().trim());
                        ClienteCrud.eliminarCliente(id);
                        break;
                    case 4:
                        System.out.println("Pendiente");
                        break;
                    case 5:
                        Pedidos.listarPedidos();
                        break;
                    case 6:
                        System.out.println("Gracias por usar el menu");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                op = 0;
            }
        } while (op != 6);

        read.close();
    }
}