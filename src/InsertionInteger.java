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
        triTableau(tableauDistincts);

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

    public void ArraytoString(String input) {
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
    private void triTableau(int[] tab) {
        int taille = tab.length;  
        
        for (int i = 1; i < taille; i++)
        { 
             int index = tab[i];  
             int j = i-1;  
          
             while(j >= 0 && tab[j] > index)  
             {
                  tab[j+1] = tab[j];  
                  j--;  
             }  
             tab[j+1] = index; 
      }  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //On ouvre notre scanner.

        System.out.print("Entrez une suite de chiffres (terminez par -1) : "); 
        String input = scanner.nextLine(); //On récupère la suite à trier par ordre croissant et entiers distincs.                                 
        scanner.close();

        InsertionInteger insertionInteger = new InsertionInteger(); //On créer notre objet.

        insertionInteger.ArraytoString(input);

        System.out.println("Liste triée des entiers distincts : " + insertionInteger.toString());
    }
}
