/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.applirv.appli.modeles.ModeleAppliRV;
import fr.applirv.appli.techniques.Md5;
import fr.applirv.appli.techniques.Session;
import fr.applirv.appli.vues.VueChangerMotDePasse;


/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ControleurChangerMotDePasse implémente l'interface
 * ActionListener, elle change le mot de passe de l'utilisateur
 * lorsque celui-ci valide la procédure. Elle avorte cette dernière
 * si l'utilisateur l'annule.
 *
 */
public class ControleurChangerMotDePasse implements ActionListener {

				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	private VueChangerMotDePasse vue;
	
	/**
	 * @param vue vue du controleur
	 */
	public ControleurChangerMotDePasse(VueChangerMotDePasse vue){
		
		super();
		this.vue = vue;
		this.enregistrerEcouteurs();
		
	}
	
				/********** Enregistrement et traitement des actions de l'utilisateur **********/
	
	/**
	 * Méthode qui met à l'écoute les composants de la vue
	 */
	private void enregistrerEcouteurs() {
		
		this.vue.getbValider().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
		
	}


	/**
	 * Méthode qui effectue une action en fonction du composant avec lequel interagit
	 * l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		
		//On récupère la source de l'action
		Object source = e.getSource();
		
		//SI la source de l'événement est le bouton valider
		if(source == this.vue.getbValider()){
			
			//ON ESSAIE 
			try {
				
				//De changer de mot de passe
				this.changerMotDePasse();
				
			} 
			//ON RECUPERE
			catch (Exception e1) {
				
				//Une exception et on affiche son message
				e1.printStackTrace();
				
			}
			
		}
		//SINON SI la source de l'événement est le bouton annuler
		else if(source == this.vue.getbAnnuler()){
			
			//On ferme la fenêtre
			this.vue.dispose();
			
		}
		
	}


	
				/********** Implémentation des méthodes qui traitent les actions de l'utilisateur **********/
	
	
	
	/**
	 * @throws Exception
	 * Méthode qui change le mot de passe de l'utilisateur
	 */
	private void changerMotDePasse() throws Exception {
		
		System.out.println("ControleurChangerMotDePasse::changerMotDePasse()");
		
		//On récupère l'identifiant du visiteur connecté
		String identifiant = Session.getSession().getLeVisiteur().getLogin();
		
		//On récupère les champs saisies
		String ancienMdp = this.vue.getTfAncienMdp().getText();
		Md5 ancienMdpHache = new Md5(ancienMdp);
		String nouveauMdp1 = this.vue.getPfNouveauMdp1().getText();
		String nouveauMdp2 = this.vue.getPfNouveauMdp2().getText();
		
		/*
		 * SI l'ancien mot de passe enregistré est le même que le mot de passe saisie dans le champs
		 * ancien mot de passe
		 */
		if(ancienMdpHache.codeGet().equals(ModeleAppliRV.getModele().recupMdp(identifiant))){
			
			/*
			 * SI le nouveau mot de passe saisie par l'utilisateur
			 * est égal au mot de passe resaisie
			 */
			if(nouveauMdp1.equals(nouveauMdp2)){
				
				//On hache le nouveau mot de passe
				Md5 mdpHache = new Md5(nouveauMdp1);
				//On l'enregistre dans la base de données
				ModeleAppliRV.getModele().changerMotDePasse(identifiant, mdpHache.codeGet());
				//On informe l'utilisateur du succès de l'opération
				JOptionPane.showMessageDialog(this.vue, "Changement réussi", "Changement de mot de passe", JOptionPane.INFORMATION_MESSAGE);
				
			}
			//SINON
			else{
				
				//On informe l'utilisateur d'une erreur de saisie pour le nouveau mot de passe
				JOptionPane.showMessageDialog(this.vue, "Erreur nouveau mot de passe", "Changement de mot de passe", JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		//SINON
		else{
			
			//On informe l'utilisateur d'une erreur de saisie de l'ancien mot de passe
			JOptionPane.showMessageDialog(this.vue, "Erreur ancien mot de passe", "Changement de mot de passe", JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

}
