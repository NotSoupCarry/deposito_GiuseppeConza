import java.util.Random;
import java.util.Scanner;

public class EsercizioZFusione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            int scelta;

            while (true) {
                System.out.println("\nScegli un'operazione inserendo un numero tra 1 e 4:");
                System.out.println("1: Somma dei numeri inseriti");
                System.out.println("2: Tabellina del numero inserito");
                System.out.println("3: GIOCONE DEL NUMERO MAGICO");
                System.out.println("4: Esci");
                System.out.print("Scelta: ");

                // controllo input
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    if (scelta >= 1 && scelta <= 4) {
                        break; // Esce dal ciclo while se l' input è valido
                    } else {
                        System.out.println("Scelta non valida! Inserisci un numero tra 1 e 4.");
                    }
                } else {
                    System.out.println("Input non valido! Devi inserire un numero.");
                    scanner.next();
                }
            }

            boolean continua = true;

            switch (scelta) {
                case 1: // Somma dei numeri inseriti
                    int somma = 0; // Variabile la somma
                    int num;

                    System.out.println("Inserisci numeri interi positivi per sommarli.");
                    System.out.println("Inserisci un numero negativo per FINIRE TUTTO E DISTRUGGERE L'UNIVERSO.");

                    do {
                        while (true) { // Ciclo per garantire input valido
                            System.out.print("Inserisci un numero: ");
                            if (scanner.hasNextInt()) {
                                num = scanner.nextInt();
                                break;
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        // Se il numero è negativo, interrompo il ciclo della somma dei numeri
                        if (num < 0) {
                            System.out.println("\nNumero negativo inserito.\nTHE END.");
                            continua = false;
                            break;
                        }

                        // Sommo solo i numeri positivi
                        somma += num;
                    } while (continua);

                    // Stampa del risultato finale
                    System.out.println("La somma dei numeri inseriti è: " + somma);
                    break;
                case 2: // Tabellina del numero inserito
                    while (continua) {
                        System.out.print(
                                "Inserisci un numero intero per calcolare la tabellina (o scrivi 'esci' per terminare): ");

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
                            if (input.equalsIgnoreCase("esci")) { // Controlla se l'utente vuole uscire dalla funzione della tabellina
                                System.out.println("THE END, GRAZIE PER ESSERE PASSATI");
                                continua = false;
                                break;
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero o 'esci' per terminare.");
                            }
                        }
                    }
                    break;
                case 3: // Gioco del numero fortunato
                    Random random = new Random();
                    int numeroRandom = random.nextInt(100) + 1;
                    int numPlayer = 0;
                    int i = 0;
                    System.out.println("PROVA A VINCERE ALLA NOSTRA LOTTERIA.\nI NUMERI SONO DA 1 A 100 \n");
                    do {
                        i++; // conteggio dei tentativi

                        // Controllo dell'input per evitare errori con valori non numerici
                        while (true) {
                            System.out.print("Tentativo n." + i + " Inserisci un numero: ");
                            if (scanner.hasNextInt()) {
                                numPlayer = scanner.nextInt();
                                break;
                            } else {
                                System.out.println("Errore! Devi inserire un numero intero.");
                                scanner.next();
                            }
                        }

                        // controllo quanto sono distanti i numeri per dare indicazioni al giocatore
                        if (numPlayer > numeroRandom) {
                            if (numPlayer - numeroRandom < 10) {
                                System.out.println("PIU IN BASSO (fuoco)");
                            } else if (numPlayer - numeroRandom < 25) {
                                System.out.println("PIU IN BASSO (fuochino)");
                            } else {
                                System.out.println("PIU IN BASSO (acqua)");
                            }
                        } else if (numPlayer < numeroRandom) {
                            if (numeroRandom - numPlayer < 10) {
                                System.out.println("PIU IN ALTO (fuoco)");
                            } else if (numeroRandom - numPlayer < 25) {
                                System.out.println("PIU IN ALTO (fuochino)");
                            } else {
                                System.out.println("PIU IN ALTO (acqua)");
                            }
                        }

                    } while (numPlayer != numeroRandom);

                    System.out.println("\n ************************************************************ \n");
                    System.out.println("HAI VINTOOOOOOO");
                    System.out.println("Il numero fortunato era: " + numeroRandom + ". Numero tentativi: " + i);
                    break;
                case 4: { // Esce dal ciclo se l'utente inserisce 5
                    exit = true;
                    System.out.println("CIAO KIIIIIIIIIIIING GRAZIE PER AVER GIOCATO");
                    break;
                }
            }
        }
        scanner.close();
    }
}
