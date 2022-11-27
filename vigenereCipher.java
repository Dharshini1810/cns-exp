import java.util.*; 
class Main{
    public static void vigenereCipher(String[] args){
        //Repeat the key value upto length of plain text 
        //(pt[i]+key[i])mod26 --> convert this to char 
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter plain text: ");
        String pt=sc.next(); 
        System.out.print("Enter key: "); 
        String key=sc.next(); 
        String temp="abcdefghijklmnopqrstuvwxyz";
        int r=0;
        if(pt.length()%key.length()==0)
            r=pt.length()/key.length(); 
        else 
            r=pt.length()/key.length()+1; 
        while(r!=0){
            key+=key;
            r--;
        }    
        key=key.substring(0,pt.length());  
        for(int i=0;i<pt.length();i++){
            int s=(temp.indexOf(pt.charAt(i))+temp.indexOf(key.charAt(i)))%26;
            System.out.print(temp.charAt(s));
        }
        
    }
}