import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EsercizioZ5 {

    private static ArrayList<int[]> spedizioni = new ArrayList<>(); // Lista delle spedizioni
    private static final String[] COLORI = { "Rosso", "Blu", "Verde", "Nero" }; // Array dei colori disponibili

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        System.out.println("\nBENVENUTO SU PENCILZONE.com");
        do {
            // Menu di scelta
            System.out.println("\n********* MENU *********");
            System.out.println("1. Aggiungi una spedizione");
            System.out.println("1. Aggiungi una spedizione random");
            System.out.println("3. Mostra tutte le spedizioni");
            System.out.println("4. Calcola totali per colore");
            System.out.println("5. Ricerca spedizione per colore");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:
                    // Inserimento manuale della spedizione
                    System.out.print("\nInserisci quantità di penne Rosse: ");
                    int rosso = controlloInputInteri(scanner);
                    System.out.print("Inserisci quantità di penne Blu: ");
                    int blu = controlloInputInteri(scanner);
                    System.out.print("Inserisci quantità di penne Verdi: ");
                    int verde = controlloInputInteri(scanner);
                    System.out.print("Inserisci quantità di penne Nere: ");
                    int nero = controlloInputInteri(scanner);
                    scanner.nextLine();
                    aggiungiSpedizione(rosso, blu, verde, nero);
                    break;
                case 2:
                    // Creazione di una spedizione con valori casuali
                    Random random = new Random();
                    aggiungiSpedizione(random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + 1,
                            random.nextInt(50) + 1);
                    break;
                case 3:
                    // Mostra tutte le spedizioni
                    mostraTutteLeSpedizioni();
                    break;
                case 4:
                    // Calcola il totale delle penne per ogni colore
                    calcolaTotali();
                    break;
                case 5:
                    // Ricerca spedizione per colore con validazione dell'input
                    String colore;
                    do {
                        System.out.print("Inserisci il colore da cercare tra 'Rosso', 'Verde', 'Blu' e 'Nero': ");
                        colore = scanner.nextLine().trim();
                    } while (!colore.equalsIgnoreCase("Rosso") && !colore.equalsIgnoreCase("Verde")
                            && !colore.equalsIgnoreCase("Blu") && !colore.equalsIgnoreCase("Nero"));
                    ricercaPerColore(colore);
                    break;
                case 6:
                    // Uscita dal programma
                    System.out.println("THE END, CIAOOOOOOOOOO");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 6);
        scanner.close();
    }

    // Metodo per controllare l'input intero e assicurarsi che sia un numero non negativo
    public static int controlloInputInteri(Scanner scanner) {
        int valore;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Devi inserire un numero intero. Riprova ");
                scanner.next();
            }
            valore = scanner.nextInt();
            if (valore < 0) {
                System.out.print("Il numero non può essere negativo. Riprova: ");
            }
        } while (valore < 0);
        return valore;
    }

    // Metodo per aggiungere una spedizione con parametri variabili
    public static void aggiungiSpedizione(int... penne) {
        int[] nuovaSpedizione = new int[COLORI.length];
        for (int i = 0; i < COLORI.length; i++) {
            nuovaSpedizione[i] = penne[i];
        }
        spedizioni.add(nuovaSpedizione);
        System.out.println("\nNuova spedizione aggiunta con successo!");
    }

    // Metodo per mostrare tutte le spedizioni registrate
    public static void mostraTutteLeSpedizioni() {
        if (spedizioni.isEmpty()) {
            System.out.println("\nNessuna spedizione disponibile.");
            return;
        }
        for (int i = 0; i < spedizioni.size(); i++) {
            System.out.println("\nSpedizione " + (i + 1) + ":");
            for (int j = 0; j < COLORI.length; j++) {
                System.out.println(COLORI[j] + ": " + spedizioni.get(i)[j] + " penne");
            }
            System.out.println();
        }
    }

    // Metodo per calcolare il totale delle penne spedite per ogni colore
    public static void calcolaTotali() {
        int[] totali = new int[COLORI.length];
        for (int[] spedizione : spedizioni) {
            for (int i = 0; i < COLORI.length; i++) {
                totali[i] += spedizione[i];
            }
        }
        System.out.println("\nTotale penne spedite per colore:");
        for (int i = 0; i < COLORI.length; i++) {
            System.out.println(COLORI[i] + ": " + totali[i] + " penne");
        }
    }

    // Metodo per cercare una spedizione contenente almeno una penna di un determinato colore
    public static void ricercaPerColore(String colore) {
        int indiceColore = -1;
        for (int i = 0; i < COLORI.length; i++) {
            if (COLORI[i].equalsIgnoreCase(colore)) {
                indiceColore = i;
                break;
            }
        }
        boolean trovato = false;
        for (int i = 0; i < spedizioni.size(); i++) {
            if (spedizioni.get(i)[indiceColore] > 0) {
                System.out.println("\nSpedizione " + (i + 1) + " contiene penne di colore " + colore);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNessuna spedizione contiene penne di colore " + colore);
        }
    }
}
