import java.util.Scanner;

public class EsercizioZ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        final int ripetizione = 4; //variabile di quanti input ha l utente
        String[] numeriInseriti = new String[ripetizione];

        String[] giorni = { "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica" };
        System.out.println("Ecco i giorni della settimana: ");

        for (String day : giorni) {
            System.out.print(day + ", ");
        }

        // L'utente deve inserire il numero X volte
        for (int i = 0; i < ripetizione; i++) {
            do {
                System.out.print("\nInserisci un numero (1-7) per vedere il giorno della settimana: ");
                while (!scanner.hasNextInt()) { // Controllo se l'input è un numero
                    System.out.println("Errore! Devi inserire un numero tra 1 e 7.");
                    scanner.next();
                }
                numero = scanner.nextInt();
            } while (numero < 1 || numero > 7); // Ripeti finché l'input non è valido

            numeriInseriti[i] = giorni[numero-1];

            // Mostra il giorno corrispondente
            System.out.println("Il giorno corrispondente è: " + giorni[numero - 1]);
        }

        // Mostra i numeri inseriti alla fine
        System.out.println("\nGiorni inseriti:");
        for (int i = 0; i < numeriInseriti.length; i++) {
            System.out.println("Input " + (i + 1) + ": " + numeriInseriti[i]);
        }

        scanner.close();
    }
}
