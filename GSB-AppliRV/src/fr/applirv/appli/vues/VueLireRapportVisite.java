/**
 * 
 */
package fr.applirv.appli.vues;

import javax.swing.JDialog;
import javax.swing.JTextArea;

import fr.applirv.appli.entites.RapportVisite;
import fr.applirv.appli.modeles.ModeleAppliRV;
import fr.applirv.appli.techniques.ConnexionException;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueLireRapportVisite étend JDialog
 * Elle est appelée lorsque l'utilisateur souhaite
 * lire un rapport de visite
 *
 */
public class VueLireRapportVisite extends JDialog{

	

				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	private int 			ligne;
	private String 			matricule;
	private int 			annee;
	private int 			mois;
	private RapportVisite 	rapport = new RapportVisite();
	
	/**
	 * @param ligne ligne du tableau sélectionnée
	 * @param matricule matricule du visiteur sélectionné
	 * @param annee année sélectionnée
	 * @param mois mois sélectionné
	 * 
	 * Constructeur de la classe
	 * 
	 */
	public VueLireRapportVisite(int ligne, String matricule, int annee, int mois){
		
		super();
		this.ligne = ligne;
		this.matricule = matricule;
		this.annee = annee;
		this.mois = mois;
		
		/*
		 * On donne un titre à la vue, une position
		 * une taille et on la rend visible
		 */
		this.setTitle("Rapport de visite");
		this.creerInterface();
		this.setLocationRelativeTo(null);
		this.setSize(500, 250);
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Méthode qui créée l'interface de la vue
	 */
	private void creerInterface(){
		
		//ON ESSAIE 
		try{
			
			/*
			 * De récuperer la liste des rapports de visite grâce à la méthode
			 * getLesRapportsDeVisite du modele ModeleAppliRV
			 */
			rapport = ModeleAppliRV.getModele().getLesRapportsDeVisite(matricule, mois, annee).get(ligne);
			
		}
		//ON RECUPERE
		catch(Exception e){
			
			//Une exception et on affiche son message
			e.getMessage();
			
		}
		
		//On créé une zone de texte
		JTextArea texte = new JTextArea(rapport.toString());
		
		//ON ESSAIE
		try {
			
			/*
			 * De changer l'état du rapport en Lu à l'aide
			 * de la méthode lireRapport du modele ModeleAppliRV
			 */
			ModeleAppliRV.getModele().lireRapport(rapport.getNumeroRapport());
			
		} 
		//ON RECUPERE
		catch (ConnexionException e) {
			
			//Une exception et on affiche son message
			e.printStackTrace();
			
		}
		
		//On rend la zone de texte inéditable
		texte.setEditable(false);
		//On ajoute la zone de texte à la vue
		this.add(texte);
			
	}

	

				/********** Getters et Setters de la classe **********/
	
	
	
	/**
	 * @return the ligne
	 */
	public int getLigne() {
		return ligne;
	}



	/**
	 * @param ligne the ligne to set
	 */
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}



	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}



	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}



	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}



	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}



	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}



	/**
	 * @return the rapport
	 */
	public RapportVisite getRapport() {
		return rapport;
	}



	/**
	 * @param rapport the rapport to set
	 */
	public void setRapport(RapportVisite rapport) {
		this.rapport = rapport;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
