public class ShippingCalculator {
    double sub(double p, int d, int s, boolean z) {

        double t = (s == 1) ? 50 : 90;

        t += p * 12;

        if (d <= 50) t += 20;
        else if (d <= 200) t += 60;
        else t += 120;

        if (z) t *= 1.10;
        return t;
    }
    double iva(double sub) {
        return sub * 0.16;
    }

    double tot(double sub, double iva) {
        return sub + iva;
    }
}
