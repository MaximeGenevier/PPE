/**
 * 
 */
package fr.applirv.appli.entites;

import java.util.Date;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe Visiteur est une classe métier
 * Elle possède tous les attributs propres à un visiteur
 *
 */
public class Visiteur {
				
	
	
				/********** Déclaration des attributs et implémentation des constructeurs **********/
	
	
	
	private String 	matricule;
	private String 	nom;
	private String 	prenom;
	private String 	adresse;
	private String 	codePostal;
	private String 	ville;
	private Date 	dateEmbauche;
	private String 	codeSecteur;
	private String 	codeLabo;
	private String 	login;
	private boolean connecte;
	
	

	/**
	 * Constructeur sans paramètre 
	 */
	public Visiteur() {
		
		super();
		
	}

	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param dateEmbauche
	 * @param codeSecteur
	 * @param codeLabo
	 * @param login
	 * @param connecte
	 */
	public Visiteur(String matricule, String nom, String prenom,
			String adresse, String codePostal, String ville, Date dateEmbauche,
			String codeSecteur, String codeLabo, String login,boolean connecte) {
		
		super();
		this.matricule 		= matricule;
		this.nom 			= nom;
		this.prenom 		= prenom;
		this.adresse 		= adresse;
		this.codePostal 	= codePostal;
		this.ville 			= ville;
		this.dateEmbauche 	= dateEmbauche;
		this.codeSecteur 	= codeSecteur;
		this.codeLabo 		= codeLabo;
		this.login 			= login;
		this.connecte 		= connecte;
		
	}

	
	
				/********** Getters, Setters et toString de la classe **********/
	
	
	
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the dateEmbauche
	 */
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the codeSecteur
	 */
	public String getCodeSecteur() {
		return codeSecteur;
	}

	/**
	 * @param codeSecteur the codeSecteur to set
	 */
	public void setCodeSecteur(String codeSecteur) {
		this.codeSecteur = codeSecteur;
	}

	/**
	 * @return the codeLabo
	 */
	public String getCodeLabo() {
		return codeLabo;
	}

	/**
	 * @param codeLabo the codeLabo to set
	 */
	public void setCodeLabo(String codeLabo) {
		this.codeLabo = codeLabo;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the connecte
	 */
	public boolean isConnecte() {
		return connecte;
	}

	/**
	 * @param connecte the connecte to set
	 */
	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	/**
	 * Méthode qui décrit une instance de la classe
	 */
	public String toString() {
		return "Visiteur " + matricule + " : " + nom
				+ " " + prenom + " " + ville;
				/**+ ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville="+ ville
				+ ", dateEmbauche=" + dateEmbauche + ", codeSecteur="
				+ codeSecteur + ", codeLabo=" + codeLabo + "]"*/
				
	}
	
}
