import java.util.Scanner;

public class EsempioSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day;
        while (true) {
            System.out.println("inserisci un numero da 1 a 7");
            if (scanner.hasNextInt()) {
                day = scanner.nextInt();
                break;
            }
            else{
                System.out.println("errore di input inserisci un numero");
                scanner.next();
            }
        }

        switch (day) {
            case 1:
                System.out.println("Lun");
                break;
            case 2:
                System.out.println("Mar");
                break;
            case 3:
                System.out.println("Mer");
                break;
            case 4:
                System.out.println("Gio");
                break;
            case 5:
                System.out.println("Ven");
                break;
            case 6:
                System.out.println("Sab");
                break;
            case 7:
                System.out.println("Dom");
                break;
            default:
                System.out.println("boh");
                break;
        }

        scanner.close();
    }
}
