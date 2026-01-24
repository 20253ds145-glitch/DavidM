import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.println("dame tu edad");
        edad = sc.nextInt();
        System.out.print("eres estudiante?: ");
        boolean esEstudiante = sc.nextBoolean();
        if (edad < 0 || edad > 120) {
            System.out.println("Edad invalida");
        } else if (edad < 12) {

            System.out.println("tarifa de 50");
        } else if (edad >= 12 && edad <= 17) {

            if (esEstudiante) {
                System.out.println("tienes"+edad);
                System.out.println("eres estudiante");
                System.out.println("tarifa de 60");
            } else {
                System.out.println("tienes"+edad);
                System.out.println("NO eres estudiante");
                System.out.println("tarifa de 80");
            }
        } else if (edad>=18){
            if (esEstudiante){
                System.out.println("tienes"+edad);
                System.out.println("eres estudiante");
                System.out.println("tarifa de 90");

            }else{
                System.out.println("tienes"+edad);
                System.out.println("NO eres estudiante");
                System.out.println("tarifa de 120");
            }


        }

    }
}