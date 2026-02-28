import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CuentaBancaria cj = new CuentaBancaria();
        double resultado = cj.depositar(cj.depositar);
        System.out.print("este es tu saldo :"+resultado);


    }
}