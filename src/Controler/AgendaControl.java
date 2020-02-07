package Controler;

import java.util.List;
import DAO.AgendaDAO;
import DAO.AgendaDAOImpl;
import Entidade.Agenda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AgendaControl {
	
	private AgendaDAO agendaDao = new AgendaDAOImpl();	
	ObservableList<Agenda> listaAgenda = FXCollections
								.observableArrayList();
	
	public void adicionarAgenda( Agenda a) {
		agendaDao.adicionar(a);
	}
	
	public List<Agenda> pesquisarPorIdAgenda(Long id){
		List<Agenda> lista = agendaDao.pesquisarPorId(id);
		this.listaAgenda.clear();
		this.listaAgenda.addAll(lista);
		return lista;
	}
	
	public ObservableList<Agenda> getLista(){
		return listaAgenda;
	}
}
