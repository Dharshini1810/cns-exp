public class RSA {
    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }

    public static void main(String[] args) {
        int p = 3;
        int q = 7;
        double msg = 12;
        int n = p * q;
        int z = (p - 1) * (q - 1), e;

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }

        int k = 2;
        double d = (1 + (k * z)) / e;
        double c = Math.pow(msg, e);
        c = c % n;
        System.out.println("Encrypted data = " + c);

        double m = Math.pow(c, d);
        m = m % n;
        System.out.println("Original message = " + m);
    }
}
