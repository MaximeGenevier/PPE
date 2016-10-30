/**
 * 
 */
package fr.applirv.appli.rendus;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe RenduBoutonLireRapport étend JButton
 * et implémente l'interface TableCellRenderer
 * Elle définit le rendu de la cellule qui comporte le bouton lire
 *
 */
public class RenduBoutonLireRapport extends JButton implements TableCellRenderer{

	
	
	/********** Déclaration des attributs **********/
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	/********** Implémentation de la méthode qui définit le rendu **********/
	
	
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		//SI value est différent de null
		if(value != null){
			
			//Le texte du rendu prend la valeur de value
			this.setText(value.toString());
			
		}
		//SINON
		else{
			
			//Le texte vaut null
			this.setText("");
			
		}
		
		//On retourne le rendu
		return this;
	}
	
	

}
