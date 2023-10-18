/** Package des Exceptions créées */
package fr.diginamic.recensement.exceptions;

/**
 * Création d'un exception pour la saisie de l'int minimal
 * @author thomas.fischer
 */
public class IntMinException extends Exception {
	
	/** Constructeur
	 * @param message
	 */
	public IntMinException(String message) {
		super(message);
	}
}