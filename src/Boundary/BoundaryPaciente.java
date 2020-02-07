package Boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import Controler.PacienteControl;
import Entidade.Paciente;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class BoundaryPaciente implements BoundaryConteudo {
	
	private Label lblIdPaciente = new Label("Id");
	private TextField txtIdPaciente = new TextField();
	private Label lblNomePaciente = new Label("Nome");
	private TextField txtNomePaciente = new TextField();
	private Label lblSexoPaciente = new Label("Sexo");
	private RadioButton rbSexoFeminino = new RadioButton("Feminino");
	private RadioButton rbSexoMasculino = new RadioButton("Masculino");
	private Label lblRgPaciente = new Label("RG");
	private TextField txtRgPaciente = new TextField();
	private Label lblCpfPaciente = new Label("CPF");
	private TextField txtCpfPaciente = new TextField();
	private Label lblDataNascPaciente = new Label("Data Nasc.");
	private DatePicker dpDataNascPaciente = new DatePicker();
	private Label lblEnderecoPaciente = new Label("Endereço");
	private TextField txtEnderecoPaciente = new TextField();
	private Label lblTelefonePaciente = new Label("Telefone");
	private TextField txtTelefonePaciente = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnNovo = new Button("Novo");
	private Button btnCancelar = new Button("Cancelar");
	private ToggleGroup tgsexo = new ToggleGroup();
	private  RadioButton sexoSelecionado;
	private TableView <Paciente> tabela = new TableView<>();
	private PacienteControl pacienteControl = new PacienteControl();
	
	@Override
	public Pane gerarBoundary() {
		
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		TilePane painelBotao = new TilePane();
		
		rbSexoFeminino.setToggleGroup(tgsexo);
		rbSexoMasculino.setToggleGroup(tgsexo);
		
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(painelBotao);
		
		painelCampos.add(lblIdPaciente, 0, 0);
		painelCampos.add(txtIdPaciente, 1, 0);
		txtIdPaciente.setDisable(true);
		painelCampos.add(lblNomePaciente, 0, 1);
		painelCampos.add(txtNomePaciente, 1, 1);
		painelCampos.add(lblSexoPaciente, 0, 2);
		painelCampos.add(rbSexoMasculino, 1, 2);
		painelCampos.add(rbSexoFeminino, 2, 2);
		painelCampos.add(lblRgPaciente, 0, 3);
		painelCampos.add(txtRgPaciente, 1, 3);
		painelCampos.add(lblCpfPaciente, 0, 4);
		painelCampos.add(txtCpfPaciente, 1, 4);
		painelCampos.add(lblDataNascPaciente, 0, 5);
		painelCampos.add(dpDataNascPaciente, 1, 5);
		painelCampos.add(lblEnderecoPaciente, 0, 6);
		painelCampos.add(txtEnderecoPaciente, 1, 6);
		painelCampos.add(lblTelefonePaciente, 0, 7);
		painelCampos.add(txtTelefonePaciente, 1, 7);
		
		btnNovo.setPrefWidth(80);
		btnAdicionar.setPrefWidth(80);
		btnPesquisar.setPrefWidth(80);
		btnCancelar.setPrefWidth(80);
		painelBotao.getChildren().addAll(btnNovo,btnAdicionar,btnPesquisar,btnCancelar);
		
		TableColumn<Paciente, Long> colIdPacinte = new TableColumn<>("Id");
		colIdPacinte.setCellValueFactory(new PropertyValueFactory<Paciente, Long>("idPaciente"));
		
		TableColumn<Paciente,String> colNomePaciente = new TableColumn<>("Nome");
		colNomePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nomePaciente"));
		
		TableColumn<Paciente, String> colRgPaciente = new TableColumn<>("RG");
		colRgPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("rgPaciente"));
		
		TableColumn<Paciente, String> colCpfPaciente = new TableColumn<>("CPF");
		colCpfPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cpfPaciente"));
		
		TableColumn<Paciente, String> colSexoPaciente = new TableColumn<>("Sexo");
		colSexoPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("sexoPaciente"));
		
		TableColumn<Paciente, Date> colDataNasc = new TableColumn<>("Data Nasc.");
		colDataNasc.setCellValueFactory(new PropertyValueFactory<Paciente,Date>("dataNascPaciente"));
		
		TableColumn<Paciente, String> colTelefonePaciente = new TableColumn<>("Telefone");
		colTelefonePaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefonePaciente"));
		
		TableColumn<Paciente, String> colEnderecoPaciente = new TableColumn<>("Endereço");
		colEnderecoPaciente.setCellValueFactory(new PropertyValueFactory<Paciente, String>("enderecoPaciente"));
		
		tabela.getColumns().addAll(colIdPacinte,colNomePaciente,colSexoPaciente,
							colRgPaciente,colCpfPaciente,colDataNasc,colTelefonePaciente,colEnderecoPaciente);
		
		tabela.setItems(pacienteControl.getLista());
		
		tabela.getSelectionModel().selectedItemProperty()
					.addListener(new ChangeListener<Paciente>() {
			@Override
			public void changed(ObservableValue<? extends Paciente> observable,
					Paciente oldValue,
					Paciente newValue) {
				doPacienteParaFormulario(newValue);
				
			}
		});
		
		painelPrincipal.setBottom(tabela);
		
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Paciente p = doFormularioParaPaciente();
				pacienteControl.adicionarPaciente(p);
				limparFormulario();
				btnPesquisar.setDisable(false);
				btnNovo.setDisable(false);
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Confirmação");
				a.setHeaderText("Paciente Adicionado com Sucesso!!");
				a.showAndWait();
			}
			
		});
		
		btnPesquisar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				List<Paciente> lista = 
						pacienteControl.pesquisaPorNome(txtNomePaciente.getText());
				System.out.println("Tamanho da Lista " + lista.size());
					if (lista.size() > 0) {
						doPacienteParaFormulario(lista.get(0));
					}
					btnAdicionar.setDisable(true);
			}
			
		});
		
		btnNovo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				limparFormulario();	
				btnAdicionar.setDisable(false);
				btnPesquisar.setDisable(true);
				btnNovo.setDisable(true);
			
			}
			
		});
		
		btnCancelar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				limparFormulario();	
				btnAdicionar.setDisable(false);
				btnPesquisar.setDisable(false);
				btnNovo.setDisable(false);
			
			}
			
		});
	
		
		return painelPrincipal;
	}
	
	public Paciente doFormularioParaPaciente() {
		Paciente p = new Paciente();
		sexoSelecionado  = (RadioButton) tgsexo.getSelectedToggle();
		
		p.setNomePaciente(txtNomePaciente.getText());
		p.setRgPaciente(txtRgPaciente.getText());
		p.setCpfPaciente(txtCpfPaciente.getText());
		p.setTelefonePaciente(txtTelefonePaciente.getText());
		p.setEnderecoPaciente(txtEnderecoPaciente.getText());
		p.setSexoPaciente(sexoSelecionado.getText());
		LocalDate dt = dpDataNascPaciente.getValue();
		Date data = Date.from(
				dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
		p.setDataNascPaciente(data);
		
		return p;
	}
	
	public void doPacienteParaFormulario(Paciente p) {
		txtIdPaciente.setText(String.valueOf(p.getIdPaciente()));
		txtNomePaciente.setText(p.getNomePaciente());
		txtRgPaciente.setText(p.getRgPaciente());
		txtCpfPaciente.setText(p.getCpfPaciente());
		txtEnderecoPaciente.setText(p.getEnderecoPaciente());
		txtTelefonePaciente.setText(p.getTelefonePaciente());
		if(p.getSexoPaciente().equals(rbSexoFeminino.getText())) {
			rbSexoFeminino.setSelected(true);
		}else {
			rbSexoMasculino.setSelected(true);
		}
		LocalDate localDate = p.getDataNascPaciente()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		dpDataNascPaciente.setValue(localDate);
	}
	
	public void limparFormulario() {
		txtIdPaciente.setText("");
		txtNomePaciente.setText("");
		txtRgPaciente.setText("");
		txtCpfPaciente.setText("");
		txtEnderecoPaciente.setText("");
		txtTelefonePaciente.setText("");
		rbSexoFeminino.setSelected(false);
		rbSexoMasculino.setSelected(false);
		dpDataNascPaciente.setValue(null);

		
	}

}
