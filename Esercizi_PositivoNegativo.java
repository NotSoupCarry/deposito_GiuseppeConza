import java.util.Scanner;

public class Esercizi_PositivoNegativo {
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);

        while (true) {  
            System.out.print("Inserisci un numero intero ");            
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();

                if (numero > 0) {
                    System.out.println("Il numero è positivo.");
                } else if (numero == 0) {
                    System.out.println("Il numero è 0.");
                } else {
                    System.out.println("Il numero è negativo.");
                }
                break;
            }                        
            else {
                System.out.println("Input non valido! Devi inserire un numero intero.");
                scanner.next(); 
            }
        }

        scanner.close();
    }
}
