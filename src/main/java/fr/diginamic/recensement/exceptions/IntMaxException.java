/** Package des Exceptions créées */
package fr.diginamic.recensement.exceptions;

/**
 * Création d'un exception pour la saisie de l'int maximal
 * @author thomas.fischer
 */
public class IntMaxException extends Exception {
	
	/** Constructeur
	 * @param message
	 */
	public IntMaxException(String message) {
		super(message);
	}
}