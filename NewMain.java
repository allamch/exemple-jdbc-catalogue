/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author USER
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetierCatalogueImpl metier=  new MetierCatalogueImpl();
     metier.addCategorie(new Categorie("ordinateur"));
      metier.addCategorie(new Categorie("imprimente"));
       metier.addCategorie(new Categorie("souris"));
    }
    
}
