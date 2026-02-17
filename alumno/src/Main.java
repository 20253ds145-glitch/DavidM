import java.util.Scanner;

public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: alta(); break;
                case 2: buscar(); break;
                case 3: actualizar(); break;
                case 4: baja(); break;
                case 5: listar(); break;
                case 6: reportes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nMENU");
        System.out.println("1. Alta alumno");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Actualizar promedio");
        System.out.println("4. Baja logica");
        System.out.println("5. Listar activos");
        System.out.println("6. Reportes");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    static void alta() {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id <= 0) {
            System.out.println("ID no valido");
            return;
        }

        if (buscarIndice(id) != -1) {
            System.out.println("ID repetido");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            return;
        }

        System.out.print("Promedio: ");
        double promedio = scanner.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno agregado");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    static void buscar() {

        System.out.print("Buscar ID: ");
        int id = scanner.nextInt();

        int i = buscarIndice(id);

        if (i != -1 && alumnos[i].isActivo()) {
            System.out.println(alumnos[i]);
        } else {
            System.out.println("No encontrado");
        }
    }

    static void actualizar() {

        System.out.print("ID a actualizar: ");
        int id = scanner.nextInt();

        int i = buscarIndice(id);

        if (i != -1 && alumnos[i].isActivo()) {

            System.out.print("Nuevo promedio: ");
            double promedio = scanner.nextDouble();

            if (promedio < 0 || promedio > 10) {
                System.out.println("Promedio invalido");
                return;
            }

            alumnos[i].setPromedio(promedio);
            System.out.println("Promedio actualizado");

        } else {
            System.out.println("No encontrado");
        }
    }

    static void baja() {

        System.out.print("ID a dar de baja: ");
        int id = scanner.nextInt();

        int i = buscarIndice(id);

        if (i != -1 && alumnos[i].isActivo()) {
            alumnos[i].setActivo(false);
            System.out.println("Baja realizada");
        } else {
            System.out.println("No encontrado");
        }
    }

    static void listar() {

        System.out.println("\nALUMNOS ACTIVOS");

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                System.out.println(a);
            }
        }
    }

    static void reportes() {

        double suma = 0;
        int contador = 0;

        Alumno mayor = null;
        Alumno menor = null;
        int mayores8 = 0;

        for (Alumno a : alumnos) {

            if (a != null && a.isActivo()) {

                suma += a.getPromedio();
                contador++;

                if (a.getPromedio() >= 8.0) {
                    mayores8++;
                }

                if (mayor == null || a.getPromedio() > mayor.getPromedio()) {
                    mayor = a;
                }

                if (menor == null || a.getPromedio() < menor.getPromedio()) {
                    menor = a;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        double promedioGeneral = suma / contador;

        System.out.println("\nREPORTES");
        System.out.println("Promedio general: " + promedioGeneral);

        System.out.println("Mayor promedio: " +
                mayor.getId() + " - " +
                mayor.getNombre() + " - " +
                mayor.getPromedio());

        System.out.println("Menor promedio: " +
                menor.getId() + " - " +
                menor.getNombre() + " - " +
                menor.getPromedio());

        System.out.println("Alumnos con promedio >= 8: " + mayores8);
    }

    static int buscarIndice(int id) {

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id) {
                return i;
            }
        }

        return -1;
    }
}
