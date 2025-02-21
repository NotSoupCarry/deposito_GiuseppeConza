import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioZ1EXTRA {
    private static ArrayList<String[]> strutture = new ArrayList<>(); // Lista delle strutture (matrice)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        System.out.println("\nBENVENUTO SU KINGSDELLEVILLE.com");

        do {
            // Menu di scelta
            System.out.println("\n********* MENU *********");
            System.out.println("1. Aggiungi una villa");
            System.out.println("2. Aggiungi un appartamento");
            System.out.println("3. Aggiungi una camera");
            System.out.println("4. Visualizza tutte le strutture");
            System.out.println("5. Cerca una struttura per nome");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");

            scelta = controlloInputInteri(scanner); // Metodo per input numerico

            // Gestione delle scelte
            switch (scelta) {
                case 1:
                    aggiungiVilla(scanner);
                    break;
                case 2:
                    aggiungiAppartamento(scanner);
                    break;
                case 3:
                    aggiungiCamera(scanner);
                    break;
                case 4:
                    visualizzaStrutture();
                    break;
                case 5:
                    cercaStruttura(scanner);
                    break;
                case 6:
                    System.out.println("the end");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        } while (scelta != 6); // Il ciclo continua finché non si sceglie di uscire

        scanner.close();
    }

    // Metodo per aggiungere una villa
    public static void aggiungiVilla(Scanner scanner) {
        System.out.print("\nInserisci il nome della villa: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Inserisci il numero di stanze: ");
        int stanze = controlloInputInteri(scanner);

        System.out.print("La villa ha una piscina? (true/false): ");
        boolean piscina = controlloBoolean(scanner);

        
        String[] villa = { "Villa", nome, String.valueOf(stanze), (piscina ? "si" : "no")};
        strutture.add(villa);

        System.out.println("Villa aggiunta con successo!");
    }

    // Metodo per aggiungere un appartamento
    public static void aggiungiAppartamento(Scanner scanner) {
        System.out.print("\nInserisci il nome dell'appartamento: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Inserisci il numero di stanze: ");
        int stanze = controlloInputInteri(scanner);

        System.out.print("Inserisci il numero di letti: ");
        int letti = controlloInputInteri(scanner);

        String[] appartamento = { "Appartamento", nome, String.valueOf(stanze), String.valueOf(letti) };
        strutture.add(appartamento);

        System.out.println("Appartamento aggiunto con successo!");
    }

    // Metodo per aggiungere una camera
    public static void aggiungiCamera(Scanner scanner) {
        System.out.print("\nInserisci il nome della camera: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Inserisci il numero di stanze: ");
        int stanze = controlloInputInteri(scanner);

        System.out.print("La camera ha il letto super figo top n.1? (si/no): ");
        boolean lettoTop = controlloBoolean(scanner);

        String[] camera = { "Camera", nome, String.valueOf(stanze), String.valueOf(lettoTop) };
        strutture.add(camera);

        System.out.println("Camera aggiunta con successo!");
    }

    // Metodo per visualizzare tutte le strutture
    public static void visualizzaStrutture() {
        if (strutture.isEmpty()) {
            System.out.println("Nessuna struttura registrata.");
        } else {
            System.out.println("\nLista delle Strutture ");
            for (String[] struttura : strutture) {
                System.out.print("- Tipo: " + struttura[0] + ", Nome: " + struttura[1] + ", Stanze: " + struttura[2]);
                if (struttura[0].equals("Villa")) {
                    System.out.println(", Piscina: " + struttura[3]);
                } else if (struttura[0].equals("Appartamento")) {
                    System.out.println(", Letti: " + struttura[3]);
                } else {
                    System.out.println(", letto super figo top n.1: " + struttura[3]);
                }
            }
        }
    }

    // Metodo per cercare una struttura per nome
    public static void cercaStruttura(Scanner scanner) {
        System.out.print("\nInserisci il nome della struttura da cercare: ");
        String nomeRicerca = controlloInputStringhe(scanner).toLowerCase();

        boolean trovata = false;
        for (String[] struttura : strutture) {
            if (struttura[1].toLowerCase().contains(nomeRicerca)) {
                System.out.print("Struttura trovata: Tipo: " + struttura[0] + ", Nome: " + struttura[1] + ", Stanze: " + struttura[2]);
                if (struttura[0].equals("Villa")) {
                    System.out.println(", Piscina: " + struttura[3]);
                } else if (struttura[0].equals("Appartamento")) {
                    System.out.println(", Letti: " + struttura[3]);
                } else {
                    System.out.println(", letto super figo top n.1: " + struttura[3]);
                }
                trovata = true;
            }
        }

        if (!trovata) {
            System.out.println("Nessuna struttura trovata con il nome inserito.");
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
            scanner.nextLine(); // Consuma il newline per evitare problemi
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

    // Metodo per controllare input si/no
    public static String controlloSiNo(Scanner scanner) {
        String valore;
        do {
            valore = scanner.next().trim().toLowerCase();
        } while (!valore.equals("si") && !valore.equals("no"));
        return valore;
    }

    // Metodo per controllare input booleano
    public static boolean controlloBoolean(Scanner scanner) {
        while (!scanner.hasNextBoolean()) {
            System.out.print("Devi inserire true o false. Riprova: ");
            scanner.next();
        }
        return scanner.nextBoolean();
    }
}
