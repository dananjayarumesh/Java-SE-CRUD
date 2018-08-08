/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DbAccess;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Products;
import util.NewHibernateUtil;

/**
 *
 * @author Rumesh Dananjaya
 */
public class ProductController {

    public List<Products> loadProducts() {
        List<Products> Productlist = DbAccess.getProduct();
        return Productlist;
    }

    public boolean addProduct(String name, float price, String date) {

        int productId = 0;
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            
            Products product = new Products(name, price, date);

            productId = (Integer) session.save(product);

            tx.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (e != null) {
                tx.rollback();
            }
            
        } finally {
            session.close();
        }

        return productId > 0;
    }

}
