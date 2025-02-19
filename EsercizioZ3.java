import java.util.Scanner;
import java.util.Random;

public class EsercizioZ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroRandom = random.nextInt(100) + 1;
        int num = 0;
        int i = 0;
        System.out.println("PROVA A VINCERE ALLA NOSTRA LOTTERIA.");
        System.out.println("I NUMERI SONO DA 1 A 100 \n");
        do {
            i++; // conteggio dei tentativi

            // Controllo dell'input per evitare errori con valori non numerici
            while (true) {
                System.out.print("Tentativo n." + i + " Inserisci un numero: ");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Errore! Devi inserire un numero intero.");
                    scanner.next();
                }
            }

            // controllo quanto sono distanti i numeri per dare indicazioni al giocatore
            if (num > numeroRandom) {
                if (num - numeroRandom < 10) {
                    System.out.println("POCHINO PIU IN BASSO (fuoco)");
                } else if (num - numeroRandom < 25) {
                    System.out.println("POCO PIU IN BASSO (fuochino)");
                } else {
                    System.out.println("MOLTO PIU IN BASSO (acqua)");
                }
            } else if (num < numeroRandom) {
                if (numeroRandom - num < 10) {
                    System.out.println("POCHINO PIU IN ALTO (fuoco)");
                } else if (numeroRandom - num < 25) {
                    System.out.println("POCO PIU IN ALTO (fuochino)");
                } else {
                    System.out.println("MOLTO PIU IN ALTO (acqua)");
                }
            }

        } while (num != numeroRandom);

        System.out.println("\n ************************************************************ \n");
        System.out.println("HAI VINTOOOOOOO");
        System.out.println("Il numero fortunato era: " + numeroRandom + ". Numero tentativi: " + i);

        scanner.close();
    }
}
