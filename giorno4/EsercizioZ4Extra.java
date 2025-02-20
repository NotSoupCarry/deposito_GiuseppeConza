import java.util.Scanner;

public class EsercizioZ4Extra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numeroRighe = 3;
        final int numeroColonne = 8;
        final String postoLibero = "available";

        // Matrice per memorizzare le prenotazioni (nome del cliente e riga-colonna)
        String[][] posti = new String[numeroRighe][numeroColonne];

        // Inizializzotutti i posti come postoLibero
        for (int i = 0; i < numeroRighe; i++) {
            for (int j = 0; j < numeroColonne; j++) {
                posti[i][j] = postoLibero;
            }
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Prenota un posto");
            System.out.println("2. Cerca prenotazioni");
            System.out.println("3. Visualizza tutti i posti");
            System.out.println("4. Visualizza report posti");
            System.out.println("5. Esci");

            int scelta;
            // Controllo sull'input
            while (true) {
                System.out.print("Scegli un'opzione: ");
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Errore! Devi inserire un numero intero.");
                    scanner.next();
                }
            }

            switch (scelta) {
                case 1: // Prenota un posto
                    boolean exitPrenota = false;
                    while (!exitPrenota) {
                        System.out.println("\n--- Prenotazione Posto ---");
                        System.out.println("1. Procedi con la prenotazione");
                        System.out.println("2. Torna al menu principale");

                        int sceltaPrenotazione;
                        // Controllo sull'input della scelta
                        while (true) {
                            System.out.print("Scegli un'opzione: ");

                            if (scanner.hasNextInt()) {
                                sceltaPrenotazione = scanner.nextInt();
                                scanner.nextLine();
                                if (sceltaPrenotazione == 1 || sceltaPrenotazione == 2) {
                                    break;
                                } else {
                                    System.out.println("Errore! Inserisci 1 per procedere o 2 per tornare indietro.");
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        if (sceltaPrenotazione == 2) {
                            exitPrenota = true; // Torna al menu principale
                            break;
                        }
                        
                        // Procedi con la prenotazione
                        String nome;
                        do {
                            System.out.print("Inserisci il nome del cliente: ");
                            nome = scanner.nextLine().trim();
                            if (nome.isEmpty()) {
                                System.out.println("Errore! Il nome non può essere vuoto. Riprova.");
                            }
                        } while (nome.isEmpty());

                        int riga, colonna;
                        while (true) {
                            System.out.print("Inserisci la riga (1-" + numeroRighe + "): ");
                            if (scanner.hasNextInt()) {
                                riga = scanner.nextInt();
                                scanner.nextLine();
                                if (riga >= 1 && riga <= numeroRighe) {
                                    break;
                                } else {
                                    System.out.println("Errore! Devi inserire un numero tra 1 e " + numeroRighe);
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        while (true) {
                            System.out.print("Inserisci la colonna (1-" + numeroColonne + "): ");
                            if (scanner.hasNextInt()) {
                                colonna = scanner.nextInt();
                                scanner.nextLine();
                                if (colonna >= 1 && colonna <= numeroColonne) {
                                    break;
                                } else {
                                    System.out.println("Errore! Devi inserire un numero tra 1 e " + numeroColonne);
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        // Controllo se il posto è già prenotato
                        if (!posti[riga - 1][colonna - 1].equals(postoLibero)) {
                            System.out.println("Errore! Il posto è già prenotato da " + posti[riga - 1][colonna - 1]);
                        } else {
                            posti[riga - 1][colonna - 1] = nome;
                            System.out.println("Prenotazione effettuata con successo per " + nome);
                        }
                    }
                    break;

                case 2: // Cerca prenotazioni
                    boolean exitRicerca = false;

                    while (!exitRicerca) {
                        System.out.println("\n--- Ricerca Prenotazioni ---");
                        System.out.println("1. Cerca per nome");
                        System.out.println("2. Cerca per riga e colonna");
                        System.out.println("3. Torna al menu principale");

                        int sceltaRicerca;

                        // Controllo input
                        while (true) {
                            System.out.print("Scegli un'opzione: ");
                            if (scanner.hasNextInt()) {
                                sceltaRicerca = scanner.nextInt();
                                scanner.nextLine(); // Consuma il newline
                                if (sceltaRicerca >= 1 && sceltaRicerca <= 3) {
                                    break;
                                }
                            }
                            System.out.println("Errore! Inserisci un numero valido tra 1 e 3.");
                            scanner.next();
                        }

                        switch (sceltaRicerca) {
                            case 1: // Cerca per nome
                                System.out.print("Inserisci il nome da cercare: ");
                                String nomeCercato = scanner.nextLine().trim();
                                boolean trovatoNome = false;

                                for (int i = 0; i < numeroRighe; i++) {
                                    for (int j = 0; j < numeroColonne; j++) {
                                        if (posti[i][j] != null && posti[i][j].equalsIgnoreCase(nomeCercato)) {
                                            System.out.println("Prenotazione trovata: " + nomeCercato + " - Riga "
                                                    + (i + 1) + ", Colonna " + (j + 1));
                                            trovatoNome = true;
                                        }
                                    }
                                }

                                if (!trovatoNome) {
                                    System.out.println("Nessuna prenotazione trovata per il nome inserito.");
                                }
                                break;

                            case 2: // Cerca per riga e colonna
                                int rigaCercata, colonnaCercata;

                                // Controllo input per riga
                                while (true) {
                                    System.out.print("Inserisci la riga da cercare (1-" + numeroRighe + "): ");
                                    if (scanner.hasNextInt()) {
                                        rigaCercata = scanner.nextInt();
                                        if (rigaCercata >= 1 && rigaCercata <= numeroRighe) {
                                            break;
                                        }
                                    }
                                    System.out.println("Errore! Inserisci un numero tra 1 e " + numeroRighe);
                                    scanner.next();
                                }

                                // Controllo input per colonna
                                while (true) {
                                    System.out.print("Inserisci la colonna da cercare (1-" + numeroColonne + "): ");
                                    if (scanner.hasNextInt()) {
                                        colonnaCercata = scanner.nextInt();
                                        if (colonnaCercata >= 1 && colonnaCercata <= numeroColonne) {
                                            break;
                                        }
                                    }
                                    System.out.println("Errore! Inserisci un numero tra 1 e " + numeroColonne);
                                    scanner.next();
                                }

                                if (posti[rigaCercata - 1][colonnaCercata - 1] != postoLibero) {
                                    System.out.println(
                                            "Il posto è prenotato da: " + posti[rigaCercata - 1][colonnaCercata - 1]);
                                } else {
                                    System.out.println("Il posto selezionato è libero.");
                                }
                                break;

                            case 3: // Torna al menu principale
                                exitRicerca = true;
                                break;
                        }
                    }
                    break;
                case 3: // Visualizza tutti i posti
                    System.out.println("\n--- Posti Prenotati: ---");
                    for (int i = 0; i < numeroRighe; i++) {
                        for (int j = 0; j < numeroColonne; j++) {
                            if (posti[i][j] != postoLibero) {
                                System.out.println(posti[i][j] + " - Riga " + (i + 1) + ", Colonna " + (j + 1));
                            }
                        }
                    }

                    System.out.println("\n--- Mappa dei Posti ---");
                    for (int i = 0; i < numeroRighe; i++) {
                        for (int j = 0; j < numeroColonne; j++) {
                            System.out.print((posti[i][j].equals(postoLibero) ? "[__]" : "[XX]") + " ");
                        }
                        System.out.println(); // A capo dopo ogni riga
                    }
                    break;

                case 4: // Visualizza report posti
                    int postiTotali = numeroRighe * numeroColonne;
                    int postiPrenotati = 0;

                    for (int i = 0; i < numeroRighe; i++) {
                        for (int j = 0; j < numeroColonne; j++) {
                            if (!posti[i][j].equals(postoLibero)) {
                                postiPrenotati++;
                            }
                        }
                    }

                    int postiLiberi = postiTotali - postiPrenotati;
                    System.out.println("\n--- Report Posti ---");
                    System.out.println("Posti totali: " + postiTotali);
                    System.out.println("Posti prenotati: " + postiPrenotati);
                    System.out.println("Posti liberi: " + postiLiberi);
                    break;

                case 5: // Esci dal programma
                    System.out.println("Uscita dal programma.");
                    exit = true;
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close();
    }
}
