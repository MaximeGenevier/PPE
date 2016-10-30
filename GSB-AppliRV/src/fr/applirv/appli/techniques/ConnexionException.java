/**
 * 
 */
package fr.applirv.appli.techniques;

/**
 * @author Romaine Venel & Maxime Genevier
 * 
 * La classe ConnexionException étend Exception
 * 
 * Elle affiche un message d'erreur en cas de probleme 
 * de connexion à la base de données
 *
 */
public class ConnexionException extends Exception{
	
	
	
				/********** Déclaration des attributs **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Affiche un message d'erreur de connexion à la base de données 
	 */
	public String getMessage(){
		
		return "Erreur de connexion BD";
		
	}

}
