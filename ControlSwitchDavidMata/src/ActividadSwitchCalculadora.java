import java.util.Scanner;
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una opcion:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Opcion: ");
        int opcion = sc.nextInt();

        System.out.print("Ingrese el valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Ingrese el valor de b: ");
        double b = sc.nextDouble();

        double resultado;
        String operacion;

        switch (opcion) {
            case 1:
                resultado = a + b;
                operacion = "Suma";
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                operacion = "Resta";
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                operacion = "Multiplicacion";
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                operacion = "Division";
                System.out.println("Operacion: " + operacion);
                System.out.println("Valores: a = " + a + ", b = " + b);

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }

    }
}
