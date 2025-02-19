import java.util.Scanner;

public class EsempioFor {
    public static void main(String[] args){
        for (int i=0; i<=5; i++){
            System.out.println(i);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("inserisci un numero: ");
        int num = scanner.nextInt();

        for (int i=0; i<=num; i++){
            System.out.print(i + " ");
        }

        scanner.close();
    }   
}
