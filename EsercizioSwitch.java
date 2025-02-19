import java.util.Scanner;

public class EsercizioSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inserimento iniziale dei dati
        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Inserisci il tuo cognome: ");
        String cognome = scanner.nextLine().trim();

        int password;
        while (true) {
            System.out.print("Inserisci la tua password (deve essere un numero intero): ");
            if (scanner.hasNextInt()) {
                password = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } else {
                System.out.println("Errore! Devi inserire un numero intero.");
                scanner.next(); 
            }
        }

        boolean exit = false; 

        while (!exit) {
            // Stampiamo i dati attuali
            System.out.println("\nDati attuali:");
            System.out.println("1: Nome -> " + nome);
            System.out.println("2: Cognome -> " + cognome);
            System.out.println("3: Password -> " + password);
            System.out.println("4: Esci ");

            int scelta;
            while (true) {
                System.out.print("\nQuale dato vuoi modificare? (1-4): ");
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    scanner.nextLine(); 
                    if (scelta >= 1 && scelta <= 4) {
                        break; 
                    } else {
                        System.out.println("Errore! Devi inserire un numero tra 1 e 4.");
                    }
                } else {
                    System.out.println("Errore! Devi inserire un numero intero!!!!!.");
                    scanner.next(); 
                }
            }

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nuovo nome: ");
                    nome = scanner.nextLine().trim();
                    break;
                case 2:
                    System.out.print("Inserisci il nuovo cognome: ");
                    cognome = scanner.nextLine().trim();
                    break;
                case 3:
                    while (true) {
                        System.out.print("Inserisci la nuova password: ");
                        if (scanner.hasNextInt()) {
                            password = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Errore! Devi inserire un numero intero.");
                            scanner.next(); 
                        }
                    }
                    break;
                case 4:
                    System.out.println("CIAOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!");
                    exit = false;
                    break;
            }
        }

        scanner.close();
    }
}
