/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Produit implements Serializable {
    private String  refProduit;
    private String nomProduit;
    private double prixProduit;
    private int qantite;
    private Categorie categorie;
    
    public Produit(String ref,String nom,double prix,int quantite){
    super();
    this.refProduit=ref;
    this.nomProduit=nom;
    this.prixProduit=prix;
    this.qantite=quantite;
    
    }

    Produit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setRefProduit(String ref){
        this.refProduit=ref;
    }
    public String getrefProduit(){
        return this.refProduit;
    }
    public void setNomProduit(String nom){
        this.nomProduit=nom;}
    public String getNomProduit(){
        return this.nomProduit;
    }
    public void setPrixProduit(double prix){
        this.prixProduit=prix;}
    public double getPrix(){
        return this.prixProduit;
    }
    public void setQuantiteProduit(int quant){
        this.qantite=quant;}
   
    public int getQuantite()
     {
       return this.qantite;
     }
public void setCategorie(Categorie cat)
{ this.categorie=cat;}
public Categorie getCategorie()
{ return this.categorie;}
    
}
