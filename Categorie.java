/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Categorie implements Serializable {
    private int idcat;
    private String nomCat;
    private List<Produit> produits= new ArrayList<Produit>();
    
    public Categorie (String nom)
    {
     
    this.nomCat=nom;
   
    }
    public Categorie()
    {super();}
    public void setIdCat(int idcat){
        this.idcat=idcat;
    }
   
    public int getIdCat(){
        return idcat;
    }
    public void setNomCat(String nomCat){
        this.nomCat=nomCat;
    }
    public String getNomCat(){
        return nomCat;
    }
    public void setProduits(List<Produit> produits){
        this.produits=produits;
    }
    public List<Produit> getProduits(){ 
        return produits;}
           
}

