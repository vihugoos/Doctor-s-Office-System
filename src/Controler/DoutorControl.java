package Controler;

import java.util.List;

import DAO.DoutorDAO;
import DAO.DoutorDAOImpl;
import Entidade.Doutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoutorControl {
	
	private DoutorDAO doutorDAO = new DoutorDAOImpl();
	
	private ObservableList<Doutor> listaDoutor = 
					FXCollections.observableArrayList();
	
	public void adicionarDoutor(Doutor d) {
		doutorDAO.adicionar(d);
		
	}
	
	public List<Doutor> pesquisarPorNome(String nome){
		List<Doutor> lista = doutorDAO.pesquisarPorNome(nome);
		this.listaDoutor.clear();
		this.listaDoutor.addAll(lista);
		
		return lista;
	}
	
	public List<Doutor> pesquisarDoutor(Long id){
		List<Doutor> listaDoutor = doutorDAO.pesquisarPorId(id);
		this.listaDoutor.clear();
		this.listaDoutor.addAll(listaDoutor);
		return listaDoutor;	
	}
	
	public ObservableList<Doutor> getListaDoutor(){
		return listaDoutor;
		
	}
	
	public ObservableList<String> getListaNomeDoutor(){
		return doutorDAO.retornarNomesDoutor();
	}
}
