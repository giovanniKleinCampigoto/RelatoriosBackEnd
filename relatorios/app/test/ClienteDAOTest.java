package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.ClienteDAO;
import dao.StatusDAO;
import model.Cliente;
import model.Status;

public class ClienteDAOTest {
	Cliente cliente;
	ClienteDAO cdao;
	List<Cliente> cls;

	@Test
	public void testAddGetAndDeleteCliente() {
		cliente  = new Cliente();
		Cliente aux = new Cliente();
		
		cdao = new ClienteDAO();
		cliente.setNome("Eraldo");
		int id  = cdao.adicionarCliente(cliente);
		
		aux = cdao.getCliente(id);
		assertNotNull(aux);
		
		cdao.deleteCliente(aux.getId());
	}

	@Test
	public void testGetClientes() {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cdao = new ClienteDAO();
		cls = new ArrayList<Cliente>();
		
		cliente1.setNome("Eraldo");
		cliente2.setNome("Bruno");
		cliente3.setNome("João");
		
		cdao.adicionarCliente(cliente1);
		cdao.adicionarCliente(cliente2);
		cdao.adicionarCliente(cliente3);
		
		cls.addAll(cdao.getClientes());
		
		assertEquals(true, !cls.isEmpty());
		
		for (int i = 0; i < cls.size(); i++) {
			cdao.deleteCliente(cls.get(i).getId());
		}
		
		cls.clear();
		
	}


	@Test
	public void testUpdateCliente() {
		cliente  = new Cliente();
		Cliente aux = new Cliente();
		
		cdao = new ClienteDAO();
		cliente.setNome("Eraldo");
		int id  = cdao.adicionarCliente(cliente);
		
		aux = cdao.getCliente(id);
		aux.setNome("Evandro");
		cdao.updateCliente(aux);
		assertEquals(aux.getNome(),cdao.getCliente(id).getNome());
		
		cdao.deleteCliente(aux.getId());

	}


}
