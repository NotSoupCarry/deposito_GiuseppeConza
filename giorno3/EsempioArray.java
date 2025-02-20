public class EsempioArray {
    public static void main(String[] args){
        int[] numeri = {1, 2, 3, 4, 5, 6};
        System.out.println(numeri[0]); //stampo il primo valore cioè 1

        int numero = numeri[1] + numeri[4]; // numero = 2 + 5 = 7
        System.out.println(numero); 

        for (int n : numeri){ //for each per numeri.lenght cioè 6 volte per 6 elementi dell array
            System.out.print(n + ", ");
        }
    }
}
