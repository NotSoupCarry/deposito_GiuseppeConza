import java.util.Scanner;

public class Esercizio1 {
     public static void main(String args[]) {
        // definizione dell'array con numero di elementi definiti
        final int posizioni = 3;
        int[] numeri = new int[posizioni];

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        // ciclo while booleano finchè l utente non iserisce un numero maggiore di 100
        while (!exit) {
            for (int i = 0; i < numeri.length; i++) {
                //ciclo per controllo input
                while(true){
                    System.out.print("Inserisci un numero per la posizione " + i + ": ");
                    if (scanner.hasNextInt()) {
                        numeri[i] = scanner.nextInt();
                        break;
                    }
                    else{
                        System.out.println("DEVI INSERIRE UN INTERO");
                        scanner.next();
                    }
                }
                
                if (numeri[i] >= 100) { //esce dal ciclo se l utente inserisce un numero maggiore di 100
                    System.out.println("Hai inserito un numero maggiore 100. exit.");
                    System.out.println("\nEcco com'è ora l array.");
                    for (int n : numeri){
                        System.out.print(n + ", ");
                    }
                    scanner.close();
                    exit = true; 
                    break;
                }
            }
        }
    }
}
