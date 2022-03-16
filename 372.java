import java.util.Scanner;
public class Comp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);        
        
        final int c = s.nextInt()+1;
        for (int i = 0; i < c; i++) {
            StringBuilder str = new StringBuilder(s.nextLine());
            String strr = str.reverse().toString().trim();
            
            char[] palabra = strr.toLowerCase().toCharArray();
            if((palabra.length>0)&& (strr.charAt(strr.length()-1)<97)){
            palabra[0] = (char) (palabra[0]-32);
            }
            if(i != 0){
              System.out.println(String.valueOf(palabra));  
            }
        }
    }

}
