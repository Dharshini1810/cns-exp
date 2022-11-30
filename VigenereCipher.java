import java.util.*;
// dharshini
// class vigenereCipher{
//     public static void main(String[] args){
//         //Repeat the key value upto length of plain text 
//         //(pt[i]+key[i])mod26 --> convert this to char 
//         Scanner sc=new Scanner(System.in); 
//         System.out.print("Enter plain text: ");
//         String pt=sc.next(); 
//         System.out.print("Enter key: "); 
//         String key=sc.next(); 
//         String temp="abcdefghijklmnopqrstuvwxyz";
//         int r=0;
//         if(pt.length()%key.length()==0)
//             r=pt.length()/key.length(); 
//         else 
//             r=pt.length()/key.length()+1; 
//         while(r!=0){
//             key+=key;
//             r--;
//         }    
//         key=key.substring(0,pt.length());  
//         for(int i=0;i<pt.length();i++){
//             int s=(temp.indexOf(pt.charAt(i))+temp.indexOf(key.charAt(i)))%26;
//             System.out.print(temp.charAt(s));
//         }
//     }
// }

// santhosh
public class VigenereCipher {

    static String encode(String msg, String key) {
        String res = "";
        msg = msg.toUpperCase();
        for (int i = 0, j = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                continue;
            }
            res += (char) ((ch + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    static String decode(String msg, String key) {
        String res = "";
        msg = msg.toUpperCase();
        for (int i = 0, j = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                continue;
            }
            res += (char) ((ch - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static void main(String[] args) {
        String message = "Message";
        System.out.println("Message is : " + message);
        System.out.println("Encrypted message is: " + encode(message, "SAND"));
        System.out.println("Decrypted message is: " + decode(encode(message, "SAND"), "SAND"));
    }
}