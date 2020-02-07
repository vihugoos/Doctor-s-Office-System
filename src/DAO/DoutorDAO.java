package DAO;

import java.util.List;

import Entidade.Doutor;
import javafx.collections.ObservableList;

public interface DoutorDAO {
	
	void adicionar (Doutor d);
	
	List<Doutor> pesquisarPorNome(String nome);
	List<Doutor> pesquisarPorId(Long id);
	ObservableList<String> retornarNomesDoutor();

}
