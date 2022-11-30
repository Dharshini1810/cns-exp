
import java.math.BigInteger;
import java.security.*;
// import java.security.NoSuchAlgorithmException;

public class SHA {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest("message".getBytes());
        BigInteger num = new BigInteger(1, messageDigest);
        String hashValue = num.toString(16);
        while (hashValue.length() < 32) {
            hashValue = "0" + hashValue;
        }
        System.out.println("Hash Value is: " + hashValue);
    }
}