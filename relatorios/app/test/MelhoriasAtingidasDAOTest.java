package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.ClienteDAO;
import dao.ConsultorDAO;
import dao.MelhoriasAtingidasDAO;
import dao.StatusDAO;
import model.Cliente;
import model.Consultor;
import model.MelhoriasAtingidas;
import model.Status;

public class MelhoriasAtingidasDAOTest {

	@Test
	public void testAddGetRemoveMelhoria() {
		Cliente cliente = new Cliente();
		ClienteDAO cli = new ClienteDAO();

		Consultor consultor = new Consultor();
		ConsultorDAO cons = new ConsultorDAO();

		Status status = new Status();
		StatusDAO s = new StatusDAO();

		cliente.setNome("Geraldo");
		cli.adicionarCliente(cliente);

		consultor.setNome("Geronimo");
		cons.adicionarConsultor(consultor);

		status.setStatus("Concluido");
		s.adicionarStatus(status);

		MelhoriasAtingidas melhoria = new MelhoriasAtingidas();
		MelhoriasAtingidasDAO md = new MelhoriasAtingidasDAO();

		melhoria.setCliente(cliente);
		melhoria.setConsultor(consultor);
		melhoria.setCriado(new Timestamp(System.currentTimeMillis()));
		melhoria.setMelhorias("Cliente consegue realizar tal processo mais rápido...");
		melhoria.setStatus(status);

		int id = md.adicionarMelhoria(melhoria);

		assertNotNull(md.getMelhoria(id));

		md.deleteMelhoriaAtingida(melhoria.getId());
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());

	}

	@Test
	public void testGetMelhorias() {

		Cliente cliente = new Cliente();
		ClienteDAO cli = new ClienteDAO();

		Consultor consultor = new Consultor();
		ConsultorDAO cons = new ConsultorDAO();

		Status status = new Status();
		StatusDAO s = new StatusDAO();

		cliente.setNome("Geraldo");
		cli.adicionarCliente(cliente);

		consultor.setNome("Geronimo");
		cons.adicionarConsultor(consultor);

		status.setStatus("Concluido");
		s.adicionarStatus(status);

		MelhoriasAtingidas melhoria = new MelhoriasAtingidas();
		MelhoriasAtingidas melhoria2 = new MelhoriasAtingidas();
		MelhoriasAtingidasDAO md = new MelhoriasAtingidasDAO();

		melhoria.setCliente(cliente);
		melhoria.setConsultor(consultor);
		melhoria.setCriado(new Timestamp(System.currentTimeMillis()));
		melhoria.setMelhorias("Cliente consegue realizar tal processo mais rápido...");
		melhoria.setStatus(status);

		melhoria2.setCliente(cliente);
		melhoria2.setConsultor(consultor);
		melhoria2.setCriado(new Timestamp(System.currentTimeMillis()));
		melhoria2.setMelhorias("Cliente consegue realizar tal processo mais rápido...(2)");
		melhoria.setStatus(status);

		md.adicionarMelhoria(melhoria);
		md.adicionarMelhoria(melhoria2);

		List<MelhoriasAtingidas> ma = new ArrayList<MelhoriasAtingidas>();

		ma.addAll(md.getMelhorias());

		assertEquals(!true, ma.isEmpty());

		md.deleteMelhoriaAtingida(melhoria.getId());
		md.deleteMelhoriaAtingida(melhoria2.getId());
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());
		ma.clear();
	}

	@Test
	public void testUpdateMelhoriaAtingida() {

		Cliente cliente = new Cliente();
		ClienteDAO cli = new ClienteDAO();

		Consultor consultor = new Consultor();
		ConsultorDAO cons = new ConsultorDAO();

		Status status = new Status();
		StatusDAO s = new StatusDAO();

		cliente.setNome("Geraldo");
		cli.adicionarCliente(cliente);

		consultor.setNome("Geronimo");
		cons.adicionarConsultor(consultor);

		status.setStatus("Concluido");
		s.adicionarStatus(status);

		MelhoriasAtingidas melhoria = new MelhoriasAtingidas();
		MelhoriasAtingidas maux = new MelhoriasAtingidas();
		MelhoriasAtingidasDAO md = new MelhoriasAtingidasDAO();

		melhoria.setCliente(cliente);
		melhoria.setConsultor(consultor);
		melhoria.setCriado(new Timestamp(System.currentTimeMillis()));
		melhoria.setMelhorias("Cliente consegue realizar tal processo mais rápido...");
		melhoria.setStatus(status);

		int id = md.adicionarMelhoria(melhoria);

		maux = md.getMelhoria(id);
		maux.setMelhorias("Cliente consegue realizar processo...");
		md.updateMelhoriaAtingida(maux);

		assertEquals(maux.getMelhorias(), md.getMelhoria(id).getMelhorias());

		md.deleteMelhoriaAtingida(melhoria.getId());
		md.deleteMelhoriaAtingida(maux.getId());
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());
	}

}
