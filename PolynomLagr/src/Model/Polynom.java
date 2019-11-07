package Model;

public class Polynom {
    public double[] coef;

    public Polynom(double[] coef) {
        this.coef = coef;
    }

    public int getlength() {
        return coef.length;
    }

    public static Polynom sum(Polynom a, Polynom b) {
        int alenght;
        int blenght;
        alenght = a.getlength();
        blenght = b.getlength();
        int clength;
        if (alenght > blenght) {
            clength = alenght;
        } else clength = blenght;
        double rez[] = new double[clength];
        for (int i = 0; i < alenght; i++) {
            rez[i] += a.coef[i];
        }
        for (int i = 0; i < blenght; i++) {
            rez[i] += b.coef[i];
        }
        Polynom c = new Polynom(rez);
        return c;
    }

    public static Polynom mult(Polynom a, Polynom b) {
        int rez = a.getlength() + b.getlength() - 1;
        double[] result = new double[rez];
        for (int i = 0; i < a.getlength(); i++) {
            for (int j = 0; j < b.getlength(); j++) {
                result[i + j] += a.coef[i] * b.coef[j];
            }
        }
        return new Polynom(result);
    }

    private static double power(double point, int st) {
        double result = 1;
        for (int i = 0; i < st; i++) {
            result *= point;
        }
        return result;
    }

    public static double valueOnPoint(Polynom a, double point) {
        double result = 0;
        for (int i = 0; i < a.getlength(); i++) {
            double t = 0;
            result += a.coef[i] * power(point, i);
        }
        return result;
    }

    public static Polynom mult(Polynom polynom, double num) {
        double[] tempArray = new double[1];
        tempArray[0] = num;
        Polynom polynom1 = new Polynom(tempArray);
        return Polynom.mult(polynom, polynom1);
    }

    @Override
   public String toString() {
        String result = "";
        for (int i = coef.length - 1; i >= 0; i--) {
            if (i == coef.length - 1) {
                result += coef[i] + "x^" + i;
            } else {
                if (i > 1) {
                    if (coef[i] == 0) {
                        continue;
                    } else {
                        if (coef[i] > 0) {
                            result += " + " + coef[i] + "x^" + i;
                        } else
                            result += coef[i] + "x^" + i;
                    }
                } else {
                    if (i == 1) {
                        result += coef[i] + "x";
                    } else
                        result += coef[i];
                }
            }
        }
        return result;
    }
}
