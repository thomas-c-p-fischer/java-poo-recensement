package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.CodeDepartementException;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;

/**
 * Cas d'utilisation: affichage des N villes les plus peuplées d'une département
 * donné
 * 
 * @author DIGINAMIC
 *
 */
public class RechercheVillesPlusPeupleesDepartement extends MenuService {

	@Override
	public void traiter(Recensement recensement, Scanner scanner) throws CodeDepartementException {

		System.out.println("Veuillez saisir un numéro de département:");
		String nomDept = scanner.nextLine();
		
		if(!(
				(Integer.parseInt(nomDept) >= 1 && Integer.parseInt(nomDept) <= 95) || 
				(Integer.parseInt(nomDept) >= 971 && Integer.parseInt(nomDept) <= 978) ||
				Integer.parseInt(nomDept) == 984 ||
				(Integer.parseInt(nomDept) >= 986 && Integer.parseInt(nomDept) <= 989))) 
			{
				throw new CodeDepartementException("Le code département n'existe pas.");
			}else if(!(nomDept.matches("[0-9]+"))) {
				throw new NumberFormatException("Votre saisie est incorrecte veuillez saisir un chiffre entier.");
			}
		
		System.out.println("Veuillez saisir un nombre de villes:");
		String nbVillesStr = scanner.nextLine();
		int nbVilles = Integer.parseInt(nbVillesStr);

		List<Ville> villesDept = new ArrayList<Ville>();

		List<Ville> villes = recensement.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(nomDept)) {
				villesDept.add(ville);
			}
		}

		Collections.sort(villesDept, new EnsemblePopComparateur(false));

		if (villesDept.size() > 0) {
			System.out.println("Les " + nbVilles + " villes les plus peuplées du département " + nomDept + " :");
			for (int i = 0; i < nbVilles; i++) {
				Ville ville = villesDept.get(i);
				System.out.println(ville.getNom() + " : " + ville.getPopulation() + " habitants.");
			}
		} 
	}

}
