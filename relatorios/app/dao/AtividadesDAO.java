package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Atividades;
import util.HibernateUtil;

public class AtividadesDAO {
	
	public void adicionarAtividades (Atividades atv) {
		
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(atv);
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

	public List<Atividades> getAtividades() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<Atividades> list = null;

		try {
			t = session.beginTransaction();
			list = session.createQuery("from Cliente").list();

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

	public Atividades getAtividade (int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		Atividades atv = null;

		try {

			t = session.beginTransaction();
			atv = (Atividades) session.createQuery("from Atividades where id = :id")
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
		return atv;
	}

	
	public Atividades updateCliente(Atividades atv) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(atv);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return atv;
	}

	public void deleteAtividade(int id) {
		Atividades atv;

		atv = getAtividade(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(atv);
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
