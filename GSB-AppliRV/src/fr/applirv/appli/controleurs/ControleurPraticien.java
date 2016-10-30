/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.applirv.appli.modeles.ModeleListePraticiens;
import fr.applirv.appli.vues.VueListePraticiens;
import fr.applirv.appli.vues.VuePraticiens;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ControleurPraticien implémente l'interface
 * ActionListener, elle traite les interactions de l'utilisateur
 * avec les composants de la vue
 *
 */
public class ControleurPraticien implements ActionListener{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private VuePraticiens vue;
	
	/**
	 * @param vue La vue du controleur
	 */
	public ControleurPraticien(VuePraticiens vue){
		
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
		
	}
	
	
	
				/********** Enregistrement et traitement des actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui met à l'écoute les différents composants de la vue
	 */
	private void enregistrerEcouteur(){
		this.vue.getbValider().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
	}

	/**
	 * Méthode qui appelle une méthode en fonction du composant
	 * avec lequel interagit l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		
		//On récupère la source de l'action
		Object source = e.getSource();
		
		//SI la source de l'événement est le bouton valider
		if(source == this.vue.getbValider()){
			
			//On appelle la méthode afficher du controleur
			this.afficher();
			
		}
		//SINON SI la source de l'événement est le bouton annuler
		else if(source == this.vue.getbAnnuler()){
			
			//On ferme la fenêtre
			this.vue.dispose();
			
		}
		
	}
	
	
	
				/********** Implémentation des méthodes qui traitent les actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui affiche les praticiens 
	 * selon le critère choisi par l'utilisateur
	 */
	private void afficher(){
		
		System.out.println("ControleurPraticien::afficher()");
		//On récupère l'item choisi
		String choix = (String) this.vue.getLstCriteresTri().getSelectedItem();
		//On instancie une vue VueListePraticiens
		VueListePraticiens vue = new VueListePraticiens();
		//On affecte au tableau de la vue le modele ModeleListePraticiens
		vue.getTabPraticiens().setModel(new ModeleListePraticiens(choix));
		
		//On change la vue du CardLayout de la vue parente
		this.vue.getVueParente().getContentPane().add("Liste des praticiens", vue);
		this.vue.getVueParente().changerVue("Liste des praticiens");
		//On ferme la boite de dialogue
		this.vue.dispose();
	
	}
	
}
