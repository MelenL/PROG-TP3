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

    public void StringToArray(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                int value = c-'0'; //Convertir le caractère en entier et d'avoir la valeur numérique du caractères C.
                insert(value); //On vérifie que on peut le mettre dans le tableau et qu'il n'existe pas déjà.
            }
        }
    }

    @Override
    public String toString() {
        int[] arraytrier = toArray();
        String result = "[";
        for (int i = 0; i < arraytrier.length; i++) {
            result += arraytrier[i];
            if (i < arraytrier.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
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

        insertionInteger.StringToArray(input); //On créer notre array à partir de la string.

        System.out.println("Liste triée des entiers distincts : " + insertionInteger.toString()); //On affiche notre Array.
    }
}
