import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioZ4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numeroRighe = 3;
        final int numeroColonne = 8;

        ArrayList<String> prenotazioni = new ArrayList<String>(); // Memorizza i nomi dei clienti
        ArrayList<Integer> righe = new ArrayList<Integer>(); // Memorizza le righe dei posti prenotati
        ArrayList<Integer> colonne = new ArrayList<Integer>(); // Memorizza le colonne dei posti prenotati

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Prenota un posto");
            System.out.println("2. Cerca prenotazioni");
            System.out.println("3. Visualizza tutti i posti (disponibili e prenotati)");
            System.out.println("4. Visualizza report posti");
            System.out.println("5. Esci");
            int scelta;

            // controllo sull input scelta
            while (true) {
                System.out.print("Scegli un'opzione: ");

                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    break;
                } else {
                    System.out.println("DEVI INSERIRE UN NUMERO INTERO");
                    scanner.next();
                }
            }
            scanner.nextLine();

            switch (scelta) {
                case 1: // Prenota un posto
                    boolean exitPrenota = false;
                    while (!exitPrenota) {
                        System.out.println("\n--- Menu Prenotazione Posto ---");
                        System.out.println("1. Procedi con la prenotazione");
                        System.out.println("2. Torna al menu principale");

                        int sceltaPrenotazione;
                        // Controllo sull'input della scelta
                        while (true) {
                            System.out.print("Scegli un'opzione: ");

                            if (scanner.hasNextInt()) {
                                sceltaPrenotazione = scanner.nextInt();
                                scanner.nextLine(); // Consuma il newline
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
                        // Controllo sul nome affinché non sia vuoto
                        do {
                            System.out.print("Inserisci il nome del cliente: ");
                            nome = scanner.nextLine();
                            if (nome.isEmpty()) {
                                System.out.println("Errore! Il nome non può essere vuoto. Riprova.");
                            }
                        } while (nome.isEmpty());

                        // Input per riga e colonna
                        int riga;
                        int colonna;

                        while (true) {
                            System.out.print("Inserisci la riga (1-" + numeroRighe + "): ");
                            // Controlla se l'input è un intero
                            if (scanner.hasNextInt()) {
                                riga = scanner.nextInt();
                                scanner.nextLine(); // Consuma il newline

                                if (riga >= 1 && riga <= numeroRighe) {
                                    break;
                                } else {
                                    System.out.println("Errore! Devi inserire un numero tra 1 e " + numeroRighe);
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next(); // Consuma l'input non valido
                            }
                        }

                        while (true) {
                            System.out.print("Inserisci la colonna (1-" + numeroColonne + "): ");
                            // Controlla se l'input è un intero
                            if (scanner.hasNextInt()) {
                                colonna = scanner.nextInt();
                                scanner.nextLine(); // Consuma il newline

                                if (colonna >= 1 && colonna <= numeroColonne) {
                                    break;
                                } else {
                                    System.out.println("Errore! Devi inserire un numero tra 1 e " + numeroColonne);
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next(); // Consuma l'input non valido
                            }
                        }

                        // Controllo se il posto è già prenotato
                        boolean postoOccupato = false;
                        for (int i = 0; i < righe.size(); i++) {
                            if (righe.get(i) == riga && colonne.get(i) == colonna) {
                                postoOccupato = true;
                                break;
                            }
                        }

                        if (postoOccupato) {
                            System.out.println("Posto già prenotato. Vuoi riprovare?");
                            System.out.println("1. Sì, riprova");
                            System.out.println("2. No, torna al menu principale");
                            System.out.print("Scegli un'opzione: ");

                            int sceltaRiprova;
                            // Controllo sull'input della sceltaRiprova
                            while (true) {
                                if (scanner.hasNextInt()) {
                                    sceltaRiprova = scanner.nextInt();
                                    scanner.nextLine(); // Consuma il newline
                                    if (sceltaRiprova == 1 || sceltaRiprova == 2) {
                                        break;
                                    } else {
                                        System.out
                                                .println("Errore! Inserisci 1 per riprovare o 2 per tornare indietro.");
                                    }
                                } else {
                                    System.out.println("Errore! Devi inserire un numero intero.");
                                    scanner.next();
                                }
                            }

                            if (sceltaRiprova == 2) {
                                exitPrenota = true; // Torna al menu principale
                            }
                        } else {
                            // Aggiungi la prenotazione
                            prenotazioni.add(nome);
                            righe.add(riga);
                            colonne.add(colonna);
                            System.out.println("Prenotazione effettuata con successo!");
                            exitPrenota = true; // Esci dal ciclo dopo la prenotazione
                        }
                    }
                    break;
                case 2: // Cerca prenotazioni
                    boolean exitRicerca = false;
                    while (!exitRicerca) {
                        System.out.println("\n--- Menu Ricerca ---");
                        System.out.println("1. Cerca per nome");
                        System.out.println("2. Cerca per riga");
                        System.out.println("3. Cerca per colonna");
                        System.out.println("4. Torna al menu principale");

                        int sceltaRicerca;
                        // Controllo sull'input della scelta
                        while (true) {
                            System.out.print("Scegli un'opzione: ");
                            if (scanner.hasNextInt()) {
                                sceltaRicerca = scanner.nextInt();
                                scanner.nextLine();
                                if (sceltaRicerca >= 1 && sceltaRicerca <= 4) {
                                    break;
                                } else {
                                    System.out.println("Errore! Inserisci un numero tra 1 e 4.");
                                }
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        switch (sceltaRicerca) {
                            case 1: // Cerca per nome
                                System.out.print("Inserisci il nome da cercare: ");
                                String nomeCercato;

                                // Controllo sul nomeCercato affinché non sia vuoto
                                do {
                                    nomeCercato = scanner.nextLine();
                                    if (nomeCercato.isEmpty()) {
                                        System.out.println("Errore! Il nome non può essere vuoto. Riprova.");
                                    }
                                } while (nomeCercato.isEmpty());

                                boolean trovatoNome = false;

                                System.out.println("Prenotazioni trovate:");
                                for (int i = 0; i < prenotazioni.size(); i++) {
                                    if (prenotazioni.get(i).equalsIgnoreCase(nomeCercato)) {
                                        System.out.println(
                                                "Nome: " + prenotazioni.get(i) + ", Posto: Riga " + righe.get(i)
                                                        + ", Colonna " + colonne.get(i));
                                        trovatoNome = true;
                                    }
                                }

                                if (!trovatoNome) {
                                    System.out.println("Nessuna prenotazione trovata per il nome specificato.");
                                }
                                break;

                            case 2: // Cerca per riga
                                int rigaCercata;

                                // Controllo sull'input della riga
                                while (true) {
                                    System.out.print("Inserisci la riga da cercare (1-3): ");
                                    if (scanner.hasNextInt()) {
                                        rigaCercata = scanner.nextInt();
                                        scanner.nextLine(); // Consuma il newline
                                        if (rigaCercata >= 1 && rigaCercata <= 3) {
                                            break;
                                        } else {
                                            System.out.println("Errore! La riga deve essere compresa tra 1 e 3.");
                                        }
                                    } else {
                                        System.out.println("Errore! Devi inserire un numero intero.");
                                        scanner.next(); // Consuma l'input non valido
                                    }
                                }

                                boolean trovatoRiga = false;

                                System.out.println("Prenotazioni trovate:");
                                for (int i = 0; i < righe.size(); i++) {
                                    if (righe.get(i) == rigaCercata) {
                                        System.out.println(
                                                "Nome: " + prenotazioni.get(i) + ", Posto: Riga " + righe.get(i)
                                                        + ", Colonna " + colonne.get(i));
                                        trovatoRiga = true;
                                    }
                                }

                                if (!trovatoRiga) {
                                    System.out.println("Nessuna prenotazione trovata per la riga specificata.");
                                }
                                break;

                            case 3: // Cerca per colonna
                                int colonnaCercata;

                                // Controllo sull'input della colonna
                                while (true) {
                                    System.out.print("Inserisci la colonna da cercare (1-8): ");
                                    if (scanner.hasNextInt()) {
                                        colonnaCercata = scanner.nextInt();
                                        scanner.nextLine(); // Consuma il newline
                                        if (colonnaCercata >= 1 && colonnaCercata <= 8) {
                                            break;
                                        } else {
                                            System.out.println("Errore! La colonna deve essere compresa tra 1 e 8.");
                                        }
                                    } else {
                                        System.out.println("Errore! Devi inserire un numero intero.");
                                        scanner.next(); // Consuma l'input non valido
                                    }
                                }

                                boolean trovatoColonna = false;

                                System.out.println("Prenotazioni trovate:");
                                for (int i = 0; i < colonne.size(); i++) {
                                    if (colonne.get(i) == colonnaCercata) {
                                        System.out.println(
                                                "Nome: " + prenotazioni.get(i) + ", Posto: Riga " + righe.get(i)
                                                        + ", Colonna " + colonne.get(i));
                                        trovatoColonna = true;
                                    }
                                }

                                if (!trovatoColonna) {
                                    System.out.println("Nessuna prenotazione trovata per la colonna specificata.");
                                }
                                break;

                            case 4: // Torna al menu principale
                                exitRicerca = true;
                                break;

                            default: // Se scelta2 non è compreso tra 1 e 4
                                System.out.println("Scelta non valida. Riprova.");
                        }
                    }
                    break;
                case 3: // Visualizza tutti i posti (disponibili e prenotati)
                    System.out.println("Posti prenotati:");
                    for (int i = 0; i < prenotazioni.size(); i++) {
                        System.out.println("Nome: " + prenotazioni.get(i) + ", Posto: Riga " + righe.get(i) + ", Colonna " + colonne.get(i));
                    }

                    System.out.println("\n--- Posti disponibili ---");
                    for (int rigaDisponibile = 1; rigaDisponibile <= numeroRighe; rigaDisponibile++) {
                        for (int colonnaDisponibile = 1; colonnaDisponibile <= numeroColonne; colonnaDisponibile++) {
                            boolean disponibile = true;
                            for (int i = 0; i < righe.size(); i++) {
                                if (righe.get(i) == rigaDisponibile && colonne.get(i) == colonnaDisponibile) {
                                    disponibile = false;
                                    break;
                                }
                            }
                            if (disponibile) {
                                System.out.print("Riga " + rigaDisponibile + ", Colonna " + colonnaDisponibile + " | ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4: // Visualizza Report posti
                    int postiTotali = numeroColonne * numeroRighe;
                    int postiPrenotati = prenotazioni.size();
                    int postiLiberi = postiTotali - postiPrenotati;

                    System.out.println("\n--- Report Posti ---");
                    System.out.println("Posti totali: " + postiTotali);
                    System.out.println("Posti prenotati: " + postiPrenotati);
                    System.out.println("Posti liberi: " + postiLiberi);
                    break;
                case 5: // Esci dal programma
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    exit = true;
                    return;

                default: // se scelta non è compreso tra 1 e 4
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}