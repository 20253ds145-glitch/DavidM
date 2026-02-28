import java.util.Scanner;

public class CuentaBancaria {

    private String titular;
    private double saldo ;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public double depositar(double cantidad){
        double cuenta = 0;
        System.out.print("cuanto dinero vas a depositar?:");
         cuenta+=cantidad;
         return cantidad;

    }





}
