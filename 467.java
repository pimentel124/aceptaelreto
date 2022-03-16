import java.util.Scanner;
public class Comp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int c = s.nextInt();
        String str, str2;
        for (int i = 0; i < c; i++) {
            str = s.next(); 
            s.next();
            str2 = s.next();
            
            if (str.toLowerCase().equals(str2.toLowerCase())){
                System.out.println("TAUTOLOGIA");
            }else{
                System.out.println("NO TAUTOLOGIA");
            } 
        }
        
    }
}
