import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class EsercizioZ1 {

    private static ArrayList<String> ville = new ArrayList<>(); // Lista delle ville

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        System.out.println("\nBENVENUTO SU KINGSDELLEVILLE.com");

        do {
            // Menu di scelta
            System.out.println("\n********* MENU *********");
            System.out.println("1. Aggiungi una villa, KING");
            System.out.println("2. Visualizza tutte le ville, KING");
            System.out.println("3. Cerca una villa per nome, KING");
            System.out.println("4. PREMI PER USCIRE, KING");
            System.out.print("Scelta: ");
            
            scelta = controlloInputInteri(scanner); // Metodo per input numerico

            // Gestione delle scelte
            switch (scelta) {
                case 1:
                    aggiungiVilla(scanner);
                    break;
                case 2:
                    visualizzaVille();
                    break;
                case 3:
                    cercaVilla(scanner);
                    break;
                case 4:
                    System.out.println("THE END, CIAOOOOOO KIIIIIIIIIIIING");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        } while (scelta != 4); // Il ciclo continua finché non si sceglie di uscire

        scanner.close();
    }

    // Metodo per aggiungere una villa
    public static void aggiungiVilla(Scanner scanner) {
        System.out.print("\nInserisci il nome della villa: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Inserisci il numero di stanze: ");
        int stanze = controlloInputInteri(scanner);

        System.out.print("La villa ha una piscina? (si/no): ");
        String piscinaStringa = scanner.next().trim().toLowerCase();

        while (!piscinaStringa.equals("si") && !piscinaStringa.equals("no")) {
            System.out.print("Risposta non valida. Inserisci 'si' o 'no': ");
            piscinaStringa = scanner.next().trim().toLowerCase();
            piscinaStringa = normalizzaRisposta(piscinaStringa); //extra fatto da me per input come "sIIIiiii" e "Noooooo"
        }

        boolean piscina = piscinaStringa.equals("si") ? true : false;

        String villa = "Nome: " + nome + ", Stanze: " + stanze + ", Piscina: " + (piscina ? "Si" : "No");
        ville.add(villa);

        System.out.println("Villa aggiunta con successo! yeee");
    }

    // Metodo per visualizzare tutte le ville
    public static void visualizzaVille() {
        if (ville.isEmpty()) {
            System.out.println("Nessuna villa registrata.");
        } else {
            System.out.println("\nLista delle Ville");
            for (String villa : ville) {
                System.out.println("- " + villa);
            }
        }
    }

    
    // Metodo per cercare una villa per nome
    public static void cercaVilla(Scanner scanner) {
        System.out.print("\nInserisci il nome della villa da cercare: ");
        String nomeRicerca = controlloInputStringhe(scanner).toLowerCase();

        boolean trovata = false;
        for (String villa : ville) {
            if (villa.toLowerCase().contains(nomeRicerca)) {
                System.out.println("Villa trovata: " + villa);
                trovata = true;
            }
        }

        if (!trovata) {
            System.out.println("Nessuna villa trovata con il nome inserito.");
        }
    }

    // Metodo per controllare l'input intero
    public static int controlloInputInteri(Scanner scanner) {
        int valore;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Devi inserire un numero intero. Riprova: ");
                scanner.next();
            }
            valore = scanner.nextInt();
            scanner.nextLine();
            if (valore < 0) {
                System.out.print("Il numero non può essere negativo. Riprova: ");
            }
        } while (valore < 0);
        return valore;
    }

    // Metodo per controllare che l'input stringa non sia vuoto
    public static String controlloInputStringhe(Scanner scanner) {
        String valore;
        do {
            valore = scanner.nextLine().trim();
            if (valore.isEmpty()) {
                System.out.print("Input non valido. Inserisci un testo: ");
            }
        } while (valore.isEmpty());
        return valore;
    }

    // Metodo per normalizzare la risposta e rimuovere caratteri ripetuti
    public static String normalizzaRisposta(String input) {
        Set<Character> caratteriUnici = new HashSet<>(); // uso un set per il controllo 
        char[] risultato = new char[input.length()]; // Array per il risultato
        int index = 0; // Contatore per gestire l'array

        for (char c : input.toLowerCase().toCharArray()) {
            if (caratteriUnici.add(c)) { // Aggiunge solo il primo carattere unico trovato
                risultato[index] = c;
                index++;
            }
        }

        return new String(risultato, 0, index); // Crea la stringa solo con i caratteri validi
    }
}
