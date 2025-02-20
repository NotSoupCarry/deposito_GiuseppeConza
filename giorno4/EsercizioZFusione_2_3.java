import java.util.Scanner;

public class EsercizioZFusione_2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Mostra il menu all'utente
            System.out.println("\n--- MENU ---");
            System.out.println("1. giorno della settimana");
            System.out.println("2. numero pari o dispari");
            System.out.println("3. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta;
            while (!scanner.hasNextInt()) {
                System.out.println("Errore! Inserisci un numero valido.");
                scanner.next();
            }
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    stampaGiornoSettimana(scanner);
                    break;
                case 2:
                    verificaPariDispari(scanner);
                    break;
                case 3:
                    System.out.println("CIAOOOOOOOOOOO");
                    System.out.println("the end");
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida! Riprova.");
            }
        }
        scanner.close();
    }

    // Funzione per stampare il giorno della settimana
    private static void stampaGiornoSettimana(Scanner scanner) {
        int numero;
        final int ripetizione = 4; // variabile di quanti input ha l utente

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

            // Mostra il giorno corrispondente
            System.out.println("Il giorno corrispondente è: " + giorni[numero - 1]);
        }
    }

    // Funzione per verificare se un numero è pari o dispari
    private static void verificaPariDispari(Scanner scanner) {
        int num;
        int somma = 0;
        boolean exit = false;
        while (!exit) {
            while (true) {
                System.out.print("Inserisci un numero: ");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    System.out.println("IL NUMERO DEVE ESSERE INTERO");
                    scanner.next();
                }
            }
            if (num % 2 == 0)
                System.out.println("il numero è pari ");
            else
                System.out.println("il numero è dispari ");

            if (num < 0) {
                System.out.println("il numero è negativo... uscita ");
                exit = true;
                break;
            }
            somma += num;
        }
        System.out.println("\nla somma dei numeri inseriti è: " + somma);
    }
}
