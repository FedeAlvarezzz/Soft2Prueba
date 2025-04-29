import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservas {
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar algunas reservas de ejemplo
        inicializarReservas();

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    listarPropiedades();
                    break;
                case 2:
                    verificarCancelacion();
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el sistema! Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nOperaciones del sistema");
        System.out.println("1. Listar propiedades.");
        System.out.println("2. Ver si es posible cancelar reserva.");
        System.out.println("3. Salir.");
        System.out.print("> ");
    }

    private static void inicializarReservas() {
        reservas.add(new Reserva("Apartamento de 3 habitaciones en el sur de la ciudad", 1, 5, 7));
        reservas.add(new Reserva("Habitación con cama doble", 2, 2, 2));
        reservas.add(new Reserva("Casa campestre exclusiva", 3, 10, 5));
    }

    private static void listarPropiedades() {
        System.out.println("\n=== LISTADO DE PROPIEDADES ===");
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            System.out.println("Nombre: " + r.getNombre() +
                    ", Tipo: " + obtenerTipoTexto(r.getTipo()) +
                    ", Huéspedes: " + r.getNumHuespedes());
        }
    }

    private static String obtenerTipoTexto(int tipo) {
        switch (tipo) {
            case 1: return "Apartamento";
            case 2: return "Habitación";
            case 3: return "Casa";
            default: return "Desconocido";
        }
    }

    private static void verificarCancelacion() {
        System.out.println("\n=== VERIFICAR CANCELACIÓN DE RESERVA ===");

        System.out.println("¿Cuántos días faltan para el inicio de la reserva?");
        System.out.print("> ");
        int diasFaltantes = Integer.parseInt(scanner.nextLine());

        System.out.println("¿Qué tipo de propiedad es? (1 = Apartamento, 2 = Habitación, 3 = Casa)");
        System.out.print("> ");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (diasFaltantes < 3) {
            System.out.println("No se puede cancelar la reserva");
            System.out.println("No se puede cancelar si los días que faltan son menor a 3");
        } else if (tipo == 1 || tipo == 3) {
            System.out.println("No se puede cancelar la reserva");
            System.out.println("No se pueden cancelar si el tipo es Apartamento o Casa");
        } else {
            System.out.println("Es posible cancelar la reserva.");
        }
    }
}

class Reserva {
    private String nombre;
    private int tipo; // 1=Apartamento, 2=Habitación, 3=Casa
    private int numHuespedes;
    private int diasHastaInicio;

    public Reserva(String nombre, int tipo, int numHuespedes, int diasHastaInicio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numHuespedes = numHuespedes;
        this.diasHastaInicio = diasHastaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public int getNumHuespedes() {
        return numHuespedes;
    }

    public int getDiasHastaInicio() {
        return diasHastaInicio;
    }
}