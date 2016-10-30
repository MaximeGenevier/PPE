/**
 * 
 */
package fr.applirv.appli.techniques;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe ConnexionBD permet de se connecter à la base de données
 *
 */
public class ConnexionBD {
	
	
	
				/********** Déclaration des attributs et implémentation du Design Pattern Singleton **********/
	
	
	
	private static String dbURL 		= "jdbc:mysql://localhost:3306/GsbCRSlamV2015";
	private static String user 			= "admin";
	private static String password 		= "azerty";
	private static Connection connexion = null;
	
	/**
	 * @throws ConnexionException en cas d'échec d'accès à la base de données
	 * 
	 * Méthode d'accès à la base de données
	 */
	private ConnexionBD() throws ConnexionException{
		
		//ON ESSAIE
		try {
			
			//De se conncter à la base de données
			Class.forName("com.mysql.jdbc.Driver");
			connexion = (Connection) DriverManager.getConnection(dbURL, user, password);
		
		}
		//ON RECUPERE
		catch(Exception e){
			
			//Une exception et on affiche son message
			System.out.println("Erreur ! : " + e.getMessage());
			throw new ConnexionException();
			
		}
		
	}
	
	/**
	 * @return connexion avec la connexion à la base de données 
	 * @throws ConnexionException en cas d'échec d'accès à la base de données
	 * 
	 * Méthode qui récupère la connexion à la base de données
	 */
	public static Connection getConnexion() throws ConnexionException{
		
		//SI connexion vaut null
		if (connexion == null){
			
			//On créé une nouvelle connexion
			new ConnexionBD();
			
		}
		
		//On retourne connexion
		return connexion;
		
	}
	
}
