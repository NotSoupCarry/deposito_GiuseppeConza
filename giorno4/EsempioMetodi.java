public class EsempioMetodi {
    public static void main(String[] args) {
        saluta();

        int num = somma(10, 20);
        System.out.println(num);

    }

    public static int somma(int a, int b) {
        return a + b;
    }

    public static void saluta() {
        System.out.println("Ciaooooooo");
    }

    public int sommaMultipla(int... numeri) {
        int somma = 0;
        for (int n : numeri)
            somma += n;
            
        return somma;
    }
}
