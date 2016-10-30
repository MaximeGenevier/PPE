/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.applirv.appli.modeles.ModeleAppliRV;
import fr.applirv.appli.techniques.Session;
import fr.applirv.appli.vues.VueAppli;
import fr.applirv.appli.vues.VueChangerMotDePasse;
import fr.applirv.appli.vues.VueConnexion;
import fr.applirv.appli.vues.VuePraticiens;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ControleurAppli est le controleur principal de l'application.
 * Elle implémente l'interface ActionListener. Elle traite les interactions
 * de l'utilisateur avec les menus de l'application.
 *
 */
public class ControleurAppli implements ActionListener {
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private VueAppli vue;
	
	/**
	 * @param vue La vue principale de l'application
	 */
	public ControleurAppli(VueAppli vue){
		
		super();
		
		//Mémoriser la vue associée
		this.vue = vue;
		
		//Ecouter les items du menu
		this.enregistrerEcouteur();
		
	}
	
	
	
				/********** Enregistrement et traitement des actions de l'utilisateur **********/
	
	
	
	
	/**
	 * Méthode qui met à l'écoute les différents composants de la vue
	 */
	private void enregistrerEcouteur(){
		
		//Ecouter les items de menu
		this.vue.getItemSeConnecter().addActionListener(this);
		
		this.vue.getItemSeDeconnecter().addActionListener(this);
		
		this.vue.getItemChangerMotDePasse().addActionListener(this);
		
		this.vue.getItemQuitter().addActionListener(this);
		
		this.vue.getItemRapportVisite().addActionListener(this);
		
		this.vue.getItemPraticien().addActionListener(this);
		
		this.vue.getItemAPropos().addActionListener(this);
		
	}

	/**
	 * Méthode qui appelle une méthode selon l'item avec lequel
	 * interagit l'utilisateur 
	 */
	public void actionPerformed(ActionEvent e) {
		
		//Récupération de la source de l'événement
		Object sourceEvenement = e.getSource();
		
		//SI la source de l'événement est l'item se connecter
		if( sourceEvenement == this.vue.getItemSeConnecter() ){
			
			//On appelle la méthode seConnecter du controleur
			this.seConnecter();
			
		} 
		
		//SINON SI la source de l'événement est l'item se déconnecter
		else if( sourceEvenement == this.vue.getItemSeDeconnecter()){
			
			//On appelle la méthode seDeconnecter du controleur
			this.seDeconnecter();
			
		}
		
		//SINON SI la source de l'événement est l'item changer de mot de passe
		else if( sourceEvenement == this.vue.getItemChangerMotDePasse()){
			
			//ON ESSAIE
			try {
				
				//D'appeler la méthode changerMdp du controleur
				this.changerMdp();
				
			} 
			//ON RECUPERE
			catch (Exception e1) {
				
				//Une exception et on affiche son message
				e1.printStackTrace();
				
			}
			
		}
		
		//SINON SI la source de l'événement est l'item quitter
		else if( sourceEvenement == this.vue.getItemQuitter()){
			
			//On appelle la méthode quitter du controleur
			this.quitter();
			
		}
		
		//SINON SI la source de l'événement est l'item rapport visite
		else if( sourceEvenement == this.vue.getItemRapportVisite()){
			
			//On appelle la méthode changerVue de la vue du controleur
			this.vue.changerVue("Rapport de visite");
			this.vue.getVueRapportVisite().creerInterface();
			
		}
		
		//SINON SI la source de l'événement est l'item praticien
		else if( sourceEvenement == this.vue.getItemPraticien()){
			
			//On appelle la méthode consulterPraticien du controleur
			this.consulterPraticien();
			
		}
		
		//SINON SI la source de l'événement est l'item a propos
		else if( sourceEvenement == this.vue.getItemAPropos()){
			
			//On appelle la méthode afficherAPropos du controleur
			this.afficherAPropos();

		}
		
	}
	
	
	
