/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa07;

    import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Yolotzin Groh Hdez
 */
public class DAOProducto implements IDAOGeneral<Producto, Long> {

    @Override
    public Producto create(Producto p) {
    Session session=HibernateUtil.getSession();
    Transaction t= session.beginTransaction();
    session.save(p);
    t.commit();
    session.close();
    return p ;
    }

    @Override
    public boolean delete(Long id) {
         Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean res;
        Producto producto = findById(id);
        if (producto == null) {
            res = false;
        } else {
            session.delete(producto);
            res = true;
        }
        tx.commit();
        session.close();
        return res;
       }

    @Override
    public Producto update(Producto p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        session.update(p);
        t.commit();
        session.close();
        return p;
       }

    @Override
    public List<Producto> findAll() {
       Session session=HibernateUtil.getSession();
       Transaction t= session.beginTransaction();
       List<Producto> lstProd=session.createQuery("from Producto",Producto.class).list();
       t.commit();
       session.close();
       return lstProd;
    }

    @Override
    public Producto findById(Long id) {
        Session session= HibernateUtil.getSession();
        Transaction t= session.beginTransaction();
        Producto p=session.get(Producto.class, id);
        t.commit();
        session.close();
        return p;
        }

  
   

    
}
