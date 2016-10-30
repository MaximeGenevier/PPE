/**
 * 
 */
package fr.applirv.appli.vues;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import fr.applirv.appli.controleurs.ControleurPraticien;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VuePraticien étend JDialog
 * Elle est appelée lorsque l'utilisateur
 * souhaite consulter la liste des praticiens
 * Il doit alors saisir un critère de tri depuis
 * cette vue
 *
 */
public class VuePraticiens extends JDialog{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	//Création de la vue parente et du controleur
	private VueAppli 			vueParente;
	private ControleurPraticien controleur;
	
	//Création des composants
	private JLabel 				lbCriteresTri 	= new JLabel("Les critères de tri : ");
	private String[] 			criteres 		= {"Coefficient de confiance", "Temps écoulé depuis la dernière visite","Coefficient de notoriété du praticien"};
	private JComboBox<String> 	lstCriteresTri 	= new JComboBox<String>(criteres);
	private JButton 			bValider 		= new JButton("Valider");
	private JButton 			bAnnuler 		= new JButton("Annuler");
	
	
	/**
	 * @param vueParente La vue parente
	 * Constructeur de la vue
	 */
	public VuePraticiens(VueAppli vueParente){
		
		//Appel au constructeur JDialog
		super(vueParente,"Critère de tri");
		
		this.vueParente = vueParente;
		
		//On créé l'interface
		this.creerInterface();
		
		/*On optimise l'agencement des composants,
		 * on définit la position à null,
		 * on empêche le redimensionnement de la fenêtre,
		 * on rend la fenêtre visible,
		 * et on lui affecte son contrôleur
		 */
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.controleur = new ControleurPraticien(this);
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Méthode qui créée l'interface de la vue
	 */
	private void creerInterface(){
		
		//On créé l'agenceur de composant
		GridLayout agenceur = new GridLayout(3,2);
		agenceur.setHgap(5);
		agenceur.setVgap(5);
		
		//On affecte à la vue l'agenceur précédemment créé
		this.setLayout(agenceur);
		
		//On créé un container 
		Container panneau = this.getContentPane();
		
		//On affecte le label à son champs 
		this.lbCriteresTri.setLabelFor(lstCriteresTri);
		
		//On ajoute les composants au container
		panneau.add(this.lbCriteresTri);
		panneau.add(this.lstCriteresTri);
		panneau.add(this.bValider);
		panneau.add(this.bAnnuler);
		
	}

	
	
				/********** Getters et Setters de la classe **********/
	
	
	
	/**
	 * @return the vueParente
	 */
	public VueAppli getVueParente() {
		return vueParente;
	}

	/**
	 * @return the controleur
	 */
	public ControleurPraticien getControleur() {
		return controleur;
	}

	/**
	 * @return the lbCriteresTri
	 */
	public JLabel getLbCriteresTri() {
		return lbCriteresTri;
	}

	/**
	 * @return the criteres
	 */
	public String[] getCriteres() {
		return criteres;
	}

	/**
	 * @return the lstCriteresTri
	 */
	public JComboBox<String> getLstCriteresTri() {
		return lstCriteresTri;
	}

	/**
	 * @return the bAfficher
	 */
	public JButton getbValider() {
		return bValider;
	}

	/**
	 * @return the bAnnuler
	 */
	public JButton getbAnnuler() {
		return bAnnuler;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @param vueParente the vueParente to set
	 */
	public void setVueParente(VueAppli vueParente) {
		this.vueParente = vueParente;
	}



	/**
	 * @param controleur the controleur to set
	 */
	public void setControleur(ControleurPraticien controleur) {
		this.controleur = controleur;
	}



	/**
	 * @param lbCriteresTri the lbCriteresTri to set
	 */
	public void setLbCriteresTri(JLabel lbCriteresTri) {
		this.lbCriteresTri = lbCriteresTri;
	}



	/**
	 * @param criteres the criteres to set
	 */
	public void setCriteres(String[] criteres) {
		this.criteres = criteres;
	}



	/**
	 * @param lstCriteresTri the lstCriteresTri to set
	 */
	public void setLstCriteresTri(JComboBox<String> lstCriteresTri) {
		this.lstCriteresTri = lstCriteresTri;
	}



	/**
	 * @param bValider the bValider to set
	 */
	public void setbValider(JButton bValider) {
		this.bValider = bValider;
	}



	/**
	 * @param bAnnuler the bAnnuler to set
	 */
	public void setbAnnuler(JButton bAnnuler) {
		this.bAnnuler = bAnnuler;
	}	

}
