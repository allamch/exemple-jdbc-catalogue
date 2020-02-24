/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class MetierCatalogueImpl implements IMetier {

    @Override
    public void addCategorie(Categorie c) {
        Connection conn=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("insert into categories (NOM_cat) value(?)");
            ps.setString(1,c.getNomCat());
            ps.executeUpdate();
            ps.close();
                    } catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterProduit(Produit p, int idCat) {
        Connection conn=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("insert into produits  value(?,?,?,?,?)");
            ps.setString(1,p.getrefProduit());
            ps.setString(2,p.getNomProduit());
            ps.setDouble(3,p.getPrix());
            ps.setInt(4,p.getQuantite());
            ps.setInt(5, idCat);
            
            ps.executeUpdate();
            ps.close();
                    } catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> getPtoduitParMc(String mc) {
    List<Produit> list=new ArrayList<Produit>();
    Connection conn= SingletonConnection.getConnection();
    try {
        PreparedStatement ps = conn.prepareStatement("select * from produits where NOM_PROD like ?");
        ps.setString(1,"%"+mc+"%");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        Produit p= new Produit();
        p.setRefProduit(rs.getString("REF_PROD"));
        p.setNomProduit(rs.getString("NOM_PROD"));
        p.setPrixProduit(rs.getDouble("PRIX"));
        p.setQuantiteProduit(rs.getInt("QUANTITE"));
        int idCat= rs.getInt("ID_CAT");
        PreparedStatement ps1= conn.prepareStatement("select * from categories where ID_CAT like ?");
        ps1.setInt(1,idCat);
        ResultSet rs1=ps1.executeQuery();
        if (rs1.next())
        {Categorie cat=new Categorie();
        cat.setIdCat(rs1.getInt("ID_CAT"));
        cat.setNomCat(rs1.getString("NOM_CAT"));
        p.setCategorie(cat);
        ps1.close();}
           list.add(p);     
        }
        ps.close();
    }
        catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
        return list;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        Connection conn= SingletonConnection.getConnection();
        List<Categorie> cats= new ArrayList<Categorie>();
        try{
        PreparedStatement st=conn.prepareStatement("select * from categories");
       ResultSet rs=st.executeQuery();
       while(rs.next())
       {
       Categorie c=new Categorie();
       c.setIdCat(rs.getInt("ID_CAT"));
       c.setNomCat(rs.getString("NOM_CAT"));
       cats.add(c);
       
       }
       st.close();
       return cats;
        }
        catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorie getCategorie(int idCat) {
        Connection conn= SingletonConnection.getConnection();
        Categorie c= new Categorie();
       
        try {
            PreparedStatement  st = conn.prepareStatement("select * from categories where ID_CAT=?");
              st.setInt(1, idCat);
              ResultSet rs = st.executeQuery();
                     if (rs.next())
                      {
                      c.setIdCat(idCat);
                      c.setNomCat(rs.getString("NOM_CAT"));
                      List<Produit> prod= new ArrayList<Produit>();
                    prod=this.getProduitCat(idCat);
                      }
                      return c;
        } catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param idCat
     * @return
     */
    @Override
    public List<Produit> getProduitCat(int idCat) {
        Connection conn=SingletonConnection.getConnection();
        List<Produit> prod=new ArrayList<Produit>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from produits where ID_CAT = ?");
            st.setInt(1, idCat);
            ResultSet rs= st.executeQuery();
            Produit p=new Produit();
            while(rs.next())
            {
                p.setRefProduit(rs.getString("REF_PROD"));
                p.setNomProduit(rs.getString("NOM_PROD"));
                p.setPrixProduit(rs.getDouble("PRIX"));
                p.setQuantiteProduit(rs.getInt("QUANTITE"));
                PreparedStatement st2= conn.prepareStatement("select * from categories where ID_CAT = ?");
                st2.setInt(1, idCat);
                ResultSet rs2=st2.executeQuery();
                if(rs2.next())
                {
                    Categorie c=new Categorie();
                    c.setIdCat(idCat);
                    c.setNomCat(rs2.getNString("NOM_CAT"));
                    p.setCategorie(c);
                    st2.close();
                }
            }
              prod.add(p);
               st.close();
               
            
            return prod;
        } catch (SQLException ex) {
            Logger.getLogger(MetierCatalogueImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
