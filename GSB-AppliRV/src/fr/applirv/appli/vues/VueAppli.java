/**
 * 
 */
package fr.applirv.appli.vues;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import fr.applirv.appli.controleurs.ControleurAppli;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe VueAppli étend JFrame
 * C'est la vue principale
 * de l'application
 *
 */
public class VueAppli extends JFrame{
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
	private static final long 	serialVersionUID 	= 1L;
	private static final double version 			= 2.0;
	
	//Le contrôleur de la vue
	private ControleurAppli controleur;
	//Les menus
	private JMenu menuConnexion 			= new JMenu("Connexion");
	private JMenu menuConsulter 			= new JMenu("Consulter");
	private JMenu menuParametres 			= new JMenu("Paramètres");
	
	//Les items des menus
	private JMenuItem itemSeConnecter 		= new JMenuItem("Se connecter");
	private JMenuItem itemSeDeconnecter 	= new JMenuItem("Se déconnecter");
	private JMenuItem itemChangerMotDePasse = new JMenuItem("Changer le mot de passe");
	private JMenuItem itemQuitter 			= new JMenuItem("Quitter");
	private JMenuItem itemRapportVisite 	= new JMenuItem("Rapport de visite");
	private JMenuItem itemPraticien 		= new JMenuItem("Praticiens hésitants");
	private JMenuItem itemAPropos 			= new JMenuItem("A propos");
	
	//Gestionnaire d'agencement et conteneur
	private CardLayout 	clVues 				= new CardLayout(5, 5);
	private Container 	conteneur;
	
	//Les différents panneaux JPanel
	private VueRapportsVisite 	vueRapportVisite 	= new VueRapportsVisite(this);
	private VueAccueil 			vueAccueil 			= new VueAccueil();
	

	/**
	 * Constructeur de la vue principale de l'application
	 */
	public VueAppli(){
		
		super();
		
		//Titre de la fenêtre
		this.setTitle("AppliRV"+ " - Version : "+ version);
		
		//Taille de la fenêtre, largeur / hauteur
		this.setSize(700, 500);
		
		//Position de la fenêtre: centrée
		this.setLocationRelativeTo(null);
		
		//Action par défaut de la croix de la fenêtre
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//Redimensionnement de la fenêtre par l'utilisateur: true
		this.setResizable(true);
		
		//Barre de menus
		this.creerBarreMenus();
		
		//Mode de la barre au lancement de l'application: déconnecté
		this.setBarreMenusModeDeconnecte();
		
		//réation de l'interface
		this.creerInterface();
		
		//Crée le contrôleur associé et lui indique que la vue qui lui est associé
		//est elle-même
		this.controleur = new ControleurAppli(this);
		//Affiche la fenêtre
		this.setVisible(true);
		
	}
	
	
	
				/********** Méthode de gestion de la vue **********/
	
	
	
	/**
	 * Méthode permettant la création de la barre de menu
	 */
	private void creerBarreMenus(){
		
		//Barre de menu vide
		JMenuBar barreMenus = new JMenuBar();
		
		//Ajout des items dans leur menu respectif
		this.menuConnexion.add(itemSeConnecter);
		this.menuConnexion.add(itemSeDeconnecter);
		this.menuConnexion.add(new JSeparator());
		this.menuConnexion.add(itemChangerMotDePasse);
		this.menuConnexion.add(new JSeparator());
		this.menuConnexion.add(itemQuitter);
		
		this.menuConsulter.add(itemRapportVisite);
		this.menuConsulter.add(itemPraticien);
		
		this.menuParametres.add(itemAPropos);
		
		//Ajout des menus dans la barre de menu
		barreMenus.add(menuConnexion);
		barreMenus.add(menuConsulter);
		barreMenus.add(menuParametres);
		
		//Ajout de la barre de menu à la fenêtre
		this.setJMenuBar(barreMenus);
		
	}
	
	/**
	 * Créé l'interface de la vue princiale
	 */
	private void creerInterface(){
		
		//Ajout du gestionnaire d'agencement au conteneur
		this.conteneur = this.getContentPane();
		this.conteneur.setLayout(clVues);
		
		//Ajout des vues au conteneur
		this.conteneur.add(vueAccueil, "Accueil");
		this.conteneur.add(vueRapportVisite, "Rapport de visite");
		
		//Vue au lancement de l'application : Accueil
		this.changerVue("Accueil");
		
	}
	
	
	/**
	 * Change les items de la barre de menu en mode connecté
	 * Les items: se déconnecter et le menu consulter deviennent
	 * disponible 
	 * L'item se connecter est indisponible
	 */
	public void setBarreMenusModeConnecte(){
		
		//Désactive les items: seConnecter
		this.itemSeConnecter.setEnabled(false);
		
		//Active les items: seDeconnecter changerMotDePasse et menuConsulter
		this.itemSeDeconnecter.setEnabled(true);
		this.itemChangerMotDePasse.setEnabled(true);
		this.menuConsulter.setEnabled(true);
		
	}
	
	
	/**
	 * Change les items de la barre de menu en mode déconnecté
	 * Les items: se connecter deviennent disponibles
	 * Les items: se déconnecter et le menu consulter sont
	 * inaccessibles
	 */
	public void setBarreMenusModeDeconnecte(){
		
		//Active les items: seConnecter
		this.itemSeConnecter.setEnabled(true);
		
		//Désactive les items: seDeconnecter, changerMotDePasse et menuConsulter
		this.itemSeDeconnecter.setEnabled(false);
		this.itemChangerMotDePasse.setEnabled(false);
		this.menuConsulter.setEnabled(false);
		
	}
	
