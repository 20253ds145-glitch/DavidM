import java.util.Scanner;
public class Main   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p = ld(sc, "Peso ", 0.1, 50);
        int d = li(sc, "Distancia (1-2000): ", 1, 2000);
       int s = li(sc, "Servicio (1=Est, 2=Exp): ", 1, 2);
        boolean z = lb(sc, "Zona remota (true/false): ");
        ShippingCalculator c = new ShippingCalculator();
        double sub = c.sub(p, d, s, z);
        double iva = c.iva(sub);
        double tot = c.tot(sub, iva);
        print(s, p, d, z, sub, iva, tot);
        sc.close();
    }
    static double ld(Scanner sc, String m, double min, double max) {
        double v;
        do {
            System.out.print(m);
            v = sc.nextDouble();
        } while (v < min || v > max);
        return v;
    }
    static int li(Scanner sc, String m, int min, int max) {
        int v;
        do {
            System.out.print(m);
            v = sc.nextInt();
        } while (v < min || v > max);
        return v;
    }
    static boolean lb(Scanner sc, String m) {
        System.out.print(m);
        return sc.nextBoolean();
    }
    static void print(int s, double p, int d, boolean z, double sub, double iva, double tot) {
        String servicio;
        if (s == 1) {
            servicio = "Estandar";
        } else {
            servicio = "Express";
        }
        System.out.println("Serv: " + servicio);
        System.out.println("Peso: " + p);
        System.out.println("Dist: " + d);
        System.out.println("Zona: " + z);
        System.out.printf("Sub: $%.2f%n", sub);
        System.out.printf("IVA: $%.2f%n", iva);
        System.out.printf("Tot: $%.2f%n", tot);
    }

}