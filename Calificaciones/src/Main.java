import java.util.Scanner;

public class Main{

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg + ": ");
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg + " " + min + " - " + max + ": ");
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Intente de nuevo.");
        }
    }
    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg + " " + min + " - " + max + ": ");
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Intente de nuevo.");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg + " (true o false): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("true")) return true;
            if (entrada.equals("false")) return false;
            System.out.println("Escriba true o false.");
        }
    }

    public static void imprimirReporte(
            String nombre,
            double p1,
            double p2,
            double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCal,
            String estado) {

        System.out.println(" REPORTE FINAL");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.printf("Promedio: %.2f%n", promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entrego proyecto: " + entregoProyecto);
        System.out.printf("Calificacion final: %.2f%n", finalCal);
        System.out.println("Estado: " + estado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Nombre del alumno");
        double p1 = leerDoubleEnRango(sc, "Parcial 1", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "entregaste proyecto?  ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double finalCal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCal, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCal, estado);

        sc.close();
    }
}