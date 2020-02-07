package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidade.Doutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoutorDAOImpl implements DoutorDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "hugo12";
	private Connection con;
	
	public DoutorDAOImpl() {
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conectado");
		} catch (SQLException e) {
			System.out.println("Erro conexão");
			e.printStackTrace();
		}	
		
	}
	
	@Override
	public void adicionar(Doutor d) {
		
		String sql = "INSERT INTO tb_doutor (id_doutor,nome_doutor,cpf_doutor,sexo,data_nasc,endereco,telefone,rg_doutor,especialidade,numero_cro)"
					+" VALUES(0,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, d.getNome());
			st.setString(2, d.getCpf());
			st.setString(3, d.getSexo());
			java.util.Date dt = d.getDataNasc();
			long milliseg = dt.getTime();
			java.sql.Date dataSql = new java.sql.Date(milliseg);			
			st.setDate(4, dataSql);
			st.setString(5, d.getEndereco());
			st.setString(6, d.getTelefone());
			st.setString(7, d.getRg());
			st.setString(8, d.getEspecialidade());
			st.setLong(9, d.getNumeroCro());
			st.execute();
			System.out.println("Doutor incluido");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir doutor");
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Doutor> pesquisarPorNome(String nome) {
		List<Doutor> listaDoutor = new ArrayList<>();
		
		try {
		String sql = "SELECT * FROM tb_doutor WHERE nome_doutor LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+ nome +"%");
			 ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				Doutor d = new Doutor();
				d.setId(rs.getLong("id_doutor"));
				d.setNome(rs.getString("nome_doutor"));
				d.setCpf(rs.getString("cpf_doutor"));
				d.setSexo(rs.getString("sexo"));
				d.setDataNasc(new java.util.Date(
						rs.getDate("data_nasc").getTime()));
				d.setEndereco(rs.getString("endereco"));
				d.setTelefone(rs.getString("telefone"));
				d.setRg(rs.getString("rg_doutor"));
				d.setEspecialidade(rs.getString("especialidade"));
				d.setNumeroCro(rs.getLong("numero_cro"));
				
				listaDoutor.add(d);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDoutor;
	}

	@Override
	public List<Doutor> pesquisarPorId(Long id) {
List<Doutor> listaDoutor = new ArrayList<>();
		
		try {
		String sql = "SELECT * FROM tb_doutor WHERE id_doutor  = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, id);
			 ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				Doutor d = new Doutor();
				d.setId(rs.getLong("id_doutor"));
				d.setNome(rs.getString("nome_doutor"));
				d.setCpf(rs.getString("cpf_doutor"));
				d.setSexo(rs.getString("sexo"));
				d.setDataNasc(new java.util.Date(
						rs.getDate("data_nasc").getTime()));
				d.setEndereco(rs.getString("endereco"));
				d.setTelefone(rs.getString("telefone"));
				d.setRg(rs.getString("rg_doutor"));
				d.setEspecialidade(rs.getString("especialidade"));
				d.setNumeroCro(rs.getLong("numero_cro"));
				
				listaDoutor.add(d);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDoutor;
	}

	@Override
	public ObservableList<String> retornarNomesDoutor() {
		ObservableList<String> listaNomeDoutor = 
				FXCollections.observableArrayList();
		
		try {
		String sql = "SELECT nome_doutor FROM tb_doutor ORDER BY nome_doutor ASC;";
			PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				String n ;
				n = rs.getString("nome_doutor");
				
				listaNomeDoutor.add(n);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaNomeDoutor;
	}

}
