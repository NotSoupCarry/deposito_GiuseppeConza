import java.util.Scanner;

public class EsercizioZ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.print("Inserisci un numero intero per calcolare la tabellina (o scrivi 'esci' per terminare): ");
            
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                System.out.println("\nTabellina del " + numero + ":");

                // Stampa della tabellina con while
                int i = 1;
                while (i <= 10) {
                    System.out.println(numero + " * " + i + " = " + (numero * i));
                    i++;
                }
                System.out.println();

            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("esci")) { // Controlla se l'utente vuole uscire
                    System.out.println("THE END, GRAZIE PER ESSERE PASSATI");
                    exit = true;
                    break;
                } else {
                    System.out.println("Errore! Devi inserire un numero intero o 'esci' per terminare.");
                }
            }
        }

        scanner.close();
    }
}
