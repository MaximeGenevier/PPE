/**
 * 
 */
package fr.applirv.appli.vues;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueListePraticiens étend JPanel
 * Elle est appelée lorsque l'utilisateur
 * veut voir la liste des praticiens
 *
 */
public class VueListePraticiens extends JPanel{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel 		lbListePraticiens = new JLabel("Les praticiens hésitants");
	private JTable 		tabPraticiens;
	private JScrollPane spPraticiens;
	
	/**
	 * Constructeur de la vue
	 */
	public VueListePraticiens(){
		
		super();
		/*
		 * On donne une taille 
		 * et on rend visible
		 * la vue
		 */
		this.creerInterface();
		this.setSize(600,400);
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Méthode qui créée l'interface de la vue
	 */
	private void creerInterface(){
		
		this.tabPraticiens = new JTable();
		this.tabPraticiens.setRowHeight(15);
		spPraticiens = new JScrollPane(this.tabPraticiens);
		spPraticiens.setPreferredSize(new Dimension(500,125));
		
		//Boite principale
		Box bPrincipale = Box.createVerticalBox();
		
		//Boite titre
		Box bTitre = Box.createHorizontalBox();
		bTitre.add(lbListePraticiens);
		
		//Boite tableau praticiens
		Box bListe = Box.createHorizontalBox();
		bListe.add(Box.createHorizontalStrut(15));
		bListe.add(Box.createVerticalStrut(50));
		bListe.add(spPraticiens);
		
		bPrincipale.add(bTitre);
		bPrincipale.add(bListe);
		
		this.add(bPrincipale);
		
	}

	
	
				/********** Getters et Setters de la classe **********/
	
	
	
	/**
	 * @return the tabPraticiens
	 */
	public JTable getTabPraticiens() {
		return tabPraticiens;
	}


	/**
	 * @param tabPraticiens the tabPraticiens to set
	 */
	public void setTabPraticiens(JTable tabPraticiens) {
		this.tabPraticiens = tabPraticiens;
	}

	/**
	 * @return the lbListePraticiens
	 */
	public JLabel getLbListePraticiens() {
		return lbListePraticiens;
	}

	/**
	 * @param lbListePraticiens the lbListePraticiens to set
	 */
	public void setLbListePraticiens(JLabel lbListePraticiens) {
		this.lbListePraticiens = lbListePraticiens;
	}

	/**
	 * @return the spPraticiens
	 */
	public JScrollPane getSpPraticiens() {
		return spPraticiens;
	}

	/**
	 * @param spPraticiens the spPraticiens to set
	 */
	public void setSpPraticiens(JScrollPane spPraticiens) {
		this.spPraticiens = spPraticiens;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
