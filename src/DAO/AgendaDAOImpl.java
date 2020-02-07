package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidade.Agenda;


public class AgendaDAOImpl implements AgendaDAO {
	
	private static final String URL ="jdbc:mysql://localhost:3306/consultorio?serverTimezone=UTC&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "hugo12";
	
	private Connection con;
	
	public AgendaDAOImpl() {
		 try {
			con = DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException e) {		
			e.printStackTrace();
		}

	}

	@Override
	public void adicionar(Agenda a) {

		try {
		String sql = "INSERT INTO tb_agenda (id_doutor,id_paciente,data_agenda,turno,status_Agenda"
					+" VALUES (?,?,?,?,?);";	
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, a.getDoutor().getId());
			st.setLong(2, a.getPaciente().getIdPaciente());
			java.util.Date dt = a.getDataAgenda();
			long milliseg = dt.getTime();
			java.sql.Date dataSql = new java.sql.Date(milliseg);			
			st.setDate(3, dataSql);
			st.setString(4, a.getTurno());
			st.setString(5, a.getStatus());
			st.execute();
			System.out.println("Agenda Incluida com sucesso");
		} catch (SQLException e) {
			System.out.println("erro ao incluir agenda");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Agenda> pesquisarPorId(Long id) {
		List<Agenda> listaAgenda = new ArrayList<>();
		
		try {
		String sql = "SELECT * FROM tb_agenda WHERE id_agenda = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, id);
			 ResultSet rs = st.executeQuery();
			 
			while(rs.next()) {
				Agenda a = new Agenda();
				a.setIdAgenda(rs.getLong("id_agenda"));
				a.setIdDoutor(rs.getLong("id_doutor"));
				a.setIdPaciente(rs.getLong("id_paciente"));
				a.setDataAgenda(new java.util.Date(
						rs.getDate("data_agenda").getTime()));
				a.setTurno(rs.getString("turno"));
				a.setStatus(rs.getString("status_Agenda"));			
				
				listaAgenda.add(a);		
			}
			System.out.println("Lista agenda "+listaAgenda.size() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAgenda;
	}
	
}
