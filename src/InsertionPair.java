import java.util.Scanner;

public class InsertionPair {

    private static final int SIZE_MAX = 10;
    private int size;
    private Pair[] array = new Pair[SIZE_MAX];

    public InsertionPair() {
        size = 0;
    }

    public Pair[] toArray() {
        Pair[] distinctArray = new Pair[size];
        int distinctSize = 0;

        // Copier les paires distinctes dans un nouveau tableau
        for (int i = 0; i < size; i++) {
            if (!contains(distinctArray, distinctSize, array[i])) {
                distinctArray[distinctSize] = array[i];
                distinctSize++;
            }
        }

        // Trier manuellement le tableau distinctArray
        manualSortArray(distinctArray, distinctSize);

        return distinctArray;
    }

    public boolean insert(Pair pair) {
        if (size < SIZE_MAX && !contains(array, size, pair)) {
            array[size] = pair; // Insérer la paire à la fin du tableau
            size++; // Incrémenter la taille
            return true;
        }
        return false;
    }

    public void createArray(Scanner scanner) {
        int firstValue = scanner.nextInt();
        int secondValue = scanner.nextInt();
        while (firstValue != -1 && secondValue != -1) {
            Pair pair = new Pair(firstValue, secondValue);
            insert(pair);
            firstValue = scanner.nextInt();
            secondValue = scanner.nextInt();
        }
    }

    @Override
    public String toString() {
        Pair[] sortedArray = toArray();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < sortedArray.length; i++) {
            sb.append(sortedArray[i].toString());
            if (i < sortedArray.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Vérifie si une paire existe dans le tableau jusqu'à la taille donnée
    private boolean contains(Pair[] arr, int size, Pair pair) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(pair)) {
                return true;
            }
        }
        return false;
    }

    // Tri manuel du tableau en utilisant l'algorithme de tri par insertion
    private void manualSortArray(Pair[] arr, int length) {
        for (int i = 1; i < length; i++) {
            Pair key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez une suite de paires (terminez par -1 -1) : ");
        InsertionPair insertionPair = new InsertionPair();
        insertionPair.createArray(scanner);
        System.out.println("Liste triée des paires distinctes : " + insertionPair.toString());
    }
}
