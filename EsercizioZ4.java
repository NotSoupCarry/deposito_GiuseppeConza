import java.util.Scanner;

public class EsercizioZ4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fase di registrazione
        String nomeRegistrato, passwordRegistrata;
        int etaRegistrata;

        System.out.println("\nRegistrazione.");
        // controllo sull input nome
        do {
            System.out.print("Inserisci il tuo nome: ");
            nomeRegistrato = scanner.nextLine().trim();
            if (nomeRegistrato.isEmpty()) {
                System.out.println("Errore! Il nome non può essere vuoto.");
            }
        } while (nomeRegistrato.isEmpty());

        // controllo sull input password
        do {
            System.out.print("Inserisci la tua password: ");
            passwordRegistrata = scanner.nextLine().trim();
            if (passwordRegistrata.isEmpty()) {
                System.out.println("Errore! La password non può essere vuota.");
            }
        } while (passwordRegistrata.isEmpty());

        // controllo sull input età
        while (true) {
            System.out.print("Inserisci la tua età: ");
            if (scanner.hasNextInt()) {
                etaRegistrata = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Errore! Devi inserire un numero intero per l'età.");
                scanner.next();
            }
        }

        // Fase di login
        System.out.println("\nLogin.");
        boolean accessoConsentito = false;
        final int tentativiMax = 3; // constante tentativi massimi
        for (int i = 1; i <= tentativiMax; i++) {
            System.out.println("\nTentativo di accesso " + i + " di " + tentativiMax);
            String nomeLogin, passwordLogin;
            int etaLogin;

            // controllo sull input nome
            do {
                System.out.print("Inserisci il nome: ");
                nomeLogin = scanner.nextLine().trim();
                if (nomeLogin.isEmpty()) {
                    System.out.println("Errore! Il nome non può essere vuoto.");
                }
            } while (nomeLogin.isEmpty());

            // controllo sull input password
            do {
                System.out.print("Inserisci la password: ");
                passwordLogin = scanner.nextLine().trim();
                if (passwordLogin.isEmpty()) {
                    System.out.println("Errore! La password non può essere vuota.");
                }
            } while (passwordLogin.isEmpty());

            // controllo input sull'età
            while (true) {
                System.out.print("Inserisci la tua età: ");
                if (scanner.hasNextInt()) {
                    etaLogin = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Errore! Devi inserire un numero intero per l'età.");
                    scanner.next();
                }
            }

            // Verifica credenziali
            if (nomeLogin.toLowerCase().equals(nomeRegistrato) && passwordLogin.equals(passwordRegistrata)
                    && etaLogin == etaRegistrata) {
                System.out.println("\nAccesso consentito! Benvenuto " + nomeRegistrato + "!");
                accessoConsentito = true;
                boolean uscire = false;
                while (!uscire) {
                    System.out.println("\n--- MENU MODIFICA DATI ---");
                    System.out.println("1 - Modifica Nome");
                    System.out.println("2 - Modifica Password");
                    System.out.println("3 - Modifica Età");
                    System.out.println("4 - Esci");
                    System.out.print("Seleziona un'opzione: ");

                    int scelta;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            scelta = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Errore! Inserisci un numero valido.");
                            scanner.next();
                        }
                    }

                    switch (scelta) {
                        case 1: // Modifica Nome
                            System.out.println("vecchio nome:  " + nomeRegistrato);
                            do {
                                System.out.print("Inserisci il nuovo nome: ");
                                nomeRegistrato = scanner.nextLine().trim();
                                if (nomeRegistrato.isEmpty()) {
                                    System.out.println("Errore! Il nome non può essere vuoto.");
                                }
                            } while (nomeRegistrato.isEmpty());
                            System.out.println("Nome aggiornato con successo!");
                            break;
                        case 2: // Modifica Password
                            System.out.println("vecchia password:  " + passwordRegistrata);
                            do {
                                System.out.print("Inserisci la nuova password: ");
                                passwordRegistrata = scanner.nextLine().trim();
                                if (passwordRegistrata.isEmpty()) {
                                    System.out.println("Errore! La password non può essere vuota.");
                                }
                            } while (passwordRegistrata.isEmpty());
                            System.out.println("Password aggiornata con successo!");
                            break;
                        case 3: // Modifica età
                            while (true) {
                                System.out.println("vecchia età:  " + etaRegistrata);
                                System.out.print("Inserisci la nuova età: ");
                                if (scanner.hasNextInt()) {
                                    etaRegistrata = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Età aggiornata con successo!");
                                    break;
                                } else {
                                    System.out.println("Errore! Devi inserire un numero intero per l'età.");
                                    scanner.next();
                                }
                            }
                            break;
                        case 4: // Logout
                            System.out.println("\n--- NUOVI DATI ---");
                            System.out.println("Nome - " + nomeRegistrato);
                            System.out.println("Paasowrd - " + passwordRegistrata);
                            System.out.println("Età - " + etaRegistrata);
                            System.out.println("\n Uscita dal sistema. Arrivederci!");
                            uscire = true;
                            break;
                        default:
                            System.out.println("Scelta non valida! Riprova.");
                    }
                }
                break;
            } else {
                System.out.println("Dati errati! Riprova.");
            }
        }
        if (!accessoConsentito) {
            System.out.println("\nHai superato il numero massimo di tentativi. Accesso negato!");
        }

        scanner.close();
    }
}
