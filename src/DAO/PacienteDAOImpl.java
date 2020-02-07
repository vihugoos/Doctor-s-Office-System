package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidade.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PacienteDAOImpl implements PacienteDAO {

	private static final String URL="jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "hugo12";
	
	private Connection con;
	
	public PacienteDAOImpl() {
		
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conexão paciente sucesso");
		} catch (SQLException e) {
			System.out.println("Conexão paciente falhou");
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Paciente p) {
		String sql = "INSERT INTO tb_paciente (id_paciente,nome_paciente,sexo_paciente,rg_paciente,cpf_paciente,dat_nasc_paciente,endereco_paciente,telefone_paciente)"
					+" VALUES (0,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p.getNomePaciente());
			st.setString(2, p.getSexoPaciente());
			st.setString(3, p.getRgPaciente());
			st.setString(4, p.getCpfPaciente());
			java.util.Date dt = p.getDataNascPaciente();
			long milliseg = dt.getTime();
			java.sql.Date dataSql = new java.sql.Date(milliseg);
			st.setDate(5, dataSql);
			st.setString(6, p.getEnderecoPaciente());
			st.setString(7, p.getTelefonePaciente());
			st.execute();
			System.out.println("Inclusão paciente com sucesso");
		} catch (SQLException e) {
			System.out.println("Falha ao incluir paciente");
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Paciente> pesquisarPorNome(String nome) {
		List<Paciente> listaPaciente = new ArrayList<>();
			
		try {
			String sql = "SELECT * FROM tb_paciente WHERE nome_paciente LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Paciente p = new Paciente();
				p.setIdPaciente(rs.getLong("id_paciente"));
				p.setNomePaciente(rs.getString("nome_paciente"));
				p.setRgPaciente(rs.getString("rg_paciente"));
				p.setSexoPaciente(rs.getString("sexo_paciente"));
				p.setCpfPaciente(rs.getString("cpf_paciente"));
				p.setTelefonePaciente(rs.getString("telefone_paciente"));
				p.setEnderecoPaciente(rs.getString("endereco_paciente"));
				p.setDataNascPaciente(new java.util.Date(
						rs.getDate("dat_nasc_paciente").getTime()));
				
				listaPaciente.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listaPaciente;
	}

	@Override
	public List<Paciente> pesquisaPorId(Long id) {
		List<Paciente> listaPaciente = new ArrayList<>();
		try {
		String sql = "SELECT * FROM tb_paciente WHERE id_paciente = ?";
				
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Paciente p = new Paciente();
				p.setIdPaciente(rs.getLong("id_paciente"));
				p.setNomePaciente(rs.getString("nome_paciente"));
				p.setSexoPaciente(rs.getString("sexo_paciente"));
				p.setRgPaciente(rs.getString("rg_paciente"));
				p.setCpfPaciente(rs.getString("cpf_paciente"));
				p.setDataNascPaciente(rs.getDate("dat_nasc_paciente"));
				p.setEnderecoPaciente(rs.getString("endereco_paciente"));
				p.setTelefonePaciente(rs.getString("telefone_paciente"));
				
				listaPaciente.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaPaciente;
	}

	@Override
	public ObservableList<String> retornarNomesPaciente() {
		ObservableList<String> listaNomePaciente = 
				FXCollections.observableArrayList();
		
		try {
		String sql = "SELECT nome_paciente FROM tb_paciente ORDER BY nome_paciente ASC;";
			PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				String n ;
				n = rs.getString("nome_paciente");
				
				listaNomePaciente.add(n);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaNomePaciente;

	}
	
}
