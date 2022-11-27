import java.util.*; 
class playFairCipher{
    public static String generatePlaintext(String pt){
        //generate the new plain text --> replace i with j 
        //pair the letters, if a pair conatins same character, introduce new character 'x' 
        //if len of new pt is odd, add a new charcter 'x' to make it even
        String message="";
        for(int i=0;i<pt.length();i++){
            if(pt.charAt(i)=='j') 
                message+='i'; 
            else 
                message+=pt.charAt(i);
        }
        for(int i=0;i<message.length();i+=2){ 
            if(message.charAt(i) == message.charAt(i+1))
                message=message.substring(0, i + 1)+'x'+message.substring(i + 1);
        } 
        if(message.length()%2==1){
            message+='x';
        } 
        return message;
    } 
    
    public static String getNewPosition(char ch1,char ch2, char[][] m){
        //getting the character in each pair as parameter 
        //getting the position of those char in matrix m(i and j)  
        //check for condition: if both char are present in same row/same col/diff row and col
        int p1=0,p2=0,p3=0,p4=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(m[i][j]==ch1){
                    p1=i; 
                    p2=j;
                } 
                else if(m[i][j]==ch2){
                    p3=i; 
                    p4=j;
                }
            } 
        }    
        // System.out.print(p1+""+p2+""+p3+""+p4);
            String str="";
            if(p1==p3){
                if(p2+1>=5){
                    p2=(p2+1)%5;
                } 
                else{
                    p2=p2+1;
                }
                if(p4+1>=5){
                    p4=(p4+1)%5;
                }
                else{
                    p4=p4+1;
                }
                str=m[p1][p2]+""+m[p1][p4];
            } 
            else if(p2==p4){
                if(p1+1>=5){
                    p1=(p1+1)%5;
                } 
                else{
                    p1=p1+1;
                }
                if(p3+1>=5){
                    p3=(p3+1)%5;
                }
                else{
                    p3=p3+1;
                }
                str=m[p1][p2]+""+m[p3][p2];
            } 
            else{
                str=m[p1][p4]+""+m[p3][p2];
            }
        return str;    
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter plain text: "); 
        String pt=sc.next();
        System.out.print("Enter key: ");
        String key=sc.next(); 
        String pt1=""; 
        int c1=0,c2=0;
        char[][] m=new char[5][5]; 
        
        //Generation of pt1 --> plain text which contains characters that are not present in key 
        //if key contains i/j/i and j  --> pt1 should not contain i and j
        for(int i=0;i<26;i++){  
            String ch=""; 
            ch+=(char)((int)'a'+i); 
            if(ch.equals("i") && key.contains(ch)){
               i+=1; 
            } 
            else if(ch.equals("j") && key.contains(ch) && pt1.contains("i")){
                pt1=pt1.substring(0,pt1.length()-1); 
            } 
            else if(!key.contains(ch)){
                if(!ch.equals("j")) 
                    pt1+=ch; 
            }  
        } 
        
        //Arranging pt1 and key in matrix m
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(c1<key.length()) 
                    m[i][j]=key.charAt(c1++);
                else 
                    m[i][j]=pt1.charAt(c2++);
            } 
        } 
        
        //Display matrix m
        System.out.println("Character Matrix: ");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(m[i][j]+" ");
            } 
            System.out.println();
        }  
        
        //generte new plain text message(pairing up the elements and introducing new variable 'x')
        String message=generatePlaintext(pt);
        
        //generate cipher text with new string 'message'
        System.out.print("Cipher text: ");
        for(int i=0;i<=message.length()-2;i+=2){
            System.out.print(getNewPosition(message.charAt(i),message.charAt(i+1),m));
        }
    }
}