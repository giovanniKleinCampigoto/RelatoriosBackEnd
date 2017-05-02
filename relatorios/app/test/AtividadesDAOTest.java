package test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.junit.Test;

import dao.AtividadesDAO;
import dao.ClienteDAO;
import dao.ConsultorDAO;
import dao.StatusDAO;
import model.Atividades;
import model.Cliente;
import model.Consultor;
import model.Status;

public class AtividadesDAOTest {

	@Test
	public void testAddGetRemoveAtividades() {

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
		
		Atividades atividade = new Atividades();
		AtividadesDAO at = new AtividadesDAO();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		atividade.setCliente(cliente);
		atividade.setConsultor(consultor);
		atividade.setStatus(status);
		
		atividade.setArea("teste");
		atividade.setFerramenta("teste");
		atividade.setPrograma("teste");
		atividade.setTipo("cliente");
		atividade.setAtividades("teste");
		atividade.setInicio(Time.valueOf(dtf.format(now)));
		atividade.setFim(Time.valueOf(dtf.format(now)));
		atividade.setTempo(Time.valueOf("02:00:00"));
		atividade.setData(new Timestamp(System.currentTimeMillis()));
		int id = at.adicionarAtividades(atividade);
		
		assertNotNull(at.getAtividade(id));
		
		at.deleteAtividade(id);
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());
	}

	@Test
	public void testGetAtividades() {

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
		
		Atividades atividade = new Atividades();
		Atividades atividade2 = new Atividades();
		AtividadesDAO at = new AtividadesDAO();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		atividade.setCliente(cliente);
		atividade.setConsultor(consultor);
		atividade.setStatus(status);
		
		atividade2.setCliente(cliente);
		atividade2.setConsultor(consultor);
		atividade2.setStatus(status);
		
		
		atividade.setArea("teste");
		atividade.setFerramenta("teste");
		atividade.setPrograma("teste");
		atividade.setTipo("cliente");
		atividade.setAtividades("teste");
		atividade.setInicio(Time.valueOf(dtf.format(now)));
		atividade.setFim(Time.valueOf(dtf.format(now)));
		atividade.setTempo(Time.valueOf("02:00:00"));
		atividade.setData(new Timestamp(System.currentTimeMillis()));
		at.adicionarAtividades(atividade);
		
		atividade2.setArea("teste");
		atividade2.setFerramenta("teste");
		atividade2.setPrograma("teste");
		atividade2.setTipo("cliente");
		atividade2.setAtividades("teste");
		atividade2.setInicio(Time.valueOf(dtf.format(now)));
		atividade2.setFim(Time.valueOf(dtf.format(now)));
		atividade2.setTempo(Time.valueOf("02:00:00"));
		atividade2.setData(new Timestamp(System.currentTimeMillis()));
		at.adicionarAtividades(atividade2);
		
		
		List<Atividades> atvs = new ArrayList<Atividades>();
		
		atvs.addAll(at.getAtividades());
		
		assertEquals(true,!atvs.isEmpty());
		
		at.deleteAtividade(atividade.getId());
		at.deleteAtividade(atividade2.getId());
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());
		atvs.clear();

	}

	

	@Test
	public void testUpdateCliente() {
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
		
		Atividades atividade = new Atividades();
		AtividadesDAO at = new AtividadesDAO();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		atividade.setCliente(cliente);
		atividade.setConsultor(consultor);
		atividade.setStatus(status);
		
		atividade.setArea("teste");
		atividade.setFerramenta("teste");
		atividade.setPrograma("teste");
		atividade.setTipo("cliente");
		atividade.setAtividades("teste");
		atividade.setInicio(Time.valueOf(dtf.format(now)));
		atividade.setFim(Time.valueOf(dtf.format(now)));
		atividade.setTempo(Time.valueOf("02:00:00"));
		atividade.setData(new Timestamp(System.currentTimeMillis()));
		int id = at.adicionarAtividades(atividade);
		
		Atividades atux = new Atividades();
		
		atux = at.getAtividade(id);
		
		atux.setAtividades("Nova atividade");
		at.updateAtividade(atux);
		
		assertEquals(atux.getAtividades(), at.getAtividade(atux.getId()).getAtividades());
		
		at.deleteAtividade(atux.getId());
		cli.deleteCliente(cliente.getId());
		cons.deleteConsultor(consultor.getId());
		s.deleteStatus(status.getId());

	}

}