				/********** Implémentation des méthodes qui traitent les actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui ouvre une fenêtre de connexion
	 */
	private void seConnecter(){
		
		System.out.println("ControleurAppli::seConnecter()");
		
		//Affiche la vue de connexion
		new VueConnexion(this.vue);
		
	}
	
	/**
	 * Méthode qui déconnecte l'utilisateur
	 */
	private void seDeconnecter(){
		
		System.out.println("ControleurAppli::seDeconnecter()");
		
		//Récupère la réponse de l'utilisateur sous forme d'entier
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment vous déconnecter ?", "Déconnexion", JOptionPane.YES_NO_OPTION);
		
		//SI la réponse est OUI
		if(reponse == JOptionPane.YES_OPTION){
			
			//On récupère l'identifiant du visiteur
			String identifiant = Session.getSession().getLeVisiteur().getLogin();
			
			//ON ESSAIE
			try{
				
				//De déconnecter le visiteur
				ModeleAppliRV.getModele().deconnecter(identifiant);
			
			}
			//ON RECUPERE
			catch(Exception e){
				
				//Une exception et on affiche son message
				JOptionPane.showMessageDialog(null, "Accès à la BD impossible","Déconnexion",JOptionPane.ERROR_MESSAGE);
			
			}
			
			//On ferme la session
			Session.fermer();
			
			//On met la barre de menu en mode déconnectée
			//Et on affiche la vue d'accueil
			//Ainsi qu'une fenêtre de dialogue informant du succès de la déconnexion
			this.vue.setBarreMenusModeDeconnecte();
			this.vue.changerVue("Accueil");
			JOptionPane.showMessageDialog(null, "Vous êtes maintenant déconnecté","Déconnexion", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
		
	/**
	 * @throws Exception
	 * Méthode qui ouvre une fenêtre de changement de mot de passe
	 */
	private void changerMdp() throws Exception{
		
		System.out.println("ControleurAppli::changerMdp()");
			
		//Affiche la vue de changement de mot de passe
		new VueChangerMotDePasse(this.vue);

	}
	
	/**
	 * Méthode qui ferme l'application
	 */
	private void quitter(){
		
		System.out.println("ControleurAppli::quitter()");
		
		//Demande de confirmation
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment quitter?","Quitter",JOptionPane.YES_NO_OPTION);
		
		//SI l'utilisateur confirme:
		if( reponse == JOptionPane.YES_OPTION){
			
			//SI la session est différente de null
			if(Session.getSession() != null){
				
				//On recupère le login dans la variable identifiant
				String identifiant = Session.getSession().getLeVisiteur().getLogin();
				
				//ON ESSAIE
				try{
					
					//De déconnecter l'usager
					ModeleAppliRV.getModele().deconnecter(identifiant);
					
				}
				//ON RECUPERE
				catch(Exception e){
					
					//Une exception et on affiche son message
					JOptionPane.showMessageDialog(null, "Accès à la BD impossible","Quitter",JOptionPane.ERROR_MESSAGE);
					
				}
				
				//On ferme la session
				Session.fermer();
			}
			
			//On ferme l'application
			System.exit(0);

		}
	}
	
	/**
	 * Méthode qui permet d'afficher le formulaire
	 * pour consuler les praticiens hésitants
	 */
	private void consulterPraticien(){
		
		System.out.println("ControleurAppli::consulterPraticien()");
		
		//Affiche une boite de dialogue pour choisir les critères de tri des praticiens 
		new VuePraticiens(this.vue);
		//La vue du CardLayout est la vue accueil
		this.vue.changerVue("Accueil");
		
	}
	
	/**
	 * Méthode qui permet d'afficher à propos
	 */
	private void afficherAPropos(){
		
		System.out.println("ControleurAppli::afficherAPropos()");
		
		//On affiche une boite de dialogue qui contient les informations sur l'application
		JOptionPane.showMessageDialog(this.vue, "AppliRV\n2016-2017\nDéveloppée par Romain Venel & Maxime Genevier",
				"A propos",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
