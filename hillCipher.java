import java.util.*; 
class hillCipher{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter plain text: "); 
        String pt=sc.next(); 
        System.out.print("Enter key: "); 
        String key=sc.next(); 
        int c=0,c1=0;
        String temp="abcdefghijklmnopqrstuvwxyz"; 
        int[][] m=new int[9][9]; 
        int[] t=new int[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m[i][j]=temp.indexOf(key.charAt(c++));
            }
        } 
        for(int i=0;i<3;i++){
            t[i]=temp.indexOf(pt.charAt(c1++));
        } 
        for(int i=0;i<3;i++){
            int s=0;
            s+=m[i][0]*t[0]+m[i][1]*t[1]+m[i][2]*t[2]; 
            s%=26; 
            System.out.print(temp.charAt(s));
        }
    }
}