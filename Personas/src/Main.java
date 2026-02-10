import java.util.Scanner;
public class Main {
    static Persona[] personas = new Persona[20];
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion= scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1: alta();
                case 2: buscar();
                case 3: baja();
                case 4: listar();
                case 5: actualizar();
                case 0: System.out.println("saliendo");
                default:System.out.println("opcion invalidad");
            }

        } while (opcion!=0);


    }

    private static void mostrarMenu() {
        System.out.println("MENU");
        System.out.println("1.ALTA");
        System.out.println("2.BUSCAR");
        System.out.println("3.BAJA");
        System.out.println("4.LISTAR");
        System.out.println("5.ACTUALIZAR");
        System.out.println("0.SALIR");
        System.out.println("OPCION");
    }
    static void alta(){
        System.out.println("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id<=0){
            System.out.println("id no valido");
            return;
        }
        if(buscarIndice(id)!=-1){
            System.out.println("id repetido");
            return;

        }
        System.out.println("nombre");
        String nombre =scanner.nextLine();
        if(nombre.isEmpty()){
            System.out.println("no has escrito nada");
            return;
        }
        for(int i=0; i<personas.length;i++){
            if(personas[i]==null){
                personas[i]=new Persona(id,nombre);
                System.out.println("persona agregada");
                return;
            }
        }
        System.out.println("arreglo lleno");

    }

    static void buscar() {

        System.out.print("buscar id: ");
        int id = scanner.nextInt();

        int i = buscarIndice(id);

        if (i != -1 && personas[i].isActiva()) {
            System.out.println("Encontrada: " + personas[i]);
        } else {
            System.out.println("No encontrada");
        }
    }
    static void baja() {

        System.out.print("dar de baja id  ");
        int id = scanner.nextInt();

        int i = buscarIndice(id);

        if (i != -1 && personas[i].isActiva()) {
            personas[i].setActiva(false);
            System.out.println(" Baja realizada");
        } else {
            System.out.println(" No encontrada");
        }
    }
    static void listar() {

        System.out.println("PERSONAS ACTIVAS");

        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p);
            }
        }
    }
    static void actualizar() {

        System.out.print("ID a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int i = buscarIndice(id);

        if (i != -1 && personas[i].isActiva()) {

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Nombre vacío");
                return;
            }

            personas[i].setNombre(nombre);
            System.out.println(" Nombre actualizado");

        } else {
            System.out.println(" No encontrada");
        }
    }
    static int buscarIndice(int id) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}









