/**
 * 
 */
package fr.applirv.appli.modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import fr.applirv.appli.entites.Praticien;
import fr.applirv.appli.entites.RapportVisite;
import fr.applirv.appli.entites.Visiteur;
import fr.applirv.appli.techniques.ConnexionBD;
import fr.applirv.appli.techniques.ConnexionException;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ModeleAppliRV implémente toutes les méthodes
 * de récupération de tuples de la bases de données
 *
 */
public class ModeleAppliRV {
	
	

				/********** Déclaration des attributs et implémentation du Design Pattern Singleton **********/

	
	
	private static ModeleAppliRV modele = null;
	
	private PreparedStatement 	requetePreparee = null;
	private ResultSet 			resultat 		= null;
	
	
	/**
	 * Constructeur du modele
	 */
	private ModeleAppliRV(){
		
		super();
		
	}
	
	
	/**
	 * @return modele le modèle de la base données
	 */
	public static ModeleAppliRV getModele(){
		if (modele == null){
			modele = new ModeleAppliRV();
		}
		
		return modele;
	}
	
	
	
				/********** Implémentation des méthodes de récupération des données **********/
	
	
	
	/**
	 * @param identifiant identifiant de l'utilisateur
	 * @param mdp mot de passe de l'utiliseur
	 * @return connexionOk boolean qui permet de savoir si la connexion de l'utilisateur est réussie
	 * @throws ConnexionException 
	 * @throws Exception en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui permet de connecter un utilisateur
	 * 
	 */
	public boolean seConnecter(String identifiant, String mdp) throws Exception{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On prépare la requête
		String requete = "SELECT VISITEUR.*"
			+ " FROM VISITEUR INNER JOIN TRAVAILLER ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE"
			+ " WHERE VIS_LOGIN = ?"
			+ " AND VIS_MDP = ?"
			+ " AND TRAVAILLER.JJMMAA = (Select max(JJMMAA) from TRAVAILLER T2 where T2.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE AND TRAVAILLER.TRA_ROLE = 'Délégué')";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		requetePreparee.setString(1, identifiant);
		requetePreparee.setString(2, mdp);
		
		//On exécute la requête
		resultat = requetePreparee.executeQuery();
		
		boolean connexionOk;
		
		//SI il y a un resultat
		if(resultat.next()){
			
			//On connecte l'utilisateur
			connexionOk = this.connecter(identifiant);
			
		}
		//SINON
		else{
			
			//a connexion vaut faux
			connexionOk = false;
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		
		requetePreparee.close();
		resultat.close();
		
		//On retourne connexionOk
		return connexionOk;
			
	}
	
	/**
	 * @param identifiant identifiant du visiteur
	 * @return etatConnecte boolean affiche l'état du champs connecte de la table VISITEUR
	 * @throws Exception en cas d'échec à la connexion à la base de données
	 * 
	 * Méthode qui permet de vérifier si un utilisateur est connecté
	 */
	public boolean estConnecte(String identifiant) throws Exception{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On prépare la requête
		String requete = "select VIS_CONNECTE"
				+ " from VISITEUR"
				+ " where VIS_LOGIN = ?";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		requetePreparee.setString(1, identifiant);
		
		//On exécute la requête
		resultat = requetePreparee.executeQuery();
		
		boolean etatConnecte;
		
		//SI il y a un resultat
		if(resultat.next()){
			
			//On recupère la valeur du champs
			etatConnecte = resultat.getBoolean("VIS_CONNECTE");
			
		}
		//SINON
		else{
			
			//etatConnecte vaut faux
			etatConnecte = false;	
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne etatConnecte
		return etatConnecte;
		
	}
	
	/**
	 * @param identifiant identifiant de l'utilisateur
	 * @return connexionOk boolean indique l'état de la connexion
	 * @throws Exception en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui modifie la valeur du champs connecte de la table VISITEUR à true
	 */
	public boolean connecter(String identifiant) throws Exception{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On prépare la requête
		String requete = "update VISITEUR"
				+ " set VIS_CONNECTE = true"
				+ " where VIS_LOGIN = ?";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		requetePreparee.setString(1, identifiant);
		
		//On exécute la requête
		int nb = requetePreparee.executeUpdate();
		
		boolean connexionOk;
		
		//SI nombre vaut 1
		if( nb == 1){
			
			//connexionOk vaut vrai
			connexionOk = true;
			
		}
		//SINON
		else{
			
			//connexionOk vaut faux
			connexionOk = false;
			
		}
		
		//On ferme requetePreparee, connexion
		requetePreparee.close();

		
		//On retourne connexionOk
		return connexionOk;
				
	}
	
	/**
	 * @param identifiant identifiant de l'utilisateur
	 * @return mdp le mot de passe de l'utilisateur
	 * @throws Exception en cas d'échec d'acccès à la base de données
	 * 
	 * Méthode qui permet de récupérer le mot de passe de l'utilisateur
	 * 
	 */
	public String recupMdp(String identifiant) throws Exception{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On prépare la requete
		String mdp = null;
		String requete = "Select VIS_MDP"
				+ " From VISITEUR"
				+ " Where VIS_LOGIN = ?";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		requetePreparee.setString(1, identifiant);
		resultat = requetePreparee.executeQuery();
		System.out.println(resultat);
		
		//TANT QUE il y a une ligne suivante au résultat
		while (resultat.next()){
			
			//La variable mdp prend la valeur du champs VIS_MDP
			mdp = resultat.getString("VIS_MDP");
				
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne mdp
		return mdp;
						
	}
	
	/**
	 * @param identifiant identifiant de l'utilisateur
	 * @param mdp nouveau mot de passe
	 * @return boolean reussi vaut true si le changement de mot de passe est effectué
	 * @throws Exception en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui permet de changer le mot de passe
	 * 
	 */
	public boolean changerMotDePasse(String identifiant, String mdp) throws Exception{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
				
		//On prépare la requête
		String requete = "update VISITEUR"
				+ " set VIS_MDP = ?"
				+ " where VIS_LOGIN = ?";
				
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		requetePreparee.setString(1, mdp);
		requetePreparee.setString(2, identifiant);
		
		//Exécution de la requête
		int nb = requetePreparee.executeUpdate();
				
		boolean reussi;
		//SI nb vaut 1
		if(nb == 1){
			
			//Alors connexionOk vaut vrai
			reussi = true;
			
		} 
		//SINON
		else{
			
			//Il vaut faux
			reussi = false;
			
		}
				
		//On ferme requetePreparee, connexion
		requetePreparee.close();
		
		//On retourne reussi
		return reussi;
		
	}
	
	/**
	 * @param identifiant identifiant de l'utilisateur
	 * @return connexionOk boolean indique l'état de la connexion
	 * @throws Exception en cas d'échec à la base de données
	 * 
	 * Méthode qui déconnecte l'utilisateur et met la valeur de connecte à false
	 * 
	 */
	public boolean deconnecter(String identifiant) throws Exception{
		
		//Connexion à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//Prépation de la requête
		String requete = "update VISITEUR"
				+ " set VIS_CONNECTE = false"
				+ " where VIS_LOGIN = ?" ;
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		requetePreparee.setString(1, identifiant);
		
		//Exécution de la requête
		int nb = requetePreparee.executeUpdate();
		
		boolean connexionOk;
		
		//SI nb vaut 1
		if(nb == 1){
			
			//Alors connexionOk vaut vrai
			connexionOk = true;
			
		} 
		//SINON
		else{
			
			//connexionOk vaut faux
			connexionOk = false;
			
		}
		
		//On ferme requetePreparee, connexion
		requetePreparee.close();
		
		//On retourne connexionOk
		return connexionOk;
		
	}
	
	/**
	 * @return lesVisiteurs ArrayList<Visiteur> la liste des visiteurs
	 * @throws Exception en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui retourne la liste des visiteurs qui dépendent de l'utilisateur
	 * connecté
	 * 
	 */
	public ArrayList<Visiteur> getLesVisiteurs(String login) throws Exception{
		
		//Connexion à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On prépare la requête
		String requete = "SELECT VISITEUR.*"
				+ " FROM VISITEUR INNER JOIN TRAVAILLER"
				+ " ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE"
				+ " WHERE TRAVAILLER.JJMMAA = "
				+ "(Select max(JJMMAA)"
				+ " from TRAVAILLER T2"
				+ " where T2.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE AND TRAVAILLER.TRA_ROLE = 'Visiteur')"
				+ " AND REG_CODE = "
				+ "(SELECT DISTINCT REG_CODE"
				+ " FROM TRAVAILLER INNER JOIN VISITEUR"
				+ " ON TRAVAILLER.VIS_MATRICULE = VISITEUR.VIS_MATRICULE"
				+ " WHERE VISITEUR.VIS_MATRICULE ="
				+ " (SELECT VIS_MATRICULE FROM VISITEUR WHERE VIS_LOGIN = ?))";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		requetePreparee.setString(1, login);
		
		//Exécution de la requête
		resultat = requetePreparee.executeQuery();
		
		//On initialise une liste de visiteur
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		
		//TANT QUE il y a un résultat
		while(resultat.next()){
			
			//Instanciation d'un visiteur auquel on affecte les différents champs
			Visiteur unVisiteur = new Visiteur();
			
			unVisiteur.setMatricule(resultat.getString("VIS_MATRICULE"));
			unVisiteur.setPrenom(resultat.getString("VIS_PRENOM"));
			unVisiteur.setNom(resultat.getString("VIS_NOM"));
			unVisiteur.setAdresse(resultat.getString("VIS_ADRESSE"));
			unVisiteur.setCodePostal(resultat.getString("VIS_CP"));
			unVisiteur.setVille(resultat.getString("VIS_VILLE"));
			unVisiteur.setDateEmbauche(resultat.getDate("VIS_DATEEMBAUCHE"));
			unVisiteur.setCodeSecteur(resultat.getString("SEC_CODE"));
			unVisiteur.setCodeLabo(resultat.getString("LAB_CODE"));
			
			//Ajout du visiteur à la liste
			lesVisiteurs.add(unVisiteur);
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();	
		
		//On retourne lesVisiteurs
		return lesVisiteurs;
		
	}
	
	/**
	 * @return ArrayList<Praticien> la liste des praticiens
	 * @throws Exception en cas d'échec de la connexion à la base de données
	 * 
	 * Méthode qui permet de récupérer la liste des praticiens par notoriété
	 * 
	 */
	public ArrayList<Praticien> getLesPraticiensParNotoriete() throws Exception {
		
		//Connexion à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//Préparation de la requête
		String requete = "Select distinct(PRATICIEN.PRA_NOM), PRATICIEN.PRA_VILLE"
				+ " From PRATICIEN inner join RAPPORT_VISITE"
				+ " Where RAPPORT_VISITE.COE_ID = 1"
				+ " Order by PRA_COEFNOTORIETE DESC";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		//Exécution de la requête
		resultat = requetePreparee.executeQuery();
		
		//Création de la liste des praticiens
		ArrayList<Praticien> lesPraticiens = new ArrayList<Praticien>();
		
		//TANT QUE il y a un résulat 
		while(resultat.next()){
			
			//Instanciation d'un praticien et affectation des différents champs
			Praticien unPraticien = new Praticien();
			unPraticien.setNom(resultat.getString("PRA_NOM"));
			unPraticien.setVille(resultat.getString("PRA_VILLE"));
			
			//Ajout du praticien à la liste lesPraticiens
			lesPraticiens.add(unPraticien);
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne lesPraticiens
		return lesPraticiens;
		
	}
	
	/**
	 * @return lesPraticiens ArrayList<Praticien> la liste des praticiens
	 * @throws Exception en cas d'échec de connexion à la base de données
	 * 
	 * Méthode qui permet de récupérer les praticiens en fonction de la date de leur dernière visite (décroissant)
	 * 
	 */
	public ArrayList<Praticien> getLesPraticiensParDate() throws Exception{
		
		//Connexion à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//Préparation de la requête
		String requete = "Select PRATICIEN.PRA_NOM, PRATICIEN.PRA_VILLE"
				+ " From PRATICIEN INNER JOIN RAPPORT_VISITE"
				+ " On PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM"
				+ " Where RAPPORT_VISITE.COE_ID = 1"
				+ " Order by DATEDIFF(CURRENT_DATE,RAPPORT_VISITE.RAP_DATE) DESC";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		//Execution de la requete
		resultat = requetePreparee.executeQuery();
		
		//Création de la liste des praticiens
		ArrayList<Praticien> lesPraticiens = new ArrayList<Praticien>();
		
		//TANT QUE il y a un résultat
		while(resultat.next()){
			
			//Instanciation d'un praticien et affectation des différents champs
			Praticien unPraticien = new Praticien();
			unPraticien.setNom(resultat.getString("PRA_NOM"));
			unPraticien.setVille(resultat.getString("PRA_VILLE"));
			
			//Ajout du praticien à la liste lesPraticiens
			lesPraticiens.add(unPraticien);
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne lesPraticiens
		return lesPraticiens;
		
	}
	
	/**
	 * @return lesPraticiens ArrayList<Praticien> la liste des praticiens
	 * @throws Exception en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui permet de récuperer les praticiens par coefficient de confiance
	 * 
	 */
	public ArrayList<Praticien> getLesPraticiensParConfiance() throws Exception{
		
		//Connexion à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//Préparation de la requete
		String requete = "Select PRATICIEN.PRA_NOM, PRATICIEN.PRA_VILLE"
				+ " From PRATICIEN INNER JOIN RAPPORT_VISITE"
				+ " On PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM"
				+ " Where RAPPORT_VISITE.COE_ID = 1";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		
		//Exécution de la requete
		resultat = requetePreparee.executeQuery();
		
		//Création de la liste des praticiens
		ArrayList<Praticien> lesPraticiens = new ArrayList<Praticien>();
		
		//TANT QUE il y a un résultat
		while(resultat.next()){
			
			//Instanciation d'un praticien et affectation des différents champs
			Praticien unPraticien = new Praticien();
			unPraticien.setNom(resultat.getString("PRA_NOM"));
			unPraticien.setVille(resultat.getString("PRA_VILLE"));
			
			//Ajout du praticien à la liste des praticiens
			lesPraticiens.add(unPraticien);
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne lesPraticiens
		return lesPraticiens;
		
	}
	
	/**
	 * @param matricule matricule du visiteur
	 * @param mois mois du rapport visite
	 * @param annee annee du rapport de visite
	 * @return lesRapports ArrayList<RapportVisite> la liste des rapports 
	 * @throws Exception en cas d'échec de connexion à la base de données
	 */
	public ArrayList<RapportVisite> getLesRapportsDeVisite(String matricule, int mois, int annee) throws Exception{
		
		//Connexion à la base de données 
		Connection connexion = ConnexionBD.getConnexion();
		
		//Préparation de la requête
		String requete = "SELECT PRATICIEN.PRA_NOM, PRATICIEN.PRA_VILLE,RAPPORT_VISITE.*, MOTIF.MOT_LIBELLE, COEFFICIENT_CONFIANCE.COE_LIBELLE"
				+ " FROM PRATICIEN INNER JOIN RAPPORT_VISITE ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM"
				+ " INNER JOIN MOTIF ON RAPPORT_VISITE.MOT_ID = MOTIF.MOT_ID"
				+ " INNER JOIN COEFFICIENT_CONFIANCE ON RAPPORT_VISITE.COE_ID = COEFFICIENT_CONFIANCE.COE_ID"
				+ " WHERE RAPPORT_VISITE.VIS_MATRICULE = ?"
				+ " AND YEAR(RAP_DATE) = ?"
				+ " AND MONTH(RAP_DATE) = ?"
				+ " ORDER BY RAP_DATE DESC";
		
		requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
		requetePreparee.setString(1, matricule);
		requetePreparee.setInt(2, annee);
		requetePreparee.setInt(3, mois);
		
		//Exécution de la requête
		resultat = requetePreparee.executeQuery();
		
		//Création de la liste des rapports de visite
		ArrayList<RapportVisite> lesRapports = new ArrayList<RapportVisite>();
		
		//TANT QUE il y a un résultat
		while(resultat.next()){
			
			//Instanciation d'un visiteur et des différents champs
			Visiteur leVisiteur = new Visiteur();
			Praticien lePraticien = new Praticien();
			
			leVisiteur.setMatricule(resultat.getString("VIS_MATRICULE"));
			lePraticien.setNumero(resultat.getInt("PRA_NUM"));
			lePraticien.setNom(resultat.getString("PRA_NOM"));
			lePraticien.setVille(resultat.getString("PRA_VILLE"));
			
			//Instanciation du rapport de viste et des différents champs
			RapportVisite unRapport = new RapportVisite();
			unRapport.setLeVisiteur(leVisiteur);
			unRapport.setLePraticien(lePraticien);
			unRapport.setNumeroRapport(resultat.getInt("RAP_NUM"));
			unRapport.setMotif(resultat.getString("MOT_LIBELLE"));
			unRapport.setBilan(resultat.getString("RAP_BILAN"));
			unRapport.setDateRapport(resultat.getDate("RAP_DATE"));
			unRapport.setDateVisite(resultat.getDate("RAP_DATE_VISITE"));
			unRapport.setCoeffConfiance(resultat.getString("COE_LIBELLE"));
			unRapport.setLecture(resultat.getBoolean("RAP_LECTURE"));
			
			//Ajout du rapport à la liste des rapports
			lesRapports.add(unRapport);
			
		}
		
		//On ferme resultat, requetePreparee, connexion
		resultat.close();
		requetePreparee.close();
		
		//On retourne lesRapports
		return lesRapports;
		
	}

	/**
	 * @param numRapport
	 * @return reussi boolean vaut true si la lecture du rapport est reussie
	 * @throws ConnexionException
	 */
	public boolean lireRapport(int numRapport) throws ConnexionException{
		
		//On se connecte à la base de données
		Connection connexion = ConnexionBD.getConnexion();
		
		//On définit la requête
		String requete = "update RAPPORT_VISITE set RAP_LECTURE = true where RAP_NUM = ?";
		
		boolean reussi = false;
		
		//ON ESSAIE
		try {
			
			//De preparer la requête
			requetePreparee = (PreparedStatement) connexion.prepareStatement(requete);
			requetePreparee.setInt(1, numRapport);
			
			//De l'éxecuter
			int resultat = requetePreparee.executeUpdate();
			
			//SI resultat vaut 1
			if(resultat == 1){
				
				//reussie vaut true
				reussi = true;
				
			}
			//SINON
			else{
				
				//reussie vaut false
				reussi = false;
				
			}
			
			//On ferme requetePreparee
			requetePreparee.close();
		
		} 
		//ON RECUPERE
		catch (SQLException e) {
			
			//Une exception et on affiche son message
			e.printStackTrace();
			
		}
		
		//On retourne reussi		
		return reussi;
		
	}
	
}
