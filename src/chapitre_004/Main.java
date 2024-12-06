package chapitre_004;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            int monNombre = DemanderNombre();
            System.out.println("Votre nombre est: " + monNombre);
        }
        catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas introduit un chiffre");
            throw new IllegalStateException("Je relance une autre exception !");
        }
        catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
            throw e;
        }
        finally {
            System.out.println("J'ai fini !");
        }
    }

    static int DemanderNombre() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisir un nombre entre 0-9");
        int nombre = scanner.nextInt();

        if(nombre < 0 || nombre > 9) {
            throw new IllegalStateException("Le nombre n'est pas entre 0 et 9");
        }

        return nombre;
    }
}