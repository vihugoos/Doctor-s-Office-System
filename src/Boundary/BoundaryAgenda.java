package Boundary;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import Controler.AgendaControl;
import Controler.DoutorControl;
import Controler.PacienteControl;
import Entidade.Agenda;
import Entidade.Doutor;
import Entidade.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class BoundaryAgenda implements BoundaryConteudo {
	
	private Label lblIdAgenda = new Label("Cod. Agenda");
	private TextField txtIdAgenda = new TextField();
	private Label lblNomePaciente = new Label("Paciente");
	private ComboBox<String> cmbNomePaciente = new ComboBox<>();
	private Label lblRgPaciente = new Label("RG Paciente");
	private TextField txtRGPaciente = new TextField();
	private Label lblDataNascPaciente = new Label("Data.Nasc");
	private TextField txtNascPaciente = new TextField();
	private Label lblNomeDoutor = new Label("Doutor");
	private ComboBox<String> cmbNomeDoutor = new ComboBox<>();
	private Label lblCroDoutor = new Label("Número CRO");
	private TextField txtCroDoutor = new TextField();
	private Label lblDataAgenda = new Label("Data Agenda");
	private DatePicker dtpDataAgenda = new DatePicker();
	private Label lblTurno = new Label("Turno");
	private ComboBox<String> cmbTurno = new ComboBox<>();
	private Label lblStatus = new Label("Status");
	private ComboBox<String> cmbStatus = new ComboBox<>();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnNovo = new Button("Novo");
	private Button btnCancelar = new Button("Cancelar");
	private TableView<Agenda> tableAgenda = new TableView<>(); 
	
	private AgendaControl agendaControl = new AgendaControl();
	private DoutorControl doutorControl = new DoutorControl();
	private PacienteControl pacienteControl = new PacienteControl();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Pane gerarBoundary() {
		BorderPane  painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		TilePane painelBotao = new TilePane();
		
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(painelBotao);
		
		painelCampos.add(lblIdAgenda, 0, 0);
		painelCampos.add(txtIdAgenda, 1, 0);
		painelCampos.add(lblNomePaciente, 0, 1);
		painelCampos.add(cmbNomePaciente, 1, 1,3,1);
		painelCampos.add(lblDataNascPaciente, 4, 1);
		painelCampos.add(txtNascPaciente, 5, 1);		
		painelCampos.add(lblRgPaciente, 6, 1);
		painelCampos.add(txtRGPaciente, 7, 1);
		painelCampos.add(lblNomeDoutor, 0, 2);
		painelCampos.add(cmbNomeDoutor, 1, 2,3,1);
		painelCampos.add(lblCroDoutor, 4, 2);
		painelCampos.add(txtCroDoutor, 5, 2);
		painelCampos.add(lblDataAgenda, 0, 3);
		painelCampos.add(dtpDataAgenda, 1, 3);
		painelCampos.add(lblTurno, 2, 3);
		painelCampos.add(cmbTurno, 3, 3);
		painelCampos.add(lblStatus, 4, 3);
		painelCampos.add(cmbStatus, 5, 3);
		painelCampos.add(btnAdicionar, 0, 4);
		txtIdAgenda.setPrefWidth(20);
		cmbNomePaciente.setPrefWidth(300);
		cmbNomeDoutor.setPrefWidth(300);
		
		btnNovo.setPrefWidth(80);
		btnAdicionar.setPrefWidth(80);
		btnPesquisar.setPrefWidth(80);
		btnCancelar.setPrefWidth(80);
		painelBotao.getChildren().addAll(btnNovo,btnAdicionar,btnPesquisar,btnCancelar);
		
		ObservableList<String> turno = 
						FXCollections.observableArrayList("Manhã","Tarde");
		cmbTurno.setItems(turno);
		
		ObservableList<String> status = 
				FXCollections.observableArrayList("Agendado","Em andamento","Finalizado");
		cmbStatus.setItems(status);
		cmbNomeDoutor.setItems(doutorControl.getListaNomeDoutor());
		cmbNomePaciente.setItems(pacienteControl.getListaNomePaciente());
		painelPrincipal.setBottom(gerarTabela());
			
				
		return painelPrincipal;
	}

	public void daAgendaParaFormulario(Agenda a,Doutor d, Paciente p) {
		txtIdAgenda.setText(String.valueOf(a.getIdAgenda()));
		cmbNomePaciente.setItems(pacienteControl.getListaNomePaciente());
		txtNascPaciente.setText(sdf.format(p.getDataNascPaciente()));
		txtRGPaciente.setText(p.getRgPaciente());
		cmbNomeDoutor.setItems(doutorControl.getListaNomeDoutor());
		txtCroDoutor.setText(String.valueOf(d.getNumeroCro()));
		txtIdAgenda.setText(String.valueOf(a.getIdAgenda()));
		cmbStatus.setValue(a.getStatus());
		cmbTurno.setValue(a.getTurno());		
	}
	
	public Agenda doFormularioParaAgenda() {
		Agenda a = new Agenda();
		List<Doutor> listD = doutorControl.pesquisarPorNome(cmbNomePaciente.getValue());
		a.setTurno(cmbTurno.getValue());
		a.setStatus(cmbStatus.getValue());
			if(listD.size()>0) {
			a.setIdDoutor(listD.get(0).getId() );
			}
		LocalDate dt = dtpDataAgenda.getValue();
		Date data = Date.from(
				dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
		a.setDataAgenda(data);
		
		return a;
	}
	
	public TableView<Agenda> gerarTabela(){
		
		TableColumn<Agenda, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Agenda, Long>("idAgenda"));
		
		TableColumn<Agenda, String> colNomePaciente = new TableColumn<>("Nome Paciente");
		colNomePaciente.setCellValueFactory(new PropertyValueFactory<Agenda, String>("paciente"));
		
		TableColumn<Agenda, Date> colDatNascPaciente = new TableColumn<>("Data Nasc. Paciente");
		colDatNascPaciente.setCellValueFactory(new PropertyValueFactory<Agenda, Date>("dataNascPaciente"));
		
		TableColumn<Agenda, String> colRgPaciente = new TableColumn<>("RG Paciente");
		colRgPaciente.setCellValueFactory(new PropertyValueFactory<Agenda, String>("rgPaciente"));
		
		TableColumn<Agenda, String> colNomeDoutor = new TableColumn<>("Nome Doutor");
		colNomeDoutor.setCellValueFactory(new PropertyValueFactory<Agenda, String>("nome"));
		
		TableColumn<Agenda, Long> colNumeroCroDoutor = new TableColumn<>("CRO");
		colNumeroCroDoutor.setCellValueFactory(new PropertyValueFactory<Agenda, Long>("numeroCro"));
		
		TableColumn<Agenda, Date> colDataAgendameento = new TableColumn<>("Data Agendamento");
		colDataAgendameento.setCellValueFactory(new PropertyValueFactory<Agenda, Date>("dataAgenda"));
		
		TableColumn<Agenda, String> colTurno = new TableColumn<>("Turno");
		colTurno.setCellValueFactory(new PropertyValueFactory<Agenda, String>("turno"));
		
		TableColumn<Agenda, String> colStatus = new TableColumn<>("Status");
		colStatus.setCellValueFactory( new PropertyValueFactory<Agenda, String>("status"));
		
		tableAgenda.getColumns().addAll(colId,colNomePaciente,colDatNascPaciente,
						colRgPaciente,colNomeDoutor,colNumeroCroDoutor,colDataAgendameento,colTurno,colStatus);
		
		tableAgenda.setItems(agendaControl.getLista());
		
		return tableAgenda;
	}
	
}
