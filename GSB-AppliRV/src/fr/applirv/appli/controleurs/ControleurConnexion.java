/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.applirv.appli.entites.Visiteur;
import fr.applirv.appli.modeles.ModeleAppliRV;
import fr.applirv.appli.techniques.Md5;
import fr.applirv.appli.techniques.Session;
import fr.applirv.appli.vues.VueConnexion;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ControleurConnexion implémente l'interface
 * ActionListener, elle traite les actions de l'utilisateur
 * au niveau de la boite de dialogue de connexion
 *
 */
public class ControleurConnexion implements ActionListener{

	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private VueConnexion vue;
	
	/**
	 * @param vue Vue du controleur
	 */
	public ControleurConnexion(VueConnexion vue){
		
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	
	}
	
	
	
				/********** Enregistrement et traitement des actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui met à l'écoute les différents composants de la vue
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbConnecter().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
		
	}
	
	/**
	 * Méthode qui appelle une méthode en fonction 
	 * du composant avec lequel interagit l'utilisateur
	 */
	public void actionPerformed(ActionEvent e){
		
		//On récupère la source de l'action
		Object source = e.getSource();
		
		//SI la source de l'événement est le bouton connecter
		if(source == this.vue.getbConnecter()){
			
			//On appelle la méthode connecter du controleur
			this.seConnecter();
		
		}
		//SINON SI la source de l'événement est le bouton annuler
		else if(source == this.vue.getbAnnuler()){
			
			//On ferme la fenêtre
			this.vue.dispose();
		
		}
		
	}
	
	
	
				/********** Implémentation des méthodes qui traitent les actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui connecte l'utilisateur
	 */
	private void seConnecter(){
		
		System.out.println("ControleurConnexion::seConnecter()");
		
		//On récupère les champs saisies
		String identifiant = this.vue.getTfIdentifiant().getText();
		String mdp = new String(this.vue.getPfMdp().getPassword());
		
		//On hache le mdp
		Md5 newMdp = new Md5(mdp);
		
		//ON ESSAIE
		try {
			
			//On demande à la base de données si le visiteur est déjà connecté
			boolean estDejaConnecte = ModeleAppliRV.getModele().estConnecte(identifiant);
			
			//SI il n'est pas connecté
			if( estDejaConnecte == false){
				
				//Alors on tente de le connecter
				boolean connexionOk = ModeleAppliRV.getModele().seConnecter(identifiant, newMdp.codeGet());
				
				//SI la connection est réussie
				if( connexionOk == true){
					
					//On instancie un visiteur et on lui affecte le login
					Visiteur visiteur = new Visiteur();
					visiteur.setLogin(identifiant);
					
					//Puis on ouvre une session avec le visiteur créé
					Session.ouvrir(visiteur);
					ModeleAppliRV.getModele().connecter(visiteur.getLogin());
					
					//On met la barre de menu en mode connectée
					this.vue.getVueParente().setBarreMenusModeConnecte();
					
					//On informe l'utilisateur du succès de la connexion
					JOptionPane.showMessageDialog(this.vue, "Connexion réussie", "Connexion", JOptionPane.INFORMATION_MESSAGE);
					
					//On ferme la fenêtre de dialogue
					this.vue.dispose();
					
				}
				//SINON
				else{
					
					/*
					 * Le visiteur s'est trompé dans sa saisie, on initialise pfMdp à null
					 * On l'informe de l'échec de la connexion
					 */
					JOptionPane.showMessageDialog(null, "Echec de la connexion","Connexion",JOptionPane.ERROR_MESSAGE);
					this.vue.getPfMdp().setText(null);
					
				}
				
			}
			//SINON
			else{
				/*
				 * Le visiteur est déjà connecté, on initialise les champs à null
				 * On l'informe de l'échec de la connexion
				 */
				JOptionPane.showMessageDialog(null, "Le visiteur est déjà connecté","Connexion",JOptionPane.ERROR_MESSAGE);
				this.vue.getPfMdp().setText(null);
				this.vue.getTfIdentifiant().setText(null);
				
			}
			
		}
		//ON RECUPERE
		catch(Exception e){
			
			//Une exception et on affiche son message
			JOptionPane.showMessageDialog(null, "Accès à la BD impossible\n"+e.getMessage(),"Connexion",JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
}
