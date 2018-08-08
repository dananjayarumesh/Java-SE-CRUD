/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Products;
import util.NewHibernateUtil;

/**
 *
 * @author Rumesh Dananjaya
 */
public class DbAccess {

    public static boolean addProduct(String name, float price, String date) {
        int movieId = 0;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            System.out.println("DONE");
            tx = session.beginTransaction();
            System.out.println("tx");
            Products movie = new Products(name, price, date);
            System.out.println("movie");
            movieId = (Integer) session.save(movie);
            System.out.println("movieId");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (e != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return movieId > 0;
    }

    public static List<Products> getProduct() {
        List<Products> Productlist = null;

        Session session = NewHibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;

        try {

//            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Products.class);
//            cr.add(Restrictions.eq("id", proId));
            Productlist = cr.list();
            
            for(Products p :Productlist){
                
                System.out.println(p.getId());
                
            }
            
            
//            Products p = (Products) cr.uniqueResult();
            
//            System.out.println(p.getId() + " - "  );
            
            
//            tx.commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            if (tx != null) {
//                tx.rollback();
//            }
        } finally {
            session.close();
        }

        return Productlist;
    }

}
