import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        prueba operacion = new prueba();

        int num1 = operacion.mensaje();
        int num2 =operacion.mensaje();
        int resultado = operacion.suma(num1, num2);

        System.out.println("La suma es: " +resultado );



    }
}