import java.util.Scanner;

public class EserciziFusione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            int scelta;

            while (true) {
                System.out.println("\nScegli un'operazione inserendo un numero tra 1 e 5:");
                System.out.println("1: Confronto segno di un numero");
                System.out.println("2: Confronto tra 2 numeri");
                System.out.println("3: Controllo età");
                System.out.println("4: Verifica anno bisestile");
                System.out.println("5: Esci");
                System.out.print("Scelta: ");

                // controllo input
                if (scanner.hasNextInt()) {
                    scelta = scanner.nextInt();
                    if (scelta >= 1 && scelta <= 5) {
                        break; // Esce dal ciclo while se l' input è valido
                    } else {
                        System.out.println("Scelta non valida! Inserisci un numero tra 1 e 5.");
                    }
                } else {
                    System.out.println("Input non valido! Devi inserire un numero.");
                    scanner.next();
                }
            }

            switch (scelta) {
                case 1: // Confronto segno di un numero
                    while (true) {
                        System.out.print("Inserisci un numero intero ");
                        // controllo input
                        if (scanner.hasNextInt()) {
                            int numero = scanner.nextInt();

                            if (numero > 0)
                                System.out.println("Il numero è positivo.");
                            else if (numero == 0)
                                System.out.println("Il numero è 0.");
                            else
                                System.out.println("Il numero è negativo.");

                            break;
                        } else {
                            System.out.println("Input non valido! Devi inserire un numero intero.");
                            scanner.next();
                        }
                    }
                    break;
                case 2: // Confronto tra 2 numeri
                    while (true) {
                        System.out.print("Inserisci due numeri ");
                        // controllo input
                        if (scanner.hasNextDouble()) {
                            double numero1 = scanner.nextDouble();
                            double numero2 = scanner.nextDouble();

                            if (numero1 > numero2)
                                System.out.println("Il numero1 è maggiore del numero2.");
                            else if (numero1 == numero2)
                                System.out.println("i due numeri sono uguali.");
                            else
                                System.out.println("Il numero2 è maggiore del numero1..");

                            break;
                        } else {
                            System.out.println("Input non valido! Devi inserire un numero.");
                            scanner.next();
                        }
                    }
                    break;
                case 3: // Controllo età
                    while (true) {
                        System.out.print("Inserisci 'maggiorenne' o 'minorenne' ");
                        // controllo input
                        if (scanner.hasNext()) {
                            String età = scanner.next();

                            if (età.trim().toLowerCase().equals("maggiorenne"))
                                System.out.println("Sei un adulto.");
                            else if (età.trim().toLowerCase().equals("minorenne"))
                                System.out.println("Sei un minorenne.");
                            else
                                System.out.println("Input non valido! Devi scrivere 'maggiorenne' o 'minorenne'.");

                            break;
                        } else {
                            System.out.println("Input non valido! Devi inserire un numero.");
                            scanner.next();
                        }
                    }
                    break;
                case 4: // Verifica anno bisestile
                    while (true) {
                        System.out.print("Inserisci l'anno ");
                        // controllo input
                        if (scanner.hasNextInt()) {
                            int anno = scanner.nextInt();

                            if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0)
                                System.out.println("anno bisestile.");
                            else
                                System.out.println("anno non bisestile.");

                            break;
                        } else {
                            System.out.println("Input non valido! Devi inserire un numero.");
                            scanner.next();
                        }
                    }
                    break;
                case 5: { // Esce dal ciclo se l'utente inserisce 5
                    exit = true;
                    System.out.println("CIAO KIIIIIIIIIIIING GRAZIE PER AVER GIOCATO");
                    break;
                }
            }
        }
        scanner.close();
    }
}
