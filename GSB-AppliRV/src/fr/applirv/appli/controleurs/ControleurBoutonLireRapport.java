/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import fr.applirv.appli.vues.VueLireRapportVisite;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ControleurBoutonLireRapport implémente l'interface
 * ActionListener, elle génère une vue VueLireRapportVisite en
 * cas d'interaction avec un bouton.
 *
 */
public class ControleurBoutonLireRapport implements ActionListener {

	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private int 	row;
	private int 	column;
	private String 	matricule;
	private int 	annee;
	private int 	mois;
	private JTable 	table;
	
	/**
	 * @param matricule le matricule du visiteur sélectionné
	 * @param annee l'année sélectionnée
	 * @param mois le mois sélectionné
	 */
	public ControleurBoutonLireRapport(String matricule, int annee, int mois) {
		
		super();
		this.matricule = matricule;
		this.annee = annee;
		this.mois = mois;

	}
	
	
	
				/********** Traitement de l'interaction avec le bouton **********/
	
	
	
	/**
	 * Méthode qui génère une vue VueLireRapportVisite en cas
	 * d'interaction avec un bouton.
	 */
	public void actionPerformed(ActionEvent e) {
		
		new VueLireRapportVisite(row, matricule, annee, mois);
		
	}

	
	
				/********** Getters et Setters de la classe **********/
	
	
	
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	
}
