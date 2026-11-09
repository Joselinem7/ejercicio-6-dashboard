// Ejercicio 6 - Joseline Mazariegos
// Vista de consola y punto de inicio.
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        dashboard.cargarCatalogo();
        Controlador controlador = new Controlador(dashboard);
        Scanner entrada = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0 && entrada.hasNextLine()) {
            System.out.println("\nDASHBOARD - EJERCICIO 6");
            System.out.println("1. Listar widgets\n2. Buscar por ID\n3. Buscar por nombre");
            System.out.println("4. Ordenar por memoria\n5. Hacer clic\n6. Actualizar interactivos\n0. Salir");
            try {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(entrada.nextLine().trim());
                switch (opcion) {
                    case 1: System.out.println(controlador.listar()); break;
                    case 2:
                        System.out.print("ID: ");
                        System.out.println(controlador.buscar(Integer.parseInt(entrada.nextLine().trim())));
                        break;
                    case 3:
                        System.out.print("Nombre completo: ");
                        System.out.println(controlador.buscar(entrada.nextLine()));
                        break;
                    case 4: System.out.println(controlador.ordenar()); break;
                    case 5:
                        System.out.print("ID: ");
                        System.out.println(controlador.hacerClic(Integer.parseInt(entrada.nextLine().trim())));
                        break;
                    case 6: System.out.println(controlador.actualizarTodos()); break;
                    case 0: System.out.println("Hasta luego."); break;
                    default: System.out.println("Opcion fuera del menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Escribe un numero entero valido.");
            } catch (java.util.NoSuchElementException e) {
                opcion = 0;
            }
        }
        entrada.close();
    }
}
