package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.ConsultorDAO;
import model.Consultor;

public class ConsultorDAOTest {
	Consultor cons;
	ConsultorDAO c;
	List<Consultor> cs;

	@Test
	public void testAddGetAndDeleteConsultor() {
	
		cons = new Consultor();
		c = new ConsultorDAO();
		Consultor aux = new Consultor();
		int id;
		
		cons.setNome("Mário");
		id = c.adicionarConsultor(cons);
		
		aux = c.getConsultor(id);
		assertNotNull(aux);
		
		c.deleteConsultor(id);
		
	}

	@Test
	public void testGetConsultores() {
		Consultor cons1 = new Consultor();
		Consultor cons2 = new Consultor();
		Consultor cons3 = new Consultor();
		cs = new ArrayList<Consultor>();
		c = new ConsultorDAO();
		
		cons1.setNome("Iago");
		cons2.setNome("Roberto");
		cons3.setNome("João");
		
		c.adicionarConsultor(cons1);
		c.adicionarConsultor(cons2);
		c.adicionarConsultor(cons3);	
		
		cs.addAll(c.getConsultores());
		
		assertEquals(true, !cs.isEmpty());
		
		for (int i = 0; i < cs.size(); i++) {
			c.deleteConsultor(cs.get(i).getId());
		}
		
		cs.clear();
	}

	
	@Test
	public void testUpdateConsultor() {
		cons = new Consultor();
		c = new ConsultorDAO();
		Consultor aux = new Consultor();
		int id;
		
		cons.setNome("Mário");
		id = c.adicionarConsultor(cons);
		
		aux = c.getConsultor(id);
		aux.setNome("Mario");
		c.updateConsultor(aux);
		
		assertEquals(aux.getNome(), c.getConsultor(id).getNome());
		
		c.deleteConsultor(id);
	}
	
}
