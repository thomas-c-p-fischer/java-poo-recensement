package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.CodeDepartementException;
import fr.diginamic.recensement.exceptions.IntMaxException;
import fr.diginamic.recensement.exceptions.IntMinException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws 
	IntMinException, 
	IntMaxException,  
	CodeDepartementException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		if(!(
			(Integer.parseInt(choix) >= 1 && Integer.parseInt(choix) <= 95) || 
			(Integer.parseInt(choix) >= 971 && Integer.parseInt(choix) <= 978) ||
			Integer.parseInt(choix) == 984 ||
			(Integer.parseInt(choix) >= 986 && Integer.parseInt(choix) <= 989))) 
		{
			throw new CodeDepartementException("Le code département n'existe pas.");
		}
		
		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		
		// Exception de saisie négative pour la population minimale
		if(Integer.parseInt(saisieMin) < 0) {
			throw new IntMinException("La population minimale ne peut pas être négative.");
		} else if(!(saisieMin.matches("[0-9]+"))) {
			throw new NumberFormatException("Votre saisie est incorrecte veuillez saisir un chiffre entier.");
		}
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		// Exception de saisie négative pour la population minimale
		if(Integer.parseInt(saisieMax) < 0) {
			throw new IntMaxException("La population maximale ne peut pas être négative.");
		} else if(Integer.parseInt(saisieMax) < Integer.parseInt(saisieMin)) {
			throw new IntMaxException("La population maximale ne peut pas être inférieur à la population minimale.");
		} else if(!(saisieMax.matches("[0-9]+"))) {
			throw new NumberFormatException("Votre saisie est incorrecte veuillez saisir un chiffre entier.");
		}
				
		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
