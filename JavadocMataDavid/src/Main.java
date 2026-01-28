import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1) Calcular IMC");
            System.out.println("2) Calcular Area de un rectangulo");
            System.out.println("3) Convertir C a F");
            System.out.println("4) Calcular área de un circulo");
            System.out.println("5) Salir");
            System.out.print("Elige una opcion: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calcularIMC();
                    break;
                case 2:
                    areaRectangulo();
                    break;
                case 3:
                    convertirCelsiusAFahrenheit();
                    break;
                case 4:
                    areaCirculo();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion inválida");
            }

        } while (choice != 5);
    }

    public static void calcularIMC() {
        System.out.print("Ingresa tu peso : ");
        double peso = scanner.nextDouble();

        System.out.print("Ingresa tu altura : ");
        double altura = scanner.nextDouble();
        double imc = peso / (altura * altura);
        System.out.println("Tu IMC es: " + imc);
    }

    public static void areaRectangulo() {
        System.out.print("Ingresa la base: ");
        double base = scanner.nextDouble();

        System.out.print("Ingresa la altura: ");
        double altura = scanner.nextDouble();

        double area = base * altura;
        System.out.println("area del rectángulo: " + area);
    }


    public static void convertirCelsiusAFahrenheit() {
        System.out.print("Ingresa grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Grados Fahrenheit: " + fahrenheit);
    }

    public static void areaCirculo() {
        System.out.print("Ingresa el radio: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * radio * radio;
        System.out.println("area del círculo: " + area);
    }
}