import java.util.Scanner;

public class InsertionInteger {
    
    private static final int SIZE_MAX = 10;
    /**
     * nombre d'entiers présents dans t, 0 <= size <= SIZE_MAX
     */
    private int size;
    private int[] array = new int[SIZE_MAX];

    public InsertionInteger() {
        size = 0; // Initialiser la taille à 0 lorsque l'objet est créé
    }

    /**
     * @return copie de la partie remplie du tableau
     */
    public int[] toArray() {
        //TODO
    }

    /**
     * Si x n'appartient pas à array[0..size-1] et size < SIZE_MAX,
     * size est incrémenté de 1, x est inséré dans array et les
     * entiers array[0..size] sont triés par ordre croissant.
     * Sinon array est inchangé.
     * 
     * Exemple :
     * pour x = 5, size = 3, array[0] = 1, array[1] = 6, array[2] = 8
     * insertion délivre true, size=4,
     * array[0] = 1; array[1] = 5, array[2] = 6, array[3] = 8
     * 
     * @param value
     *        valeur à insérer
     * @pre   les valeurs de array[0..size-1] sont triées par ordre croissant
     * @return false si x appartient à array[0..size-1] ou si
     *         array est complétement rempli;
     *         true si x n'appartient pas à array[0..size-1]
     */
    public boolean insert(int value) {
        //On vérifie que la taille est bien inférieure à la taille maximale SIZE_MAX
        if (size < SIZE_MAX) {
            //On vérifie que la valeur n'est pas déjà présente dans le tableau
            if (!contains(array, value)) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     * array est rempli, par ordre croissant, en utilisant la fonction
     * insert avec les valeurs lues par scanner.
     * 
     * @param scanner
     */
    public void createArray(Scanner scanner) {
        //TODO
    }

    @Override
    public String toString() {
        //TODO
    }

    //////////MÉTHODES SOUS-FONCTIONNEL ÉCRITE EN PLUS//////////

    /**
     * @param array le tableau contenant oui ou non la valeur
     * @param value la valeur à chercher
     * @return true si la valeur est présente dans le tableau, false sinon 
     */
    public boolean contains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////
    

}
