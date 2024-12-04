# 1. Introduction aux concepts

## Programmation orientée objet

- Definir et assembler des objets comme fondation
- Un objet contient :
  - Des donnees (attributs ou proprietes) = Information de l'objet
  - Des fonctions (methodes ou operations) = Les actions que l'objet peut effectuer
- Quand utiliser OOP ?
  - Dans un systeme où il y a beaucoup de "types" different, qui ont beaucoup d'interactions

## Modularite et Decomposition

- Decomposer le code en modules different
- Chaque module a sa responsabilite
- Des modules peuvent communiquer/deleguer avec/à d'autres modules.
- p.e. site de ventes :
  - Module de catalogue : responsable de l'affichage des produits
  - Module d'achat : responsable pour l'achat des produits
  - Le module d'achat communique avec le module de catalogue pour montrer les infos des produits que l'on achète
- Pourquoi decomposer ?
  - Comprehension : le code peut etre apris module par module, plus facile.
  - Travail en parallele : des developeurs peuvent travailler en parallele sur 2 modules differents

## Abstraction

- "Cacher" des details de code derriere une "abstraction"
- Une abstraction peut prendre plusieur formes : fonction, class, interface, module
- 2 types d'abstraction
  - Par parametrisation
  - Par specification

### Abstraction par parametrisation

Exemple : Nous avons un programme qui regarde si la lettre 'a' et la lettre 'o' se trouvent dans une phrase

```java
public class Main {
    public static void main(String[] args) {
        String phrase = "Hello World!";

        boolean contientA = false;

        for(int i = 0; i < phrase.length(); i++){
            char lettre = phrase.charAt(i);
            if (lettre == 'a') {
                contientA = true;
                break;
            }
        }

        boolean contientO = false;

        for(int i = 0; i < phrase.length(); i++){
            char lettre = phrase.charAt(i);
            if (lettre == 'o') {
                contientO = true;
                break;
            }
        }
    }
}
```
Les 2 boucles sont identiques, la seule chose qui change est le check `lettre == 'a'` dans la premiere boucle, et le check`lettre == 'o'`.

Ses 2 boucles sont donc un candidat parfait pour une abstraction.

Nous pouvons donc creer une fonction qui va contenir la logique des boucles, et la partie 'variable' de la logique (la lettre sur laquel on controlle), peut etre passer en parametre à la fonction.

```java
public class Main {
    public static void main(String[] args) {
        String phrase = "Hello World!";

        boolean contientA = contientLettre(phrase, 'a');
        boolean contientO = contientLettre(phrase, 'o');
    }

    private static boolean contientLettre(String phrase, char lettre) {
        boolean contient = false;

        for(int i = 0; i < phrase.length(); i++){
            char lettrePhrase = phrase.charAt(i);
            if (lettrePhrase == lettre) {
                contient = true;
                break;
            }
        }

        return contient;
    }
}
```

Avantage d'abstraction par parametrisation:
- Creer de la logique re-utilisable
- Cacher le detail de la logique

## Abstraction par specification

Documenter l'abstraction pour savoir :
- Ses préconditions : Sous quel format devons-nous passer des infos a notre abstraction ?
- Ses post-conditions : Quel est le resultat possible de l'abstraction ?

La specification est donc le "contrat" de la fonction.

Les commentaires au dessu de la fonction sont donc la 'specification' de la fonction.

```java
/**
 * Class qui represente une calculatrice  
 */
public class Calculatrice {
  /**
   * Fonction qui permet de diviser 2 chiffres
   * @param dividende Le dividende
   * @param diviseur Le diviseur, ne peut pas etre 0
   * @return Si le chiffre est 0, le retour serra 0. Si il ne l'est pas, le retour serra la division des 2 chiffres 
   */
  public static double diviser(double dividende, double diviseur) {
    // ...
  }
}
```

Avantage d'abstraction par specification:
- Comprehension rapide de la fonction
- L'utilisateur ne doit pas connaitre les details de l'abstraction, juste comprendre ses specifications
- Decouplage de la definition et l'implementation de l'abstraction

## Decouplage

Le decouplage est l'acte de separer l'implementation (logique) et la definition (typage, specification) de notre abstraction.
- Localite : Les personnes qui utilisent non-abstractions, sont donc interessee par la definition, et pas forcément l'implementation
- Modifiabilite : Vu que le definition et l'implementation sont separe, nous pouvons re-implementer l'implementation sans que les clients de notre abstraction le remarquent.

Avantage du decouplage :
- Idenpendence des taches de programmation : Si le contrat entre les 2 parties (consomateur et producteur de l'abstraction) sont definie en avance, les 2 peuvent travailler avec cette definition en meme temp.
- Limitation des impacts de changement (le contrat est sensee etre stable)

## Techniques d'abstractions

### Abstraction procedurale
- Faire abstraction d'une sequence de code
- Ne peut pas interagir avec les donnees de la class (attributs / proprietees) -> `static`
- Fonctionnes donc purement sur base de parametre
- Access via le nom de class et pas l'instance de l'objet

```java

public class Calculatrice {
  public static double somme(double a, double b) {
    return a + b;
  }
}

public class Main {
    public static void main(String[] args) {
        double resultat = Calculatrice.somme(1.0, 3.0);
    }
}
```

### Abstraction des donnees
- Faire abstraction d'une sequence de code
- Interagi sur les donnees de la class (attributs / proprietees)
- Base de la programation oriente objet

```java
public class Animal {
    private String nom;
    
    public Chien(String nom) {
        this.nom = nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getNom() {
        return this.nom;
    }
}

public class Main {
  public static void main(String[] args) {
    Animal monAnimal = new Animal("Lucky");
    System.out.println(monAnimal.getNom());

    monAnimal.setNom("Neo");
    System.out.println(monAnimal.getNom());
  }
}
```

### Abstraction par hierarchie de types
- Extension de l'abstraction des donnees
- Permet de definir une hierarchie de type
- Heritage : toutes proprietes et fonctions d'un type est disponible pour ses sous-types
- Les sous-types peuvent definir des proprietes et fonctions propres a elle meme (pas disponible pour le type parent, aussi appeler super-type).
- Peuvent ecraser les fonctionnalités du super-type
```java
public class Chien extends Animal {
    public Chien(String nom) {
        super(nom);
    }
    
    public void abboyer() {
      System.out.println("WOOF !");
    }
}

public class Main {
  public static void main(String[] args) {
    Chien monChien = new Animal("Lucky");
    System.out.println(monChien.getNom());

    monChien.setNom("Neo");
    System.out.println(monChien.getNom());
    
    monChien.abboyer();
  }
}
```

### Abstraction de l’iteration
- Abstraction sur un ensemble de donnees (p.e. une liste) sans savoir comment ses donnees obtenu

```java
public class MesNombres {
  private int[] nombres;
  private int index;

  public MesNombres(int[] nombres) {
    this.nombres = nombres;
    this.index = -1;
  }

  public int prochain() {
    if(nombres.length == 0) {
        return 0;
    }
      
    if(this.index < this.nombres.length - 1) {
      this.index++;
    } else {
      this.index = -1;
    }

    return this.nombres[index];
  }
}

public class Main {
  public static void main(String[] args) {
    MesNombres mesNombres = new MesNombres(new int[]{1, 2, 3});
    int prochainNombre = mesNombres.prochain();
  }
}
```