import java.util.*;
class simpleColumnTransposition{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter plain text: ");
        String pt=sc.next(); 
        System.out.print("Enter key size: "); 
        int keysize=sc.nextInt(); 
        System.out.print("Enter the key values: "); 
        ArrayList<Integer> keys=new ArrayList<Integer>();
        for(int i=0;i<keysize;i++){
            keys.add(sc.nextInt());
        } 
        int size=0,c=0;
        if(pt.length()%keysize!=0){
            size=(pt.length()/keysize)+1;
        }else{
            size=(pt.length()/keysize);
        }    
        char[][] m=new char[size][keysize]; 
        outer:
        for(int i=0;i<size;i++){
            for(int j=0;j<keysize;j++){
                if(c<pt.length()){
                    m[i][j]=pt.charAt(c++);
                } 
                else{
                    break outer;
                }
            }
        } 
        System.out.println("The key matrix: ");
        for(int i=0;i<size;i++){
            for(int j=0;j<keysize;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        String s="";
        for(int i=1;i<=keys.size();i++){
            for(int j=0;j<size;j++){
                s+=m[j][keys.indexOf(i)];
            }
        }
        System.out.print("Cipher text: "+s);
    }
}