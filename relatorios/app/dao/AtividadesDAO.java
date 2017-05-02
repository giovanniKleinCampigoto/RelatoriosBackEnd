package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Atividades;
import model.MelhoriasAtingidas;
import util.HibernateUtil;

public class AtividadesDAO {
	
	public Integer adicionarAtividades (Atividades atv) {
		
        Transaction trns = null;
        HibernateUtil util;
        int id = 0;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(atv);
            id = atv.getId();
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

	public List<Atividades> getAtividades() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<Atividades> list = null;

		try {
			t = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Atividades> criteria = builder.createQuery(Atividades.class);

			criteria.from(Atividades.class);

			list = session.createQuery(criteria).getResultList();

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
			atv = session.get(Atividades.class, id);
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

	
	public Atividades updateAtividade(Atividades atv) {
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
