/**
 * 
 */
package fr.applirv.appli.techniques;

import fr.applirv.appli.entites.Visiteur;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe Session permet d'ouvrir une session 
 * lors de la connexion d'un utilisateur
 *
 */
public class Session {
	
	
	
				/********** Déclaration des attributs et implémentation de la méthode qui définit le rendu **********/
	
	
	
	private static Session session = null;
	private Visiteur leVisiteur;
	
	/**
	 * @param leVisiteur
	 * Constructeur de la classe
	 */
	public Session(Visiteur leVisiteur) {
		
		super();
		this.leVisiteur = leVisiteur;
		
	}
	
	
	
				/********** Méthode de la classe **********/
	
	
	
	/**
	 * @param leVisiteur
	 * 
	 * Méthode qui permet d'ouvrir une session
	 */
	public static void ouvrir(Visiteur leVisiteur){
		
		Session.session = new Session(leVisiteur);
		
	}
	
	/**
	 * Méthode qui permet de fermer une session
	 */
	public static void fermer(){
		
		Session.session = null;
		
	}
	
	
	
				/********** Getters et toString de la classe **********/
	
	
	
	/**
	 * @return session
	 * 
	 * Méthode qui retourne la session en cours
	 */
	public static Session getSession(){
		
		return Session.session;
		
	}
	
	/**
	 * @return leVisiteur le visiteur connecté
	 * 
	 * Méthode qui permet de récupérer le visiteur connecté
	 */
	public Visiteur getLeVisiteur(){
		
		return this.leVisiteur;
		
	}

	/**
	 * Méthode qui décrit l'instance de la classe
	 */
	public String toString() {
		
		return "Session [leVisiteur=" + leVisiteur + "]";
		
	}

}
