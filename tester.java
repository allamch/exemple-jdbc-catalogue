/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author USER
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     MetierCatalogueImpl metier=  new MetierCatalogueImpl();
    /* metier.addCategorie(new Categorie("ordinateur"));
      metier.addCategorie(new Categorie("imprimente"));
       metier.addCategorie(new Categorie("souris"));*/
      /* metier.ajouterProduit(new Produit("p1","hp",3500,33),1);
        metier.ajouterProduit(new Produit("p2","hp",3500,33),2);
         metier.ajouterProduit(new Produit("p3","hp",3500,33),3);
          metier.ajouterProduit(new Produit("p4","hp",3500,33),1);*/
    /*   List<Categorie> cat=metier.getAllCategorie();
       for(Categorie c:cat)
       {System.out.println(c.getNomCat());
    }*/
List<Produit> prod=metier.getProduitCat(3);
for(Produit p:prod)
{System.out.println(p.getNomProduit());}
    System.out.println("---------------------------");
List<Produit> prod1 = metier.getPtoduitParMc("hp");
        for(Produit d:prod1){
            System.out.println(d.getrefProduit());
            
           System.out.println(d.getCategorie().getNomCat());
        }
}
}