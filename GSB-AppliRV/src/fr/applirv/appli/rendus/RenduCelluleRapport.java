/**
 * 
 */
package fr.applirv.appli.rendus;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fr.applirv.appli.modeles.ModeleAppliRV;

/**
 * @author Romain Venel et Maxime Genevier
 * 
 * La classe RenduCelluleRapport étend DefaultTableCellRenderer
 * Elle définit le rendu des rapports lus et ceux non lus
 * du tableau de rapport
 *
 */
public class RenduCelluleRapport extends DefaultTableCellRenderer{

	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	private String 	matricule;
	private int 	annee,mois;
	
	/**
	 * @param matricule matricule du visiteur sélectionné
	 * @param annee année sélectionnée
	 * @param mois mois sélectionné
	 * 
	 * Constructeur de la classe
	 * 
	 * Pour savoir si un rapport est lu ou non on a besoin de récuperer les rapports de visite
	 */
	public RenduCelluleRapport(String matricule, int annee, int mois) {
		
		super();
		this.matricule = matricule;
		this.mois = mois;
		this.annee = annee;
		
	}

	
	
				/********** Implémentation de la méthode qui définit le rendu **********/
	
	
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {		
		
		//On créé un nouveau rendeu
		RenduCelluleRapport rendu = (RenduCelluleRapport) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);
		
		//ON ESSAIE 
		try {
			
			//SI le rapport est lu
			if(ModeleAppliRV.getModele().getLesRapportsDeVisite(matricule, mois, annee).get(row).isLecture() == true){
				
				//On lui affecte une couleur de fond
				rendu.setBackground(new Color(0, 127, 255, 75));
				
			}
			//SINON
			else{
				
				//On lui affecte une autre couleur de fond
				rendu.setBackground(new Color(255,255,255, 75));
				
			}
			
		} 
		//ON RECUPERE
		catch (Exception e) {
			
			//Une exception et on affiche son message
			e.printStackTrace();
			
		}
		
		//On retourne le rendu
		return rendu;
		
	}


	
	

}
