import java.util.ArrayList;
import java.util.Arrays;

public class EsempioArrayList {
    public static void main(String[] args){
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("ferrari");
        cars.add("lamborghini");
        cars.add("jaguar");

        cars.set(0, "fiat"); // ferrari diventa fiat

        System.out.println(cars); // stampa tutte gli elementi dentro cars
        System.out.println(cars.get(0));

        cars.remove(2); // rimuove l elemento in posizione 2
        System.out.println(cars);

        System.out.println(cars.size()); // stampa il numero di elementi nell arraylist cars

        Integer arr[] = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr)); // Conversione da array ad arraylist
        arr = arrayList.toArray(arr); // Conversione da arraylist ad array
    }
}
