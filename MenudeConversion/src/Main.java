
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int opcion;
        int ctof =0,ftoc=0,kmtomi=0,mitokm=0;
        do{
            System.out.println("MENU");
            System.out.println("1.C a F");
            System.out.println("2.F a C");
            System.out.println("3.KM a Millas");
            System.out.println("4.Millas a KM");
            System.out.println("5.Salir");
            System.out.println("Opcion");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada invalida. Opcion: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            if (opcion == 5) break;
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opcion fuera de rango");
                continue;
            }

            System.out.print("Ingrese valor: ");
            
            while (!scanner.hasNextDouble()) {
                System.out.print("Valor invalido. Intente: ");
                scanner.next();
            }
            double v = scanner.nextDouble();

            switch (opcion) {
                case 1 -> { System.out.println(v + " °C = " + (v * 9/5 + 32) + " °F"); ctof++; }
                case 2 -> { System.out.println(v + " °F = " + ((v - 32) * 5/9) + " °C"); ftoc++; }
                case 3 -> { System.out.println(v + " Km = " + (v * 0.621371) + " Mi"); kmtomi++; }
                case 4 -> { System.out.println(v + " Mi = " + (v / 0.621371) + " Km"); mitokm++; }
            }

        } while (true);

        int total = ctof + ftoc + kmtomi + mitokm;


        System.out.println("Total conversiones: " + total);
        System.out.println("°C -> °F: " + ctof);
        System.out.println("°F -> °C: " + ftoc);
        System.out.println("Km -> Mi: " + kmtomi);
        System.out.println("Mi -> Km: " + mitokm);
    }
}























