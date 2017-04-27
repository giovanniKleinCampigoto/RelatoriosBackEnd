package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Status;
import util.HibernateUtil;

public class StatusDAO {

	public Integer adicionarStatus (Status status) {
		
		int id = 0;
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(status);
            id = status.getId();
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

	public List<Status> getTodosStatus() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<Status> list = null;

		try {
			t = session.beginTransaction();
			list = session.createQuery("from Status").list();

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

	public Status getStatus(int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		Status status = null;

		try {

			t = session.beginTransaction();
			status = (Status) session.createQuery("from Status where id = :id")
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
		return status;
	}

	
	public Status updateStatus(Status status) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(status);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}

	public void deleteStatus(int id) {
		Status status;

		status = getStatus(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(status);
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
