import java.util.Scanner;

public class EsercizioZ2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int somma = 0;
        boolean exit = false;
        while (!exit) {
            while (true) {
                System.out.print("Inserisci un numero: ");
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    System.out.println("IL NUMERO DEVE ESSERE INTERO");
                    scanner.next();
                }
            }
            if (num % 2 == 0)
                System.out.println("il numero è pari ");
            else
                System.out.println("il numero è dispari ");

            if (num < 0) {
                System.out.println("il numero è negativo... uscita ");
                exit = true;
                break;
            }
            somma += num;
        }
        System.out.println("\nla somma dei numeri inseriti è: " + somma);
        scanner.close();
    }
}
