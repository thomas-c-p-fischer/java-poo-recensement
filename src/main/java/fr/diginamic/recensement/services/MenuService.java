package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.exceptions.CodeDepartementException;
import fr.diginamic.recensement.exceptions.IntMaxException;
import fr.diginamic.recensement.exceptions.IntMinException;
import fr.diginamic.recensement.exceptions.SaisieException;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws CodeDepartementException 
	 * @throws IntMaxException 
	 * @throws IntMinException 
	 * @throws SaisieException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws 
	IntMinException, 
	IntMaxException,  
	CodeDepartementException, SaisieException;
}