	/**
	 * @param nomVue
	 * Change la vue affichée par le CardLayout clVues
	 */
	public void changerVue(String nomVue){
		
		System.out.println("VueAppli::changerVue("+nomVue+")");
		this.clVues.show(conteneur, nomVue);
		
	}

	
	
				/********** Getters et Setters de la classe **********/
	
	
	
	/**
	 * @return l'item se conncter
	 */
	public JMenuItem getItemSeConnecter() {
		return itemSeConnecter;
	}

	/**
	 * @return l'item se déconnecter
	 */
	public JMenuItem getItemSeDeconnecter() {
		return itemSeDeconnecter;
	}
	
	/**
	 * @return l'item changer mot de passe
	 */
	public JMenuItem getItemChangerMotDePasse() {
		return itemChangerMotDePasse;
	}

	/**
	 * @return l'item quitter
	 */
	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	/**
	 * @return l'item rapport de visite
	 */
	public JMenuItem getItemRapportVisite() {
		return itemRapportVisite;
	}

	/**
	 * @return l'item praticien 
	 */
	public JMenuItem getItemPraticien() {
		return itemPraticien;
	}

	/**
	 * @return l'item à propos
	 */
	public JMenuItem getItemAPropos() {
		return itemAPropos;
	}

	/**
	 * @return the controleur
	 */
	public ControleurAppli getControleur() {
		return controleur;
	}



	/**
	 * @return the menuConnexion
	 */
	public JMenu getMenuConnexion() {
		return menuConnexion;
	}



	/**
	 * @param menuConnexion the menuConnexion to set
	 */
	public void setMenuConnexion(JMenu menuConnexion) {
		this.menuConnexion = menuConnexion;
	}



	/**
	 * @return the menuConsulter
	 */
	public JMenu getMenuConsulter() {
		return menuConsulter;
	}



	/**
	 * @param menuConsulter the menuConsulter to set
	 */
	public void setMenuConsulter(JMenu menuConsulter) {
		this.menuConsulter = menuConsulter;
	}



	/**
	 * @return the menuParametres
	 */
	public JMenu getMenuParametres() {
		return menuParametres;
	}



	/**
	 * @param menuParametres the menuParametres to set
	 */
	public void setMenuParametres(JMenu menuParametres) {
		this.menuParametres = menuParametres;
	}



	/**
	 * @return the clVues
	 */
	public CardLayout getClVues() {
		return clVues;
	}



	/**
	 * @param clVues the clVues to set
	 */
	public void setClVues(CardLayout clVues) {
		this.clVues = clVues;
	}



	/**
	 * @return the conteneur
	 */
	public Container getConteneur() {
		return conteneur;
	}



	/**
	 * @param conteneur the conteneur to set
	 */
	public void setConteneur(Container conteneur) {
		this.conteneur = conteneur;
	}



	/**
	 * @return the vueRapportVisite
	 */
	public VueRapportsVisite getVueRapportVisite() {
		return vueRapportVisite;
	}



	/**
	 * @param vueRapportVisite the vueRapportVisite to set
	 */
	public void setVueRapportVisite(VueRapportsVisite vueRapportVisite) {
		this.vueRapportVisite = vueRapportVisite;
	}



	/**
	 * @return the vueAccueil
	 */
	public VueAccueil getVueAccueil() {
		return vueAccueil;
	}



	/**
	 * @param vueAccueil the vueAccueil to set
	 */
	public void setVueAccueil(VueAccueil vueAccueil) {
		this.vueAccueil = vueAccueil;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @return the version
	 */
	public static double getVersion() {
		return version;
	}



	/**
	 * @param controleur the controleur to set
	 */
	public void setControleur(ControleurAppli controleur) {
		this.controleur = controleur;
	}



	/**
	 * @param itemSeConnecter the itemSeConnecter to set
	 */
	public void setItemSeConnecter(JMenuItem itemSeConnecter) {
		this.itemSeConnecter = itemSeConnecter;
	}



	/**
	 * @param itemSeDeconnecter the itemSeDeconnecter to set
	 */
	public void setItemSeDeconnecter(JMenuItem itemSeDeconnecter) {
		this.itemSeDeconnecter = itemSeDeconnecter;
	}



	/**
	 * @param itemChangerMotDePasse the itemChangerMotDePasse to set
	 */
	public void setItemChangerMotDePasse(JMenuItem itemChangerMotDePasse) {
		this.itemChangerMotDePasse = itemChangerMotDePasse;
	}



	/**
	 * @param itemQuitter the itemQuitter to set
	 */
	public void setItemQuitter(JMenuItem itemQuitter) {
		this.itemQuitter = itemQuitter;
	}



	/**
	 * @param itemRapportVisite the itemRapportVisite to set
	 */
	public void setItemRapportVisite(JMenuItem itemRapportVisite) {
		this.itemRapportVisite = itemRapportVisite;
	}



	/**
	 * @param itemPraticien the itemPraticien to set
	 */
	public void setItemPraticien(JMenuItem itemPraticien) {
		this.itemPraticien = itemPraticien;
	}



	/**
	 * @param itemAPropos the itemAPropos to set
	 */
	public void setItemAPropos(JMenuItem itemAPropos) {
		this.itemAPropos = itemAPropos;
	}

}
