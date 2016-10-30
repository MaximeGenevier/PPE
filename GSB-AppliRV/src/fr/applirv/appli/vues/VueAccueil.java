/**
 * 
 */
package fr.applirv.appli.vues;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueAccueil est la vue
 * affichée à l'ouverture de l'application
 *
 */
public class VueAccueil extends JPanel{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe
	 */
	public VueAccueil(){
		
		super();
		this.add(new JLabel("Accueil"));
		
	}

}
