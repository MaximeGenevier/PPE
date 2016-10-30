/**
 * 
 */
package fr.applirv.appli.vues;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import fr.applirv.appli.controleurs.ControleurRapportVisite;
import fr.applirv.appli.entites.Visiteur;
import fr.applirv.appli.modeles.ModeleAppliRV;
import fr.applirv.appli.techniques.Session;

/**
 * @author Romaine Venel & Maxime Genevier
 * 
 * La classe VueRapportsVisite étend JPanel
 * Elle est appelée lorsque l'utilisateur souhaite
 * consulter un rapport de visite
 * Il doit d'abord choisir un visiteur parmi une liste
 * puis un mois et une année
 * Ensuite un tableau contient les rapports d'après les 
 * critères saisis, il peut alors choisir le rapport 
 * qu'il souhaite consulter
 *
 */
public class VueRapportsVisite extends JPanel{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long serialVersionUID = 1L;
	
	//Vue parente et controleur
	private VueAppli vue;
	private ControleurRapportVisite controleur;
	
	//Définition des champs 
	private JLabel 				lbVisiteurs 	= new JLabel("Liste des visiteurs : ");
	private JList<Visiteur> 	lstVisiteurs;
	private List<Visiteur> 		lesVisiteurs;
	private JLabel 				lbMois 			= new JLabel("Mois : ");
	private JLabel 				lbAnnee 		= new JLabel("Année : ");
	private Integer[] 			mois 			= {1,2,3,4,5,6,7,8,9,10,11,12};
	private Integer[] 			annee 			= {2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017};
	private JComboBox<Integer> 	jcbMois 		= new JComboBox<Integer>(mois);
	private JComboBox<Integer> 	jcbAnnee 		= new JComboBox<Integer>(annee);
	private JButton 			bRechercher 	= new JButton("Rechercher");
	private JScrollPane 		spVisiteurs;
	private JScrollPane 		spRapport;
	private JTable 				tabRapports;
	private JLabel 				lbRapport 		= new JLabel("Les rapports de visite");
	
	
	/**
	 * @param vueParente 
	 * Constructeur de la vue
	 */
	public VueRapportsVisite(VueAppli vueParente){
		
		//Appel au constructeur de la super classe
		super();
		
		//Définition des paramètres de la fenêtre : visible, taille, position et son controleur
		//Création de l'interface de la fenêtre
		this.controleur = new ControleurRapportVisite(this);
		this.setLocation(0, 0);
		this.setSize(600,400);
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Méthode qui permet la création de l'interface
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void creerInterface(){
		
		//ON ESSAIE
		try{
			//Récupération de la liste des lesVisiteurs
			lesVisiteurs = ModeleAppliRV.getModele().getLesVisiteurs(Session.getSession().getLeVisiteur().getLogin());
		}
		//ON RECUPERE
		catch(Exception e){
			
			//Une exception et on affiche son message
			e.printStackTrace();
			
			//En cas d'échec on créé une liste vide
			lesVisiteurs = new ArrayList<Visiteur>();
			
		}
		
		//Paramétrage de la liste des visiteurs et ajout de celle-ci dans le scrollpane
		lstVisiteurs = new JList(lesVisiteurs.toArray());
		spVisiteurs = new JScrollPane(lstVisiteurs);
		lstVisiteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Boite principale
		Box bPrincipale = Box.createVerticalBox();
		
		//Boite du titre
		Box boxTitre = Box.createHorizontalBox();
		boxTitre.add( Box.createHorizontalStrut(10));
		boxTitre.add(Box.createHorizontalGlue());
		boxTitre.add(this.lbVisiteurs);
		boxTitre.add(Box.createHorizontalGlue());
		boxTitre.add(Box.createHorizontalStrut(10));
		
		//Boite des visiteurs
		Box boxVisiteurs = Box.createHorizontalBox();
		boxVisiteurs.add(Box.createHorizontalStrut(10));
		boxVisiteurs.add(this.spVisiteurs);
		boxVisiteurs.add(Box.createHorizontalGlue());
		
		//Boite du champs date
		Box boxDate = Box.createHorizontalBox();
		boxDate.add(Box.createHorizontalStrut(10));
		boxDate.add(this.lbMois);
		boxDate.add(Box.createHorizontalStrut(5));
		boxDate.add(this.jcbMois);
		boxDate.add(Box.createGlue());
		boxDate.add(this.lbAnnee);
		boxDate.add(Box.createHorizontalStrut(5));
		boxDate.add(this.jcbAnnee);
		boxDate.add(Box.createHorizontalStrut(10));
		
		//Boite des boutons
		Box boxBoutons = Box.createHorizontalBox();
		boxBoutons.add(this.bRechercher);
		
		//Boite titre rapports de visite
		Box boxRapportsTitre = Box.createHorizontalBox();
		boxRapportsTitre.add(Box.createHorizontalStrut(25));
		boxRapportsTitre.add(lbRapport);
		
		//Boite rapports de visite
		Box boxRapports = Box.createHorizontalBox();
		boxRapports.add(Box.createHorizontalStrut(15));
		boxRapports.add(Box.createHorizontalStrut(5));
		
		//Création du tableau de liste
		this.tabRapports = new JTable();
		this.tabRapports.setRowHeight(15);
		spRapport = new JScrollPane(this.tabRapports);
		spRapport.setPreferredSize(new Dimension(500,125));
		
		boxRapports.add(spRapport);
		
		//Ajout des boites à la boite principale
		bPrincipale.add(Box.createVerticalStrut(15));
		bPrincipale.add(boxTitre);
		bPrincipale.add(Box.createVerticalStrut(5));
		bPrincipale.add(boxVisiteurs);
		bPrincipale.add(Box.createVerticalStrut(5));
		bPrincipale.add(boxDate);
		bPrincipale.add(Box.createVerticalStrut(5));
		bPrincipale.add(boxBoutons);
		bPrincipale.add(Box.createVerticalStrut(5));
		bPrincipale.add(boxRapportsTitre); 
		bPrincipale.add(boxRapports);
		//Ajout de la boite principale à la vue
		this.add(bPrincipale);
	}
	

	
				/********** Getters et Setters de la classe **********/

	
	
	/**
	 * @return the vue
	 */
	public VueAppli getVue() {
		return vue;
	}

	/**
	 * @return the controleur
	 */
	public ControleurRapportVisite getControleur() {
		return controleur;
	}

	/**
	 * @return the lbVisiteurs
	 */
	public JLabel getLbVisiteurs() {
		return lbVisiteurs;
	}

	/**
	 * @return the lbMois
	 */
	public JLabel getLbMois() {
		return lbMois;
	}

	/**
	 * @return the lbAnnee
	 */
	public JLabel getLbAnnee() {
		return lbAnnee;
	}

	/**
	 * @return the jcbMois
	 */
	public JComboBox<Integer> getJcbMois() {
		return jcbMois;
	}

	/**
	 * @return the jcbAnnee
	 */
	public JComboBox<Integer> getJcbAnnee() {
		return jcbAnnee;
	}

	/**
	 * @return the bRechercher
	 */
	public JButton getbRechercher() {
		return bRechercher;
	}

	/**
	 * @return the lstVisiteurs
	 */
	public JList<Visiteur> getLstVisiteurs() {
		return lstVisiteurs;
	}

	/**
	 * @return the lesVisiteurs
	 */
	public List<Visiteur> getLesVisiteurs() {
		return lesVisiteurs;
	}

	/**
	 * @return the spVisiteurs
	 */
	public JScrollPane getSpVisiteurs() {
		return spVisiteurs;
	}

	/**
	 * @return the tabRapports
	 */
	public JTable getTabRapports() {
		return tabRapports;
	}

	/**
	 * @param tabRapports the tabRapports to set
	 */
	public void setTabRapports(JTable tabRapports) {
		this.tabRapports = tabRapports;
	}

	/**
	 * @return the lbRapport
	 */
	public JLabel getLbRapport() {
		return lbRapport;
	}

	/**
	 * @return the spRapport
	 */
	public JScrollPane getSpRapport() {
		return spRapport;
	}

	/**
	 * @param spRapport the spRapport to set
	 */
	public void setSpRapport(JScrollPane spRapport) {
		this.spRapport = spRapport;
	}



	/**
	 * @return the mois
	 */
	public Integer[] getMois() {
		return mois;
	}



	/**
	 * @param mois the mois to set
	 */
	public void setMois(Integer[] mois) {
		this.mois = mois;
	}



	/**
	 * @return the annee
	 */
	public Integer[] getAnnee() {
		return annee;
	}



	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(Integer[] annee) {
		this.annee = annee;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @param vue the vue to set
	 */
	public void setVue(VueAppli vue) {
		this.vue = vue;
	}



	/**
	 * @param controleur the controleur to set
	 */
	public void setControleur(ControleurRapportVisite controleur) {
		this.controleur = controleur;
	}



	/**
	 * @param lbVisiteurs the lbVisiteurs to set
	 */
	public void setLbVisiteurs(JLabel lbVisiteurs) {
		this.lbVisiteurs = lbVisiteurs;
	}



	/**
	 * @param lstVisiteurs the lstVisiteurs to set
	 */
	public void setLstVisiteurs(JList<Visiteur> lstVisiteurs) {
		this.lstVisiteurs = lstVisiteurs;
	}



	/**
	 * @param lesVisiteurs the lesVisiteurs to set
	 */
	public void setLesVisiteurs(List<Visiteur> lesVisiteurs) {
		this.lesVisiteurs = lesVisiteurs;
	}



	/**
	 * @param lbMois the lbMois to set
	 */
	public void setLbMois(JLabel lbMois) {
		this.lbMois = lbMois;
	}



	/**
	 * @param lbAnnee the lbAnnee to set
	 */
	public void setLbAnnee(JLabel lbAnnee) {
		this.lbAnnee = lbAnnee;
	}



	/**
	 * @param jcbMois the jcbMois to set
	 */
	public void setJcbMois(JComboBox<Integer> jcbMois) {
		this.jcbMois = jcbMois;
	}



	/**
	 * @param jcbAnnee the jcbAnnee to set
	 */
	public void setJcbAnnee(JComboBox<Integer> jcbAnnee) {
		this.jcbAnnee = jcbAnnee;
	}



	/**
	 * @param bRechercher the bRechercher to set
	 */
	public void setbRechercher(JButton bRechercher) {
		this.bRechercher = bRechercher;
	}



	/**
	 * @param spVisiteurs the spVisiteurs to set
	 */
	public void setSpVisiteurs(JScrollPane spVisiteurs) {
		this.spVisiteurs = spVisiteurs;
	}



	/**
	 * @param lbRapport the lbRapport to set
	 */
	public void setLbRapport(JLabel lbRapport) {
		this.lbRapport = lbRapport;
	}
	
	
	
	

}
