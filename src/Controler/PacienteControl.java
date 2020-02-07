package Controler;

import java.util.List;
import DAO.PacienteDAO;
import DAO.PacienteDAOImpl;
import Entidade.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PacienteControl {
	
	private PacienteDAO pacienteDAO = new PacienteDAOImpl();
	
	private ObservableList<Paciente> listaPaciente = 
			FXCollections.observableArrayList();
	
	
	public void adicionarPaciente(Paciente p) {
		pacienteDAO.adicionar(p);
		
	}
	
	public List<Paciente> pesquisaPorNome(String nome){
		List<Paciente> lista = pacienteDAO.pesquisarPorNome(nome);
		this.listaPaciente.clear();
		this.listaPaciente.addAll(lista);
		
		return lista;
	}
	
	public List<Paciente> pesquisaPorId (Long id){
		List<Paciente> lista = pacienteDAO.pesquisaPorId(id);
		this.listaPaciente.clear();
		this.listaPaciente.addAll(lista);
		
		return lista;
	}
	
	
	public ObservableList<Paciente> getLista(){
		return listaPaciente;
	}
	
	public ObservableList<String> getListaNomePaciente(){
		return pacienteDAO.retornarNomesPaciente();
	}
}
