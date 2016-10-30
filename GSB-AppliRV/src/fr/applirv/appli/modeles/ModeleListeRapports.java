/**
 * 
 */
package fr.applirv.appli.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.applirv.appli.entites.RapportVisite;;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ModeleListeRapports étend AbstractTableModel
 * Elle sert de modèle de JTable
 *
 */
public class ModeleListeRapports extends AbstractTableModel{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;

	private String[] 			entetes = {"Nom praticien","Ville praticien","Date de visite","Date de rédaction",""};
	private List<RapportVisite> rapports;
	
	/**
	 * @param matricule matricule du visiteur
	 * @param annee annee sélectionnée
	 * @param mois mois sélectionné
	 * 
	 * Constructeur de la classe
	 */
	public ModeleListeRapports(String matricule, int annee, int mois){
		
		super();
		
		//ON ESSAIE
		try {
			
			/*
			 * D'affecter à la variable rapports le résultat de la méthode
			 * getLesRapportsDeVisite du modele ModeleAppliRV
			 */
			this.rapports = ModeleAppliRV.getModele().getLesRapportsDeVisite(matricule, mois, annee);
			
		}
		//ON RECUPERE
		catch (Exception e) {
			
			//Une exception et on affiche son message
			e.getMessage();
			
		}
		
	}

	/**
	 * Méthode qui retourne le nombre ligne de la variable lesPraticiens
	 */
	public int getRowCount() {
		
		return this.rapports.size();
		
	}

	/**
	 * Méthode qui retourne la longueur de la variable enetetes
	 */
	public int getColumnCount() {
		
		return this.entetes.length;
		
	}

	/**
	 * Méthode qui récupère la valeur à l'indice x du tableau
	 */
	public Object getValueAt(int x, int y) {
		
		//ON CHANGE de colonne
		switch(y){
		
			//La première colonne
			case 0 :
				
				//On retourne le nom du praticien à l'indice x de la variable rapports
				return this.rapports.get(x).getLePraticien().getNom();
			
			//La deuxième colonne
			case 1 :
				
				//On retourne la ville du praticien à l'indice x de la variable rapports
				return this.rapports.get(x).getLePraticien().getVille();
			
			//La troisième colonne
			case 2 :
				
				//On retourne la date de visite du rapport de visite à l'indice x de la variable rapports
				return this.rapports.get(x).getDateVisite();
			
			//La quatrième colonne
			case 3 :
				
				//On retourne la date du rapport de rédaction du rapport de visite à l'indice x de la variable rapports
				return this.rapports.get(x).getDateRapport();
			
			//La cinquième colonne 
			case 4 :
				
				//On retourne la chaine de caractère Lire pour le bouton
				return "Lire";
			
			//Par défaut 
			default :
				
				//On retourne null
				return null;
				
		}
		
	}
	
	/**
	 * Méthode qui retourne le nom de la colonne à l'indice x de la variable entetes
	 */
	public String getColumnName(int x){
		
		return this.entetes[x].toString();
		
	}
	
	/**
	 * @param x l'indice de la colonne
	 * @return Class la classe de la colonne
	 * 
	 * Méthode permettant de récupérer la classe de la colonne
	 */
	public Class<?> getColumClass(int x){
		
		//ON CHANGE de colonne
		switch(x){
		
			//Première colonne
			case 0 :
				
				//On retourne la classe String
				return String.class;
			
			//Deuxième colonne
			case 1 :
				
				//On retourne la classe String
				return String.class;
			
			//Troisième colonne
			case 2 :
				
				//On retourne la classe Date
				return Date.class;
			
			//Quatrième colonne
			case 3 : 
				
				//On retourne la classe Date
				return Date.class;
			
			//Cinquième colonne
			case 4 :
				
				//On retourne la classe String
				return String.class;
			
			//Par défaut
			default:
				
				//On retourne null
				return null;
			
		}
		
	}
	
	/**
	 * Cette méthode permet d'actualiser le tableau
	 */
	public void actualiser(){
		
		//Les données du tableau ont changé
		this.fireTableDataChanged();
		
	}

	/**
	 * Méthode qui permet de savoir si une cellule est éditable
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		//SI la colonne vaut 4
		if(columnIndex == 4){
			
			//On retourne vrai
			return true;
			
		}
		//SINON
		else{
			
			//On retourne faux
			return false;
			
		}
		
	}
	
}
