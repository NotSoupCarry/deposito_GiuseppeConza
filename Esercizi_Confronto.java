import java.util.Scanner;

public class Esercizi_Confronto {
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);

        while (true) {  
            System.out.print("Inserisci due numeri ");            
            if (scanner.hasNextDouble()) {
                double numero1 = scanner.nextDouble();
                double numero2 = scanner.nextDouble();

                if (numero1 > numero2) {
                    System.out.println("Il numero1 è maggiore del numero2.");
                } else if (numero1 == numero2) {
                    System.out.println("i due numeri sono uguali.");
                } else {
                    System.out.println("Il numero2 è maggiore del numero1..");
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
