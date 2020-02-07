package DAO;

import java.util.List;

import Entidade.Agenda;

public interface AgendaDAO {
	void adicionar(Agenda a);
	List<Agenda> pesquisarPorId(Long id);
	
}
