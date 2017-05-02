package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.ObsCronogramaDAO;
import dao.StatusDAO;
import model.ObsCronograma;
import model.Status;

public class ObsCronogramaDAOTest {
	ObsCronograma obs;
	ObsCronogramaDAO ob;
	Status status;
	StatusDAO s;
	List<ObsCronograma> o;

	@Test
	public void testAddGetDeleteObsCronograma() {
		obs = new ObsCronograma();
		ObsCronograma aux = new ObsCronograma();
		ob = new ObsCronogramaDAO();
		
		status = new Status();
		s = new StatusDAO();
		
		status.setStatus("Concluido");
		int id = s.adicionarStatus(status);
		
		obs.setPrevisto("Fazer alguma tarefa");
		obs.setRealizado("Tarefa completa");
		obs.setCriado(new Timestamp(System.currentTimeMillis()));
		obs.setStatus(s.getStatus(id));
		
		id = ob.adicionarObsCronograma(obs);
				
		aux = ob.getObsCronograma(id);
		assertNotNull(aux);		
		
		ob.deleteObsCronograma(id);
		s.deleteStatus(s.getTodosStatus().get(0).getId());
		
	}
	
	@Test
	public void testGetObsCronogramas() {
		ObsCronograma obs1 = new ObsCronograma();
		ObsCronograma obs2 = new ObsCronograma();
		
		ob = new ObsCronogramaDAO();
		o = new ArrayList<ObsCronograma>();
		status = new Status();
		s = new StatusDAO();
		
		status.setStatus("Concluido");
		int id = s.adicionarStatus(status);
		
		obs1.setPrevisto("Fazer alguma tarefa");
		obs1.setRealizado("Tarefa completa");
		obs1.setCriado(new Timestamp(System.currentTimeMillis()));
		obs1.setStatus(status);
		
		obs2.setPrevisto("Fazer alguma tarefa");
		obs2.setRealizado("Tarefa completa");
		obs2.setCriado(new Timestamp(System.currentTimeMillis()));
		obs2.setStatus(status);
		
		ob.adicionarObsCronograma(obs1);
		ob.adicionarObsCronograma(obs2);
				
		o.addAll(ob.getObsCronogramas());
		
		assertEquals(true,!o.isEmpty());
		
		ob.deleteObsCronograma(o.get(0).getId());
		ob.deleteObsCronograma(o.get(1).getId());
		
		o.clear();
		
		s.deleteStatus(id);
	}

	@Test
	public void testUpdateObsCronograma() {
	
		obs = new ObsCronograma();
		ObsCronograma aux = new ObsCronograma();
		ob = new ObsCronogramaDAO();
		
		status = new Status();
		Status status2 = new Status();
		s = new StatusDAO();
		
		status.setStatus("Concluido");
		int id = s.adicionarStatus(status);
		
		obs.setPrevisto("Fazer alguma tarefa");
		obs.setRealizado("Tarefa completa");
		obs.setCriado(new Timestamp(System.currentTimeMillis()));
		obs.setStatus(s.getStatus(id));
		
		id = ob.adicionarObsCronograma(obs);
		
		status2.setStatus("Em andamento...");
		int id2 = s.adicionarStatus(status2);
		
		aux = ob.getObsCronograma(id);
		aux.setPrevisto("Fazer outra tarefa");
		aux.setRealizado("Tarefa em andamento...");
		aux.setCriado(new Timestamp(System.currentTimeMillis()));
		aux.setStatus(status2);
		
		ob.updateObsCronograma(aux);
		assertNotNull(ob.getObsCronograma(aux.getId()));
		
		ob.deleteObsCronograma(aux.getId());
		s.deleteStatus(status.getId());
		s.deleteStatus(status2.getId());
		
	}
	
}
