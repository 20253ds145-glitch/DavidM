import java.util.Scanner;

public class prueba {

    Scanner scanner = new Scanner(System.in);
    public int mensaje() {
        System.out.print("dame un numerom");
        int num1= scanner.nextInt();
        System.out.println("dame otro numero ");
        int num2= scanner.nextInt();

        return scanner.nextInt();
    }
    public int suma(int num1 ,int num2  ){


        return num1+num2;
    }

}
