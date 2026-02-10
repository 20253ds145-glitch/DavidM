import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int limiteIntentos = 7;
        int intentosValidos = 0;
        int erroresRango = 0;
        int erroresNumerico = 0;
        boolean gano = false;
        System.out.println("Adivina el numero entre (1-100) tienes: " + limiteIntentos + " intentos.");
        while (intentosValidos < limiteIntentos && !gano) {
            System.out.println("Intento " + (intentosValidos + 1) + ": ingresa tu numero del 1-100");
            String entrada = scanner.nextLine();
            try {
                int numero = Integer.parseInt(entrada);
                if (numero < 1 || numero > 100) {
                    System.out.println("Error: Numero fuera de rango. Intenta de nuevo.");
                    erroresRango++;
                    continue;
                }
                intentosValidos++;
                if (numero == numeroSecreto) {
                    gano = true;
                    System.out.println("Ganaste El numero secreto era " + numeroSecreto);
                } else if (numero < numeroSecreto) {
                    System.out.println("El numero secreto es mayor.");
                } else {
                    System.out.println("El numero secreto es menor.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se aceptan numeros.");
                erroresNumerico++;
            }
        }
        if (!gano) {
            System.out.println("Perdiste. El numero secreto era: " + numeroSecreto);
        }
        System.out.println("ESTADISTICAS DEL JUEGO:");
        System.out.println("INTENTOS VALIDOS: " + intentosValidos);
        System.out.println("ERRORES DE RANGO: " + erroresRango);
        System.out.println("ERRORES NUMERICOS: " + erroresNumerico);
        scanner.close();
    }
}