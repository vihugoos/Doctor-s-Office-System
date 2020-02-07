package Controler;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Entidade.Usuario;

public class UsuarioControl {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	public void adicionarUsuario(Usuario u) {
		usuarioDAO.adicionar(u);
		
	}

}
