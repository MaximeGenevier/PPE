/**
 * 
 */
package fr.applirv.appli.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import fr.applirv.appli.editeurs.EditeurBoutonLireRapport;
import fr.applirv.appli.modeles.ModeleListeRapports;
import fr.applirv.appli.rendus.RenduBoutonLireRapport;
import fr.applirv.appli.rendus.RenduCelluleRapport;
import fr.applirv.appli.vues.VueRapportsVisite;

/**
 * @author Romain Venel & Maxime Genevier
 *
 */
public class ControleurRapportVisite implements ActionListener{

	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private VueRapportsVisite 	vue;
	private int 				annee;
	private int 				mois; 
	private String 				matricule;
	
	/**
	 * @param vue vue du controleur
	 */
	public ControleurRapportVisite(VueRapportsVisite vue){
		
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
		
	}
	
	
	
				/********** Enregistrement et traitement des actions de l'utilisateur **********/
	
	
	
	/**
	 * Méthode qui met à l'écoute les différents composants de la vue
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbRechercher().addActionListener(this);	
		
	}
	
	/**
	 * Méthode qui appelle une méthode en fonction 
	 * du composant avec lequel interagit l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		
		//On récupère la source de l'action
		Object source = e.getSource();
		
		//SI la source de l'événement est le bouton rechercher		
		if(source == this.vue.getbRechercher()){
			
			//On appelle la méthode rechercher du controleur
			this.rechercher();
			
		}
		
	}
	
				/********** Implémentation des méthodes qui traitent les actions de l'utilisateur **********/
	
	/**
	 * Méthode qui permet de rechercher les rapports selon les critères de l'utilisateur
	 */
	private void rechercher(){
		
		System.out.println("ControleurRapportVisite::rechercher()");
		
		//On Récupère l'indice du visiteur
		int indiceVis = this.vue.getLstVisiteurs().getSelectedIndex();
		
		//SI l'indice vaut -1
		if(indiceVis == -1){
			
			//L'utilisateur n'a rien sélectionné et on lui affiche un message d'avertissement
			JOptionPane.showMessageDialog(this.vue, "Veuillez choisir un visiteur", null, JOptionPane.WARNING_MESSAGE, null);
		
		} 
		//SINON
		else{
			
			//On recupère le matricule, le mois et l'année sélectionnée
			matricule = this.vue.getLesVisiteurs().get(indiceVis).getMatricule();
			mois = (int) this.vue.getJcbMois().getSelectedItem();
			annee = (int) this.vue.getJcbAnnee().getSelectedItem();
			
			//On définit le modèle du JTable et on affecte le rendu du bouton
			this.vue.getTabRapports().setModel(new ModeleListeRapports(matricule,annee,mois));
			this.vue.getTabRapports().getColumn("").setCellRenderer(new RenduBoutonLireRapport());
			this.vue.getTabRapports().setDefaultRenderer(Object.class, new RenduCelluleRapport(matricule, annee, mois));
			this.vue.getTabRapports().getColumn("").setCellEditor(new EditeurBoutonLireRapport(new JCheckBox(),matricule,annee,mois));
			
		}
		
	}

}

