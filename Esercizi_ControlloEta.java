import java.util.Scanner;

public class Esercizi_ControlloEta {
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);

        while (true) {  
            System.out.print("Inserisci 'maggiorenne' o 'minorenne' ");            
            if (scanner.hasNext()) {
                String età = scanner.next();

                if (età.trim().toLowerCase().equals("maggiorenne")) {
                    System.out.println("Sei un adulto.");
                } else if (età.trim().toLowerCase().equals("minorenne")) {
                    System.out.println("Sei un minorenne.");
                } else {
                    System.out.println("Input non valido! Devi scrivere 'maggiorenne' o 'minorenne'.");
                }
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
