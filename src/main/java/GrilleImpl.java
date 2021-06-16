import java.util.ArrayList;
import java.util.List;

/** Implementation d'une grille. */
public class GrilleImpl implements Grille {

/** Width represente la largeur de la grille. */
private int width = 0;
/** height represente la hauteur de la grille. */
private int height = 0;
/** definition du tabbleau qui represente la grille. */
private char[][] lagrille = null;

/** Constructeur de GrilleImpl.
* Il initialise la grille avec les dimensions
* fournies par le client
* @param wid largeur de la grille
* @param hei hauteur de la grille
*/
public GrilleImpl(final int wid, final int hei) {
    this.width = wid;
    this.height = hei;
    this.lagrille = new char[wid][hei];
    for (int i = 0; i < this.width; i++) {
        for (int j = 0; j < this.height; j++) {
            lagrille[i][j] = EMPTY;
        }
    }
}

/** @return largeur/hauteur de la grille. */
public int getDimension() {
    return this.width / this.height;
}
/**
* Affecte une valeur dans la grille.
* @param x position x dans la grille
* @param y position y dans la grille
* @param value a mettre dans la case
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
* @throws IllegalArgumentException si la valeur est interdite aux vues des
* @return 0 si l'insertion de la valeur reussie
* autres valeurs de la grille
* @throws IllegalArgumentException si value n'est pas
* un caractere autorise ('1',...,'9')
*/
public int setValue(final int x, final int y, final char value) throws IllegalArgumentException {
    if (x > this.width || y > this.height || x < 0 || y < 0) {
        throw new IllegalArgumentException("x or y hors bornes");
    }
    if (!possibleContains(value)) {
        throw new IllegalArgumentException("value n'est pas un caractere authorise");
    }
    this.lagrille[x - 1][y - 1] = value;
    return 0;
}
/** Recupere une valeur de la grille.
* @param x position x dans la grille
* @param y position y dans la grille
* @return valeur dans la case x,y
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
*/
public char getValue(final int x, final int y) throws IllegalArgumentException {
    if (x > this.width || y > this.height || x < 0 || y < 0) {
        throw new IllegalArgumentException("x or y hors bornes");
    }
    return this.lagrille[x - 1][y - 1];
}
/**
* Test si une grille est terminee.
* @return true si la grille est complete
*/
public boolean complete() {
    for (int i = 0; i < this.width; i++) {
        for (int j = 0; j < this.height; j++) {
            if (lagrille[i][j] == EMPTY) {
                return false;
            }
        }
    }
    return true;
}
/**
* Test si une valeur est possible dans la grille par rapport
* a ce qu'elle contient deja contient deja.
* @param x position x dans la grille
* @param y position y dans la grille
* @param value valeur a mettre dans la case
* @return true si l'insertion de la valeur est possible
* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
* @throws IllegalArgumentException si value n'est pas
* un caractere autorise ('1',...,'9')
*/
public boolean possible(final int x, final int y, final char value) throws IllegalArgumentException {
    if (x > this.width || y > this.height || x < 0 || y < 0) {
        throw new IllegalArgumentException("x or y hors bornes");
    }
    if (!possibleContains(value)) {
        throw new IllegalArgumentException("value n'est pas un caractere authorise");
    }

for (int i = 0; i < this.width; i++) {
    if ((lagrille[i][y - 1] == value) && ((x - 1) != i)) {
        return false;
    }
}

for (int j = 0; j < this.height; j++) {
    if ((lagrille[x - 1][j] == value) && ((y - 1) != j)) {
        return false;
    }
}
return true;
}
/**
* verifie si @param value est un caractere autorise.
* @return true si le caractere est autorise
*/
public boolean possibleContains(final char value) {
    List possibleAL = new ArrayList();
    for (int i = 0; i < POSSIBLE.length; i++) {
        possibleAL.add(POSSIBLE[i]);
    }
    return (possibleAL.contains(value) || value == EMPTY);
}
}
