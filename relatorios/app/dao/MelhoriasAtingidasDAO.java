package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.MelhoriasAtingidas;
import util.HibernateUtil;

public class MelhoriasAtingidasDAO {
	
	public void adicionarMelhoria (MelhoriasAtingidas melhorias) {
		
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(melhorias);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

	public List<MelhoriasAtingidas> getMelhorias() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<MelhoriasAtingidas> list = null;

		try {
			t = session.beginTransaction();
			list = session.createQuery("from Melhorias_Atingidas").list();

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

	public MelhoriasAtingidas getMelhoria(int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		MelhoriasAtingidas melhoria = null;

		try {

			t = session.beginTransaction();
			melhoria = (MelhoriasAtingidas) session.createQuery("from Melhorias_Atingidas where id = :id")
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
		return melhoria;
	}

	
	public MelhoriasAtingidas updateMelhoriaAtingida(MelhoriasAtingidas melhoria) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(melhoria);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return melhoria;
	}

	public void deleteMelhoriaAtingida(int id) {
		MelhoriasAtingidas melhoria;

		melhoria = getMelhoria(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(melhoria);
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
