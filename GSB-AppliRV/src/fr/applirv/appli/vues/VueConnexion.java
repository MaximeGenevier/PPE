/**
 * 
 */
package fr.applirv.appli.vues;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.applirv.appli.controleurs.ControleurConnexion;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueConnexion étend JDialog
 * Elle est appelée lorsque l'utilisateur
 * veut se connecter
 *
 */
public class VueConnexion extends JDialog{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;

	//Vue parente
	private VueAppli vueParente;
	
	//Contrôleur associé à la vue
	private ControleurConnexion controleur;
	
	//Label
	private JLabel lbIdentifiant 		= new JLabel("Identifiant :");
	private JLabel lbMdp 				= new JLabel("Mot de passe :");
	
	//Champs de saisie
	private JTextField tfIdentifiant 	= new JTextField(10);
	private JPasswordField pfMdp 		= new JPasswordField();
	
	//Boutons
	private JButton bConnecter 			= new JButton("Connexion");
	private JButton bAnnuler 			= new JButton("Annuler");
	
	
	/**
	 * @param vueParente La vue parente de celle-ci
	 */
	public VueConnexion(VueAppli vueParente){
		
		//Appel au constructeur JDialog
		super(vueParente,"Connexion",true);
		
		//Ajout de la vue parente
		this.vueParente = vueParente;
		
		//On créée l'interface
		this.creerInterface();
		
		/*On optimise le placement des composants,
		 * définit la position de la fenêtre à null,
		 * impossible de redimensionner la fenêtre,
		 * rend visible la fenêtre,
		 * et définit le controleur
		*/
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.controleur = new ControleurConnexion(this);
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Cette méthode créée l'interface 
	 */
	private void creerInterface(){
		
		//On définit le gestionnaire : GridLayout
		//On fixe l'espacement entre les composants à 5px
		GridLayout agenceur = new GridLayout(3,2);
		agenceur.setHgap(5);
		agenceur.setVgap(5);
		
		//On définit le gestionnaire
		this.setLayout(agenceur);
		
		//On créé le panneau
		Container panneau = this.getContentPane();
		
		//On attribue les labels à leur champs respectifs
		//Et on modifie le caractère de base du champs mot de passe
		this.lbIdentifiant.setLabelFor(tfIdentifiant);
		this.lbMdp.setLabelFor(pfMdp);
		this.pfMdp.setEchoChar('\u2623');
		
		//On ajoute les composants au panneau
		panneau.add(this.lbIdentifiant);
		panneau.add(this.tfIdentifiant);
		panneau.add(this.lbMdp);
		panneau.add(this.pfMdp);
		panneau.add(this.bConnecter);
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
	public ControleurConnexion getControleur() {
		return controleur;
	}

	/**
	 * @return the lbIdentifiant
	 */
	public JLabel getLbIdentfiant() {
		return lbIdentifiant;
	}

	/**
	 * @return the lbMdp
	 */
	public JLabel getLbMdp() {
		return lbMdp;
	}

	/**
	 * @return the tfIdentifiant
	 */
	public JTextField getTfIdentifiant() {
		return tfIdentifiant;
	}

	/**
	 * @return the pfMdp
	 */
	public JPasswordField getPfMdp() {
		return pfMdp;
	}

	/**
	 * @return the bConnecter
	 */
	public JButton getbConnecter() {
		return bConnecter;
	}

	/**
	 * @return the bAnnuler
	 */
	public JButton getbAnnuler() {
		return bAnnuler;
	}



	/**
	 * @return the lbIdentifiant
	 */
	public JLabel getLbIdentifiant() {
		return lbIdentifiant;
	}



	/**
	 * @param lbIdentifiant the lbIdentifiant to set
	 */
	public void setLbIdentifiant(JLabel lbIdentifiant) {
		this.lbIdentifiant = lbIdentifiant;
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
	public void setControleur(ControleurConnexion controleur) {
		this.controleur = controleur;
	}



	/**
	 * @param lbMdp the lbMdp to set
	 */
	public void setLbMdp(JLabel lbMdp) {
		this.lbMdp = lbMdp;
	}



	/**
	 * @param tfIdentifiant the tfIdentifiant to set
	 */
	public void setTfIdentifiant(JTextField tfIdentifiant) {
		this.tfIdentifiant = tfIdentifiant;
	}



	/**
	 * @param pfMdp the pfMdp to set
	 */
	public void setPfMdp(JPasswordField pfMdp) {
		this.pfMdp = pfMdp;
	}



	/**
	 * @param bConnecter the bConnecter to set
	 */
	public void setbConnecter(JButton bConnecter) {
		this.bConnecter = bConnecter;
	}



	/**
	 * @param bAnnuler the bAnnuler to set
	 */
	public void setbAnnuler(JButton bAnnuler) {
		this.bAnnuler = bAnnuler;
	}

}
