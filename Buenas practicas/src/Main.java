import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero = pedirEntero();
        int resultado = sumarHastaN(numero);
        mostrarResultado(numero, resultado);
    }

    public static int pedirEntero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un numero entero: ");
        return scanner.nextInt();
    }

    public static int sumarHastaN(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }

    public static void mostrarResultado(int numero, int resultado) {
        System.out.println("La suma de 1 hasta " + numero + " es: " + resultado);
    }
}
