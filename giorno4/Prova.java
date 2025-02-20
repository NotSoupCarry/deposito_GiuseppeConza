import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prova {

    public static void main(String args[]) {
        // Create a Set using HashSet
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");
        // stampo il Set
        System.out.println("Set Elements: " + hash_Set);

        Set<Integer> numeri = new HashSet<>();
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) { 
            System.out.print("\nInserisci un numero: ");
            int numero = scanner.nextInt();
            
            // Se il numero è presente nel set, uscire dal ciclo
            if (numeri.contains(numero)) {
                System.out.println("Numero presente nel set. Il programma termina.");
                exit = true;
                break;
            }
        }
        scanner.close();
    }
}
