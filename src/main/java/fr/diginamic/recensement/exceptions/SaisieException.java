/** Package des Exceptions créées */
package fr.diginamic.recensement.exceptions;

/**
 * Création d'un exception pour la saisie
 * @author thomas.fischer
 */
public class SaisieException extends Exception {
	/** Constructeur
	 * @param message
	 */
	public SaisieException(String message) {
		super(message);
	}
}