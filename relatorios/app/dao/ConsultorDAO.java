package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Cliente;
import model.Consultor;
import util.HibernateUtil;

public class ConsultorDAO {

	public Integer adicionarConsultor (Consultor consultor) {
		int id  = 0;
		
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(consultor);
            id = consultor.getId();
            session.getTransaction().commit();
            
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

	public List<Consultor> getConsultores() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<Consultor> list = null;

		try {
			t = session.beginTransaction();
			list = session.createQuery("from Consultor").list();

		} catch (HibernateException ex) {
			if (t != null) {
				t.rollback();
			}
			Logger.getLogger("com").info("Exception: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public Consultor getConsultor(int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		Consultor consultor = null;

		try {

			t = session.beginTransaction();
			consultor = (Consultor) session.createQuery("from Consultor where id = :id")
					.setParameter("id", id).uniqueResult();
		} catch (HibernateException ex) {
			if (t != null) {
				t.rollback();
			}
			Logger.getLogger("com").info("Exception: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return consultor;
	}
	
	public Consultor updateConsultor(Consultor consultor) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(consultor);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return consultor;
	}

	public void deleteConsultor(int id) {
		Consultor consultor;

		consultor = getConsultor(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(consultor);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

}
