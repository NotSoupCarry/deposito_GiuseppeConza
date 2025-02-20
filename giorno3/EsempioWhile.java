import java.util.Scanner;

public class EsempioWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println("inserisci un numero minore di 10");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num <= 10) {
                    break;
                } else {
                    System.out.println("errore di input inserisci un numero minore di 10");
                    scanner.next();
                }
            } else {
                System.out.println("errore di input inserisci un numero");
                scanner.next();
            }
        }

        // lo fa solo se num non è 10
        while (num != 10) {
            num++;
            System.out.println("sono nel while, ecco il numero: " + num);
        }

        // lo fa almeno una volta
        do {
            num++;
            System.out.println("sono nel do while, ecco il numero: " + num);
        } while (num == 10);
        scanner.close();
    }
}
