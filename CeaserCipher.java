public class CeaserCipher {

    public static String encrypt(String msg, int offset) {
        offset = offset % 26;
        StringBuilder encodedString = new StringBuilder();
        for (char i : msg.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encodedString.append((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encodedString.append((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else {
                encodedString.append(i);
            }
        }
        return encodedString.toString();
    }

    public static String decrypt(String msg, int offset) {
        return encrypt(msg, 26 - offset);
    }

    public static void main(String[] args) {
        String msg = "Information";
        System.out.println("Message is " + msg);
        System.out.println("Encrypted string is " + encrypt(msg, 3));
        System.out.println("Decrypted string is " + decrypt(encrypt(msg, 3), 3));
    }
}