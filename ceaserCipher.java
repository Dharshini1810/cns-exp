import java.util.*;
public class ceaserCipher
{
    public static String ceaserEncrypt(String pt, int key){
        String cipher="";
        if(key>26){
            key%=26;
        }
        for(int i=0;i<pt.length();i++){
            char c=pt.charAt(i);
            if(Character.isUpperCase(c)){
                if((int)c+key<=(int)'Z')
                    cipher+=(char)((int)c+key);
                else 
                    cipher+=(char)((int)'A'+(((int)c+key)%(int)'Z')-1);
            }
            else if(Character.isLowerCase(c)){
                if((int)c+key<=(int)'z')
                    cipher+=(char)((int)c+key);
                else 
                    cipher+=(char)((int)'a'+(((int)c+key)%(int)'z')-1);
            }
        }
        return cipher;
    }
    public static String ceaserDecrypt(String cipher, int key){
        String pt1="";
        if(key>26){
            key%=26;
        }
        for(int i=0;i<cipher.length();i++){
            char c=cipher.charAt(i);
            if(Character.isUpperCase(c)){
                if((int)c-key>=(int)'A')
                    pt1+=(char)((int)c-key);
                else 
                    pt1+=(char)((int)'Z'-(((int)'A'%((int)c-key)))+1);
            }
            else if(Character.isLowerCase(c)){
                if((int)c-key>=(int)'a')
                    pt1+=(char)((int)c-key);
                else 
                    pt1+=(char)((int)'z'-(((int)'a'%((int)c-key)))+1);
            }
        }
        return pt1;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		System.out.print("Enter plain text: "); 
		String pt=sc.next(); 
		System.out.print("Enter key: ");
		int key=sc.nextInt(); 
		String cipher=ceaserEncrypt(pt,key);
		System.out.println("Cipher text: "+cipher); 
		String pt1=ceaserDecrypt(cipher,key); 
		System.out.print("Plain text: "+pt1);
	}
}
