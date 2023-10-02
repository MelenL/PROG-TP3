public class Fourmis {

    ///////////////////////////////EXPLICATION DE LA LOGIQUE DE LA SUITE DES FOURMIS///////////////////////////////
    /**
     * On lit la chaine de caractères de gauche à droite. À chaque élément croisé, on compte combien de fois il apparait de gauche à droite. On compte jusqu'à croisé un nombre différent.
     * Exemple: Si j'ai 111211, je vais compter 3 fois le nombre 1, puis 1 fois le nombre 2, puis 1 fois le nombre 1.
     * Ce qui va me donner 312211. Car j'ai compté 3 fois le nombre 1, 1 fois le nombre 2, et 2 fois le nombre 1. On met dans cet ordre "nombre d'occurence du nombre i" + "le nombre i en question" + ... "prochain caractères"
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param ui un terme de la suite des fourmis
     * @pre s.length() > 0
     * @return le terme suivant de la suite des fourmis
     */
    public static String next (String ui) {
        String resultat = "";
        int i = 0;
        while (i < ui.length()) { //On doit compter pour chaque chiffre son nombre d'apparition, c'est le rôle de i
            int j = i;
            while (j < ui.length() && ui.charAt(i) == ui.charAt(j)) { //On doit compter pour le chiffre i son nombre d'occurences, c'est le rôle de j
                j++;
            }
            resultat += (j - i) + "" + ui.charAt(i); //Ici, le calcul permet de noter combien j de fois le nombre i apparait + le nombre i en question. (Exemple: 3 fois le nombre 1 = 3+1 = 31)
            i = j; //Évite de re-traverser la chaîne de caractères, et va directement à la prochaine occurence.
        }
        return resultat;
    }

    /**
     * @param n le nombre n de terme à afficher de la suite des fourmis
     */
    public static void suiteFourmis (int n) {
        String resultat = "1"; //On commence à la base de la suite, donc "1"
        System.out.println(resultat+"\n");
        for (int i = 0; i < n; i++) {
            resultat = next(resultat); 
            System.out.println(next(resultat)+"\n"); //On affiche le résultat de la fonction next à chaque itération
        }
    }

    public static void main(String[] args) throws Exception {
       //System.out.println(next("21")); //L'élément suivant de "21"

       suiteFourmis(10);
    }
    
}

