package DAO;

import java.util.List;

import Entidade.Paciente;
import javafx.collections.ObservableList;

public interface PacienteDAO {
	
	void adicionar(Paciente p);
	List<Paciente> pesquisarPorNome(String nome);
	List<Paciente> pesquisaPorId(Long id);
	ObservableList<String> retornarNomesPaciente();
}
