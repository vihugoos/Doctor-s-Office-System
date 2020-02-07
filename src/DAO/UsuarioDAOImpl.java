package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidade.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "hugo12";
	
	private Connection con;
	
	public UsuarioDAOImpl() {
		
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Usuario Conectado");
		} catch (SQLException e) {
			System.out.println("Conexão usuario falhou");
			e.printStackTrace();
		}
		
	}

	@Override
	public void adicionar(Usuario u) {
		String sql = "INSERT INTO tb_usuario(id_usuario,nome_usuario,sexo_usuario,rg_usuario,cpf_usuario,dat_nasc_usuario,endereco_usuario,telefone_usuario,longin_usuario,senha_usuario)"
					+ " VALUES (0,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u.getNome());
			st.setString(2, u.getSexo());
			st.setString(3, u.getRg());
			st.setString(4, u.getCpf());
			java.util.Date dt = u.getDataNasc();
			long milliseg = dt.getTime();
			java.sql.Date dataSql = new java.sql.Date(milliseg);
			st.setDate(5, dataSql);
			st.setString(6, u.getEndereco());
			st.setString(7, u.getTelefone());
			st.setString(8, u.getNomeUsuario());
			st.setInt(9, u.getSenha());
			st.execute();
			System.out.println("Usuario incluido no banco");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir usuario no banco");
			e.printStackTrace();
		}
	}

}
