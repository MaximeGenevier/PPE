/**
 * 
 */
package fr.applirv.appli.editeurs;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import fr.applirv.appli.controleurs.ControleurBoutonLireRapport;

/**
 * @author Romain Venel & Maxime Genevier
 *
 */
public class EditeurBoutonLireRapport extends DefaultCellEditor{

	
	
				/********** Déclaration des attibuts et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	protected 	JButton 					bouton = new JButton();
	private 	ControleurBoutonLireRapport controleur; 
	
	
	/**
	 * @param checkBox
	 * @param matricule
	 * @param annee
	 * @param mois
	 */
	public EditeurBoutonLireRapport(JCheckBox checkBox, String matricule, int annee, int mois) {
		
		super(checkBox);
		controleur = new ControleurBoutonLireRapport(matricule, annee, mois);
		this.bouton.setOpaque(true);
		this.bouton.addActionListener(controleur);
		
	}
	
	
	
				/********** Implémentation de la méthode getTableCellEditorComponent **********/

	
	
	/**
	 * Méthode qui met en place un bouton pour la cellule du tableau
	 */
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		//On affecte leur valeur aux attributs
		this.controleur.setColumn(column);
		this.controleur.setRow(row);
		this.controleur.setTable(table);
		
		//SI value vaut null
		if(value == null){
			
			//Le bouton a un texte null
			this.bouton.setText("");
			
		}
		//SINON
		else{
			
			//Il prend la valeur de value
			this.bouton.setText(value.toString());
			
		}
		
		return bouton;
		
	}

}
