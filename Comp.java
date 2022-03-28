//INPUT
/*La entrada estará compuesta de múltiples casos de prueba. Cada caso de prueba consiste en las horas de sueño de un participante.
Para cada uno de ellos aparece una primera línea que indica cuántas noches hay que procesar.
A continuación aparece una línea para cada una de esas noches con la hora a la que se fue a dormir y la hora en la que se despertó,
con el formato HH:MM-HH:MM. Ten en cuenta que ningún participante se fue a dormir nunca antes de las 22:00 ni se despertó después de las 10:00.
Además, todas las noches durmieron al menos un minuto.
La entrada terminará cuando el número de noches a calcular del siguiente participante sea cero.

input example:

1
00:00-07:00
2
22:00-10:00
23:58-00:04
0

/*

//OUTPUT
/*Para cada caso de prueba se expresará cuánto tiempo durmió el participante en horas y minutos.
Tanto en las horas como en los minutos, si el valor es menor que 10 se pondrá un 0 delante para que tengan dos dígitos.
Ten presente que el número de minutos deberá ser menor que 60.

Output example:

07:00
12:06

*/

import java.util.Scanner;

public class Comp {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int horas = 0;
        int minutos = 0;
        
        while (true){
            if (n == 0){
                break;
            }

            for(int i = 0; i<n; i++){
            String[] horas_dormidas = s.next().split("-");
            String[] horas_despertadas = s.next().split("-");
            int hora_dormida = Integer.parseInt(horas_dormidas[0].split(":")[0]);
            int minuto_dormida = Integer.parseInt(horas_dormidas[0].split(":")[1]);
            int hora_despertada = Integer.parseInt(horas_despertadas[1].split(":")[0]);
            int minuto_despertada = Integer.parseInt(horas_despertadas[1].split(":")[1]);


            if (hora_dormida < hora_despertada){
                horas += hora_despertada - hora_dormida;
            }
            else if (hora_dormida == hora_despertada){
                if (minuto_despertada > minuto_dormida){
                    horas += 1;
                }
            }
            else if (hora_dormida > hora_despertada){
                horas += 24 - hora_dormida + hora_despertada;
            }
            if (minuto_despertada > minuto_dormida){
                minutos += minuto_despertada - minuto_dormida;
            }
            else if (minuto_despertada < minuto_dormida){
                minutos += 60 - minuto_dormida + minuto_despertada;
                horas -= 1;
            }
            
            }
            

        }

        
        

    }
}