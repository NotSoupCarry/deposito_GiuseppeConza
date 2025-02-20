import java.util.Scanner;

public class Esercizi_Anno {
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);

        while (true) {  
            System.out.print("Inserisci l'anno ");            
            if (scanner.hasNextInt()) {
                int anno = scanner.nextInt();

                if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) 
                    System.out.println("anno bisestile.");                
                 else 
                    System.out.println("anno non bisestile.");
                
                break;
            }                        
            else {
                System.out.println("Input non valido! Devi inserire un numero.");
                scanner.next(); 
            }
        }
        scanner.close();
    }
}
