/**
 * 
 */
package fr.applirv.appli.entites;

import java.sql.Date;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe RapportVisite est une classe métier
 * Elle possède tous les attributs propres à un rapport de visite
 *
 */
public class RapportVisite {

	
	
				/********** Déclaration des attributs et implémentation des constructeurs **********/
	
	
	
	private Visiteur 	leVisiteur;
	private int 		numeroRapport;
	private Praticien 	lePraticien;	
	private Date 		dateRapport;
	private String 		bilan;
	private String 		motif;
	private Date 		dateVisite;
	private String 		coeffConfiance;
	private boolean 	lecture;
	
	/**
	 * Constructeur sans paramètre
	 */
	public RapportVisite() {
		
		super();
		
	}

	/**
	 * @param leVisiteur 
	 * @param numeroRapport
	 * @param lePraticien
	 * @param dateRapport
	 * @param bilan
	 * @param motif
	 * @param dateVisite
	 * @param coeffConfiance
	 * @param lecture
	 */
	public RapportVisite(Visiteur leVisiteur, int numeroRapport,
			Praticien lePraticien, Date dateRapport, String bilan,
			String motif, Date dateVisite, String coeffConfiance,
			boolean lecture) {
		
		super();
		this.leVisiteur 	= leVisiteur;
		this.numeroRapport 	= numeroRapport;
		this.lePraticien 	= lePraticien;
		this.dateRapport 	= dateRapport;
		this.bilan 			= bilan;
		this.motif 			= motif;
		this.dateVisite 	= dateVisite;
		this.coeffConfiance = coeffConfiance;
		this.lecture		= lecture;
		
	}

	
	
				/********** Getters, Setters et toString de la classe **********/
	
	

	/**
	 * @return the leVisiteur
	 */
	public Visiteur getLeVisiteur() {
		return leVisiteur;
	}

	/**
	 * @param leVisiteur the leVisiteur to set
	 */
	public void setLeVisiteur(Visiteur leVisiteur) {
		this.leVisiteur = leVisiteur;
	}

	/**
	 * @return the lePraticien
	 */
	public Praticien getLePraticien() {
		return lePraticien;
	}

	/**
	 * @param lePraticien the lePraticien to set
	 */
	public void setLePraticien(Praticien lePraticien) {
		this.lePraticien = lePraticien;
	}

	/**
	 * @return the numeroRapport
	 */
	public int getNumeroRapport() {
		return numeroRapport;
	}

	/**
	 * @param numeroRapport the numeroRapport to set
	 */
	public void setNumeroRapport(int numeroRapport) {
		this.numeroRapport = numeroRapport;
	}
	
	/**
	 * @return the bilan
	 */
	public String getBilan() {
		return bilan;
	}

	/**
	 * @param bilan the bilan to set
	 */
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the lecture
	 */
	public boolean isLecture() {
		return lecture;
	}

	/**
	 * @param lecture the lecture to set
	 */
	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}

	/**
	 * @return the dateRapport
	 */
	public Date getDateRapport() {
		return dateRapport;
	}

	/**
	 * @param dateRapport the dateRapport to set
	 */
	public void setDateRapport(Date dateRapport) {
		this.dateRapport = dateRapport;
	}

	/**
	 * @return the dateVisite
	 */
	public Date getDateVisite() {
		return dateVisite;
	}

	/**
	 * @param dateVisite the dateVisite to set
	 */
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	/**
	 * @return the coeffConfiance
	 */
	public String getCoeffConfiance() {
		return coeffConfiance;
	}

	/**
	 * @param coeffConfiance the coeffConfiance to set
	 */
	public void setCoeffConfiance(String coeffConfiance) {
		this.coeffConfiance = coeffConfiance;
	}

	/**
	 * Méthode qui décrit une instance de la classe
	 */
	public String toString() {
		return "Rapport de visite n°" + numeroRapport + "\n" + "Régidigé par le visiteur : " + leVisiteur.getMatricule()
				 + "\nLe " + dateRapport + "\n\nPraticien : " + lePraticien.getNumero() + " Date de visite : " + dateVisite
				 + "\nMotif : " + motif + " Coéfficient de confiance : " + coeffConfiance
				 + "\n\nBilan : \n" + bilan ;
	}
	
	
	
	
}
