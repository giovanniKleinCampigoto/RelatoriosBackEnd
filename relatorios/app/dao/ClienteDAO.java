package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Cliente;
import util.HibernateUtil;

public class ClienteDAO {
	
	public Integer adicionarCliente (Cliente cliente) {
		
		int id = 0;
        Transaction trns = null;
        HibernateUtil util;
        
        util = HibernateUtil.getInstance();
        Session session = util.getSession();
        
        try {
            trns = session.beginTransaction();
            session.save(cliente);
            id = cliente.getId();
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

	public List<Cliente> getClientes() {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		List<Cliente> list = null;

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

	public Cliente getCliente(int id) {

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Session session = instance.getSession();
		Transaction t = null;
		Cliente cliente = null;

		try {

			t = session.beginTransaction();
			cliente = (Cliente) session.createQuery("from Cliente where id = :id")
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
		return cliente;
	}

	
	public Cliente updateCliente(Cliente cliente) {
		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.update(cliente);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cliente;
	}

	public void deleteCliente(int id) {
		Cliente cliente;

		cliente = getCliente(id);

		HibernateUtil instance;
		instance = HibernateUtil.getInstance();

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.delete(cliente);
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
