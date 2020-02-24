/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IMetier {
    public void addCategorie(Categorie c);
    public void ajouterProduit(Produit p, int idCat);
    public List<Produit> getPtoduitParMc(String mc);
    public List<Categorie> getAllCategorie();
    public Categorie getCategorie(int idCat);
    public List<Produit> getProduitCat(int idCat);
    
    
}
