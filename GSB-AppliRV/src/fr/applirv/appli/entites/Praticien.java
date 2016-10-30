/**
 * 
 */
package fr.applirv.appli.entites;

/**
 * @author Romain Venel & Maxime Genevier
 * La classe Praticien est une classe métier
 * Elle possède tous les attributs propres à un praticien
 */
public class Praticien {
	
	
	
				/********** Déclaration des attributs et implémentation des constructeurs **********/
	
	
	
	private int 	numero;
	private String 	nom;
	private String 	prenom;
	private String 	adresse;
	private String 	cp;
	private String 	ville;
	private double 	notoriete;
	private String 	codeType;
	
	/**
	 * Constructeur qui ne reçoit aucun paramètre
	 */
	public Praticien() {
		
		super();
		
	}
	
	/**
	 * @param numero
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param cp
	 * @param ville
	 * @param notoriete
	 * @param codeType
	 */
	public Praticien(int numero, String nom, String prenom, String adresse,
			String cp, String ville, double notoriete, String codeType) {
		
		super();
		this.numero 	= numero;
		this.nom 		= nom;
		this.prenom 	= prenom;
		this.adresse 	= adresse;
		this.cp 		= cp;
		this.ville 		= ville;
		this.notoriete 	= notoriete;
		this.codeType 	= codeType;
		
	}

				/********** Getters, Setters et toString de la classe **********/
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
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
	 * @return the notoriete
	 */
	public double getNotoriete() {
		return notoriete;
	}

	/**
	 * @param notoriete the notoriete to set
	 */
	public void setNotoriete(double notoriete) {
		this.notoriete = notoriete;
	}

	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * Méthode qui décrit une instance de la classe
	 */
	public String toString() {
		return "Praticien [nom=" + nom + " ville="
				+ ville + "]";
	}
	
	
	
	

}
