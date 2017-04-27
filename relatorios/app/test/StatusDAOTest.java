package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;

import dao.StatusDAO;
import model.Status;

public class StatusDAOTest {
	StatusDAO sts;
	Status status;
	List<Status> ls;
	Session session;

	@Test
	public void testAddGetAndDeleteStatus() {
		status  = new Status();
		Status aux = new Status();
		
		sts = new StatusDAO();
		status.setStatus("Em andamento...");
		int id  = sts.adicionarStatus(status);
		
		aux = sts.getStatus(id);
		assertNotNull(aux);
		
		sts.deleteStatus(aux.getId());

	}

	@Test
	public void testGetTodosStatus() throws InterruptedException {
		Status status1  = new Status();
		
		Status status2  = new Status();
		
		Status status3  = new Status();
		
		sts = new StatusDAO();
		
		status1.setStatus("Em andamento...");
		status2.setStatus("Concluido");
		status3.setStatus("??");
		
		sts.adicionarStatus(status1);
		sts.adicionarStatus(status2);
		sts.adicionarStatus(status3);
		
		ls = new ArrayList<Status>();
		
		ls.addAll(sts.getTodosStatus());
		
		assertEquals(true, !ls.isEmpty());		
		
		for (int i = 0; i < ls.size(); i++) {
			sts.deleteStatus(ls.get(i).getId());
		}
		
		ls.clear();
	}
	
	@Test
	public void testUpdateStatus() {
		status  = new Status();
		Status aux = new Status();
		
		sts = new StatusDAO();
		status.setStatus("Em andamento...");
		int id  = sts.adicionarStatus(status);
		
		aux = sts.getStatus(id);
		aux.setStatus("Concluido");
		sts.updateStatus(aux);
		
		assertEquals(aux.getStatus(), sts.getStatus(id).getStatus());
		
		sts.deleteStatus(aux.getId());
	}

}
