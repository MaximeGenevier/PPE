/**
 * 
 */
package fr.applirv.appli.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.applirv.appli.entites.Praticien;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ModeleListePraticiens étend AbstractTableModel
 * Elle sert de modèle de JTable
 *
 */
public class ModeleListePraticiens extends AbstractTableModel{

	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	private String[] 		entetes = {"Nom praticien","Ville praticien"};
	private List<Praticien> lesPraticiens;
	
	/**
	 * @param choix le choix de l'utilisateur
	 * 
	 * Constructeur de la classe
	 */
	public ModeleListePraticiens(String choix) {
		
		super();
		
		//ON ESSAIE
		try{
			
			//SI le choix vaut Coefficient de confiance
			if(choix == "Coefficient de confiance"){
				
				/*
				 * On affecte à la variable lesPraticiens le resultat de la méthode
				 * getLesPraticiensParConfiance du modele ModeleAppliRV
				 */
				lesPraticiens = ModeleAppliRV.getModele().getLesPraticiensParConfiance();
			
			}
			//SINON SI le choix vaut Temps écoulé depuis la dernière visite
			else if(choix == "Temps écoulé depuis la dernière visite"){
				
				/*
				 * On affecte à la variable lesPraticiens le résultat de la méthode
				 * getLesPraticiensParDate du modele ModeleAppliRV
				 */
				lesPraticiens = ModeleAppliRV.getModele().getLesPraticiensParDate();
			
			}
			//SINON SI le choix vaut Coefficient de notoriete du praticien
			else if(choix == "Coefficient de notoriété du praticien"){
				
				/*
				 * On affecte à la variable lesPraticiens le résultat de la méthode
				 * getLesPraticiensParDate du modele ModeleAppliRV
				 */
				lesPraticiens = ModeleAppliRV.getModele().getLesPraticiensParNotoriete();
			
			}
			
		}
		//ON RECUPERE
		catch(Exception e){
			
			//Une exception et on affiche son message
			e.getMessage();
		
		}
		
	}

	/**
	 * Méthode qui retourne le nombre ligne de la variable lesPraticiens
	 */
	public int getRowCount() {
		
		return this.lesPraticiens.size();
		
	}

	/**
	 * Méthode qui retourne la longueur de la variable enetetes
	 */
	public int getColumnCount() {
		
		return this.entetes.length;
		
	}

	/**
	 * Méthode qui récupère la valeur à l'indice rowIndew du tableau
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		//ON CHANGE de colonne
		switch(columnIndex){
		
			//La première colonne
			case 0:
				
				//On retourne le nom du praticien à l'indice rowIndex
				return this.lesPraticiens.get(rowIndex).getNom();
				
			//La deuxième colonne
			case 1:
				
				//On retourne la ville du praticien à l'indice rowIndex
				return this.lesPraticiens.get(rowIndex).getVille();
				
			//Par défaut 
			default:
				
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
	 * 
	 */
	public Class<?> getColumnClass(int x){
		
		//ON CHANGE de colonne
		switch(x){
		
			//Premiere colonne
			case 0:
				
				//On retourne la classe String
				return String.class;
			
			//Deuxieme colonne
			case 1:
				
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

}
