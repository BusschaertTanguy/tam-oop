package chapitre_001.exercises;

/*
*   Voici un program qui calcul la reduction d'un prix de 20% et de 30%
*   Essayez de trouver l'abstraction pour cette logique.
*/

public class _001_Abstraction_Parametrisation {
    public static void main(String[] args) {
        // Prix de depart
        double prix = 30.0;

        // Calcul de reduction de 20%
        double reduction1 = prix * (20.0 / 100);
        double prixReduit1 = prix - reduction1;

        // Calcul de reduction de 30%
        double reduction2 = prix * (30.0 / 100);
        double prixReduit2 = prix - reduction2;

        // Imprimer le resultat
        System.out.println("Prix apres reduction 20%: " + prixReduit1);
        System.out.println("Prix apres reduction 30%: " + prixReduit2);
    }
}

