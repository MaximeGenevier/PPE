package fr.applirv.appli.vues;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.applirv.appli.controleurs.ControleurChangerMotDePasse;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueChangerMotDePasse étend JDialog
 * Elle est appelée lorsque l'utilisateur veut changer
 * son mot de passe
 *
 */
public class VueChangerMotDePasse extends JDialog {

	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;

	//Vue parente
	private VueAppli vueParente;
	
	//Contrôleur associé à la vue
	private ControleurChangerMotDePasse controleur;
	
	//Labels
	private JLabel lbAncienMdp 			= new JLabel("Saisissez votre ancien mot de passe: ");
	private JLabel lbNouveauMdp1 		= new JLabel("Saisissez votre nouveau mot de passe: ");
	private JLabel lbNouveauMdp2 		= new JLabel("Saisissez encore une fois votre nouveau mot de passe: ");
	
	//Champs de saisie
	private JTextField tfAncienMdp 		= new JTextField(10);
	private JTextField pfNouveauMdp1 	= new JPasswordField();
	private JTextField pfNouveauMdp2 	= new JPasswordField();
	
	//Boutons
	private JButton bValider 			= new JButton("Valider");
	private JButton bAnnuler 			= new JButton("Annuler");
	
	/**
	 * @param vueParente La vue parente de celle-ci
	 */
	public VueChangerMotDePasse(VueAppli vueParente){
		
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
		this.controleur = new ControleurChangerMotDePasse(this);
		this.setVisible(true);
		
	}
	
				/********** Méthode de gestion de la vue **********/

	/**
	 * Méthode qui créée l'interface de la vue
	 */
	private void creerInterface() {
		
		//On définit le gestionnaire : GridLayout
		//On fixe l'espacement entre les composants à 5px
		GridLayout agenceur = new GridLayout(4,2);
		agenceur.setHgap(5);
		agenceur.setVgap(5);
				
		//On définit le gestionnaire
		this.setLayout(agenceur);
				
		//On créé le panneau
		Container panneau = this.getContentPane();
		
		//On attribue les labels à leur champs respectifs
		//Et on modifie le caractère de base du champs mot de passe
		this.lbAncienMdp.setLabelFor(tfAncienMdp);
		this.lbNouveauMdp1.setLabelFor(pfNouveauMdp1);
		((JPasswordField) this.pfNouveauMdp1).setEchoChar('\u2623');
		this.lbNouveauMdp2.setLabelFor(pfNouveauMdp2);
		((JPasswordField) this.pfNouveauMdp2).setEchoChar('\u2623');
		
		//On ajoute les composants au panneau
		panneau.add(this.lbAncienMdp);
		panneau.add(this.tfAncienMdp);
		panneau.add(this.lbNouveauMdp1);
		panneau.add(this.pfNouveauMdp1);
		panneau.add(this.lbNouveauMdp2);
		panneau.add(this.pfNouveauMdp2);
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
	 * @param vueParente the vueParente to set
	 */
	public void setVueParente(VueAppli vueParente) {
		this.vueParente = vueParente;
	}

	/**
	 * @return the controleur
	 */
	public ControleurChangerMotDePasse getControleur() {
		return controleur;
	}

	/**
	 * @param controleur the controleur to set
	 */
	public void setControleur(ControleurChangerMotDePasse controleur) {
		this.controleur = controleur;
	}

	/**
	 * @return the lbAncienMdp
	 */
	public JLabel getLbAncienMdp() {
		return lbAncienMdp;
	}

	/**
	 * @param lbAncienMdp the lbAncienMdp to set
	 */
	public void setLbAncienMdp(JLabel lbAncienMdp) {
		this.lbAncienMdp = lbAncienMdp;
	}

	/**
	 * @return the lbNouveauMdp1
	 */
	public JLabel getLbNouveauMdp1() {
		return lbNouveauMdp1;
	}

	/**
	 * @param lbNouveauMdp1 the lbNouveauMdp1 to set
	 */
	public void setLbNouveauMdp1(JLabel lbNouveauMdp1) {
		this.lbNouveauMdp1 = lbNouveauMdp1;
	}

	/**
	 * @return the lbNouveauMdp2
	 */
	public JLabel getLbNouveauMdp2() {
		return lbNouveauMdp2;
	}

	/**
	 * @param lbNouveauMdp2 the lbNouveauMdp2 to set
	 */
	public void setLbNouveauMdp2(JLabel lbNouveauMdp2) {
		this.lbNouveauMdp2 = lbNouveauMdp2;
	}

	/**
	 * @return the tfAncienMdp
	 */
	public JTextField getTfAncienMdp() {
		return tfAncienMdp;
	}

	/**
	 * @param tfAncienMdp the tfAncienMdp to set
	 */
	public void setTfAncienMdp(JTextField tfAncienMdp) {
		this.tfAncienMdp = tfAncienMdp;
	}

	/**
	 * @return the pfNouveauMdp1
	 */
	public JTextField getPfNouveauMdp1() {
		return pfNouveauMdp1;
	}

	/**
	 * @param pfNouveauMdp1 the pfNouveauMdp1 to set
	 */
	public void setPfNouveauMdp1(JPasswordField pfNouveauMdp1) {
		this.pfNouveauMdp1 = pfNouveauMdp1;
	}

	/**
	 * @return the pfNouveauMdp2
	 */
	public JTextField getPfNouveauMdp2() {
		return pfNouveauMdp2;
	}

	/**
	 * @param pfNouveauMdp2 the pfNouveauMdp2 to set
	 */
	public void setPfNouveauMdp2(JPasswordField pfNouveauMdp2) {
		this.pfNouveauMdp2 = pfNouveauMdp2;
	}

	/**
	 * @return the bValider
	 */
	public JButton getbValider() {
		return bValider;
	}

	/**
	 * @param bValider the bValider to set
	 */
	public void setbValider(JButton bValider) {
		this.bValider = bValider;
	}

	/**
	 * @return the bAnnuler
	 */
	public JButton getbAnnuler() {
		return bAnnuler;
	}

	/**
	 * @param bAnnuler the bAnnuler to set
	 */
	public void setbAnnuler(JButton bAnnuler) {
		this.bAnnuler = bAnnuler;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param pfNouveauMdp1 the pfNouveauMdp1 to set
	 */
	public void setPfNouveauMdp1(JTextField pfNouveauMdp1) {
		this.pfNouveauMdp1 = pfNouveauMdp1;
	}

	/**
	 * @param pfNouveauMdp2 the pfNouveauMdp2 to set
	 */
	public void setPfNouveauMdp2(JTextField pfNouveauMdp2) {
		this.pfNouveauMdp2 = pfNouveauMdp2;
	}

	
}
