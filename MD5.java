import java.security.*;
import java.math.BigInteger;

public class MD5 {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest("message".getBytes());
        BigInteger num = new BigInteger(1, messageDigest);
        String hashValue = num.toString(16);
        while (hashValue.length() < 32) {
            hashValue = "0" + hashValue;
        }
        System.out.println("Hash Value is: " + hashValue);
    }
}
