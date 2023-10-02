import java.util.Scanner;

public class InsertionInteger {

    private static final int SIZE_MAX = 10;
    private int size;
    private int[] array = new int[SIZE_MAX];

    public InsertionInteger() {
        size = 0; // Initialiser la taille à 0 lorsque l'objet est créé
    }

    public int[] toArray() {
        int[] tableauDistincts = new int[size];
        int taille = 0;

        // Copier les entiers distincts dans un nouveau tableau
        for (int i = 0; i < size; i++) {
            if (!contains(tableauDistincts, taille, array[i])) {
                tableauDistincts[taille] = array[i];
                taille++;
            }
        }

        // Trier manuellement le tableau distinctArray
        triTableau(tableauDistincts, taille);

        return tableauDistincts;
    }

    public boolean insert(int value) {
        if (size < SIZE_MAX && !contains(array, size, value)) {
            array[size] = value; // Insérer la valeur à la fin du tableau
            size++; // Incrémenter la taille
            return true;
        }
        return false;
    }

    public void createArrayFromString(String input) {
        for (char c : input.toCharArray()) {
            int value = Character.getNumericValue(c);
            insert(value);
        }
    }

    @Override
    public String toString() {
        int[] sortedArray = toArray();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < sortedArray.length; i++) {
            sb.append(sortedArray[i]);
            if (i < sortedArray.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Vérifie si une valeur existe dans le tableau jusqu'à la taille donnée
    private boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Tri manuel du tableau en utilisant tri par insertion
    private void triTableau(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez une suite de chiffres (terminez par -1) : ");
        String input = scanner.nextLine();
        scanner.close();

        InsertionInteger insertionInteger = new InsertionInteger();

        insertionInteger.createArrayFromString(input);

        System.out.println("Liste triée des entiers distincts : " + insertionInteger.toString());
    }
}
