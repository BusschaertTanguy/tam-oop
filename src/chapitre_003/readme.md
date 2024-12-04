# 3. Abstraction procédurale

Les abstractions procedural en Java sont les fonctions `static` d'une class.

La methode est donc appelée au niveau de la class, et pas de l'instance

## Abstraction par specification

La specification est la syntaxe et la documentation qui permet de comprendre ce qu'une abstraction (class, fonction) fait, sans devoir consutler le detial de cette abstraction.

2 properietes:
- localité
- modifiabilité

Une specifiaction peut etre ecrite en langange:
- formel: p.e. semantique mathematique
  - description objective
  - nescessite connaissance
- informel: p.e. le francais
    - description subjective
    - comprehensible


### Localité

L'abstraction peut etre comprise sans connaitre les details de l'implementation.

Permet l'indépendance des produceurs et consomateurs de l'abstraction.

### Modifiabilité

L'implementation de l'abstraction peut etre changee sans impacter les consomateurs


### Anatomie d'une specification

La signature (syntaxe) de la fonction
- nom
- parametres
- type de retour
- exceptions (chapitre 4)

```java
public static int division(int a, int b) throws  IllegalArgumentException{
    if(b == 0) {
        throw new IllegalArgumentException("Le diviseur ne peut pas etre 0");
    }

    return a / b;
}
```

La description des effets:
- information semantique en forme de commentaire

```java
/**
 * @requires preconditions 
 * @modifies liste des parametres modifiés par la fonction
 * @effects les effets secondaires de la fonction          
 * @return information sur la valeur de retour
 * @throws IllegalArgumentException information sur les exceptions possible
 */
public static int division(int a, int b) throws  IllegalArgumentException{
    if(b == 0) {
        throw new IllegalArgumentException("Le diviseur ne peut pas etre 0");
    }
    
    return a / b;
}
```

#### Anatomie : requires
- Specifie les conditions sous lesquelles la fonction est definie
- Seulement utile si la procedure est partielle (comportement definie par tous les parametres)

#### Anatomie : modifies
- Nom des parametres modifies par la procedure

#### Anatomie : effects
- Les effets sur les inputs pas mentiones dans @requires

#### Anatomie : return
- La valeur de retour de la fonction

#### Anatomie: throws
- Les exceptions lancees par la fonction

Voici un exemple concret d'une calculatrice

```java
/**
 * Fournis des procedures servant a calculer
 */
public class Calculatrice {
  /**
   * @return Retourne la somme du chiffre a et b.
   */
    public static int somme(int a, int b) {
        return a + b;
    }

  /**
   * @return Retourne la division du chiffre a et b.
   * @throws IllegalArgumentException si le chiffre b est 0.
   */
  public static double division(double a, double b) throws IllegalArgumentException {
    if(b == 0) {
      throw new IllegalArgumentException("Le diviseur ne peut pas etre 0");
    }

    return a / b;
  }
}
```