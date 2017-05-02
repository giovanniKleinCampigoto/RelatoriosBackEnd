package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Cliente;
import model.ObsCronograma;
import util.HibernateUtil;

public class ObsCronogramaDAO {
	
	public Integer adicionarObsCronograma (ObsCronograma obs) {
		int id = 0;
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(obs);
            id = obs.getId();
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

	public List<ObsCronograma> getObsCronogramas() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<ObsCronograma> list = null;

		try {
			t = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<ObsCronograma> criteria = builder.createQuery(ObsCronograma.class);
			
			criteria.from(ObsCronograma.class);

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
	
	
	public ObsCronograma getObsCronograma(int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		ObsCronograma obs = null;

		try {
			t = session.beginTransaction();
			obs = session.get(ObsCronograma.class, id);
		} catch (HibernateException ex) {
			if (t != null) {
				t.rollback();
			}
			Logger.getLogger("com").info("Exception: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return obs;
	}

	
	public ObsCronograma updateObsCronograma(ObsCronograma obs) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(obs);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return obs;
	}

	public void deleteObsCronograma(int id) {
		ObsCronograma obs;

		obs = getObsCronograma(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(obs);
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
