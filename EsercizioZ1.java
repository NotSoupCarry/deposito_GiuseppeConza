import java.util.Scanner;

public class EsercizioZ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somma = 0; // Variabile per la somma dei numeri
        int num;

        System.out.println("Inserisci numeri interi positivi per sommarli.");
        System.out.println("Inserisci un numero negativo per FINIRE TUTTO E DISTRUGGERE L'UNIVERSO.");

        boolean exit = false;
        do {
            while (true) { // Ciclo per garantire input valido
                System.out.print("Inserisci un numero: ");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Errore! Devi inserire un numero intero.");
                    scanner.next(); // Scarta l'input errato
                }
            }

            // Se il numero è negativo, interrompo il ciclo
            if (num < 0) {
                System.out.println("\nNumero negativo inserito.\nTHE END.");
                exit = true;
                break;
            }

            // Sommo solo i numeri positivi
            somma += num;
        } while (!exit);

        // Stampa del risultato finale
        System.out.println("La somma dei numeri inseriti è: " + somma);

        scanner.close();
    }
}
