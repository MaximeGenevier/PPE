package fr.applirv.appli.techniques;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe Md5 permet de hacher une chaine de caractère
 *
 */
public class Md5 {
	
	
	
				/********** Déclaration des attributs et implémentation du constructeur **********/
	
	
	
    private String code;
 
    /**
     * @param md5
     * Constructeur de la classe
     */
    public Md5(String md5) {
    	
        passe(md5);
        
    }
 
    /**
     * @param pass la chaine de caractère non hachée
     * 
     * Méthode qui hache la chaine de caractère passée en paramètre
     */
    public void passe(String pass){
    	
        byte[] passBytes = pass.getBytes();
        
        //ON ESSAIE
        try {
        	
        	//De hachée la chaine de caractère
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(passBytes);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(passBytes);
            BigInteger number = new BigInteger(1, messageDigest);
            this.code= number.toString(16);
            
        } 
        //ON RECUPERE
        catch (NoSuchAlgorithmException e) {
        	
        	//Une exception et on affiche son message
        	throw new Error("invalid JRE: have not 'MD5' impl.", e);
                
        }
        
    }
    
    /**
     * @return code la chaine de caractère hachée
     */
    public String codeGet(){
    	
        return code;
        
    }
 
}
