package Boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import Controler.DoutorControl;
import Entidade.Doutor;
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

public class BoundaryDoutor implements BoundaryConteudo {
	private Label lblId = new Label("Id");
	private TextField txtId = new TextField();
	private Label lblNome = new Label("Nome");
	private TextField txtNome = new TextField();
	private Label lblCpf = new Label("Cpf");
	private TextField txtCpf = new TextField();
	private Label lblSexo = new Label("Sexo");
	private RadioButton rbSexoMasc = new RadioButton("Masculino");
	private RadioButton rbSexoFem = new RadioButton("Feminino");
	private Label lblDataNasc = new Label("Data Nasc.");
	private DatePicker dpDataNasc = new DatePicker();
	private Label lblEndereco = new Label("Endereço");
	private TextField txtEndereco = new TextField();
	private Label lblTelefone = new Label("Telefone");
	private TextField txtTelefone = new TextField();
	private Label lblRg = new Label("Rg");
	private TextField txtRg = new TextField();
	private Label lblEspecialista = new Label("Especialista");
	private TextField txtEspecialista = new TextField();
	private Label lblNumCRO = new Label("Número C.R.O");
	private TextField txtNumCRO = new TextField();
	private ToggleGroup tgSexo = new ToggleGroup();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnNovo = new Button("Novo");
	private Button btnCancelar = new Button("Cancelar");

	private TableView<Doutor> tabelaDoutor = new TableView<>();
	private RadioButton sexoSelecionado;
	private DoutorControl doutorControl = new DoutorControl();
	
	@Override
	public Pane gerarBoundary() {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		TilePane painelBotao = new TilePane();
		
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(painelBotao);
	
		rbSexoFem.setToggleGroup(tgSexo);
		rbSexoMasc.setToggleGroup(tgSexo);
		painelCampos.add(lblId, 0, 0);
		painelCampos.add(txtId, 1, 0);
		txtId.setDisable(true);
		painelCampos.add(lblNome, 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(lblCpf, 0, 2);
		painelCampos.add(txtCpf, 1, 2);
		painelCampos.add(lblRg, 0, 3);
		painelCampos.add(txtRg, 1, 3);
		painelCampos.add(lblSexo, 0, 4);
		painelCampos.add(rbSexoMasc, 1, 4);
		painelCampos.add(rbSexoFem, 2, 4);
		painelCampos.add(lblDataNasc, 0, 5);
		painelCampos.add(dpDataNasc, 1, 5);
		painelCampos.add(lblEndereco, 0, 6);
		painelCampos.add(txtEndereco, 1, 6);
		painelCampos.add(lblTelefone, 0, 7);
		painelCampos.add(txtTelefone, 1, 7);
		painelCampos.add(lblEspecialista, 0, 8);
		painelCampos.add(txtEspecialista, 1, 8);
		painelCampos.add(lblNumCRO, 0, 9);
		painelCampos.add(txtNumCRO, 1, 9);
		
		btnNovo.setPrefWidth(80);
		btnAdicionar.setPrefWidth(80);
		btnPesquisar.setPrefWidth(80);
		btnCancelar.setPrefWidth(80);
		painelBotao.getChildren().addAll(btnNovo,btnAdicionar,btnPesquisar,btnCancelar);
		painelPrincipal.setBottom(tabelaDoutor);
	
		TableColumn<Doutor, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Doutor, Long>("id"));
		TableColumn<Doutor, String> colNome = new TableColumn<Doutor, String>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Doutor, String>("nome"));
		TableColumn<Doutor, String> colCpf = new TableColumn<Doutor, String>("CPF");
		colCpf.setCellValueFactory(new PropertyValueFactory<Doutor, String>("cpf"));
		TableColumn<Doutor, String> colRg = new TableColumn<Doutor, String>("RG");
		colRg.setCellValueFactory(new PropertyValueFactory<Doutor, String>("rg"));
		TableColumn<Doutor, String> colTelefone = new TableColumn<Doutor, String>("Telefone");
		colTelefone.setCellValueFactory(new PropertyValueFactory<Doutor, String>("telefone"));
		TableColumn<Doutor, Date> colDataNasc = new TableColumn<Doutor, Date>("Data Nasc.");
		colDataNasc.setCellValueFactory(new PropertyValueFactory<Doutor, Date>("dataNasc"));
		TableColumn<Doutor, String> colSexo = new TableColumn<Doutor, String>("Sexo");
		colSexo.setCellValueFactory(new PropertyValueFactory<Doutor, String>("sexo"));
		TableColumn<Doutor, String> colEndereco = new TableColumn<Doutor, String>("Endereço");
		colEndereco.setCellValueFactory(new PropertyValueFactory<Doutor, String>("endereco"));
		TableColumn<Doutor, String> colEspecialidade = new TableColumn<Doutor, String>("Especialidade");
		colEspecialidade.setCellValueFactory(new PropertyValueFactory<Doutor, String>("especialidade"));
		TableColumn<Doutor, Long> colNumeroCro = new TableColumn<Doutor, Long>("Número CRO");
		colNumeroCro.setCellValueFactory(new PropertyValueFactory<Doutor, Long>("numeroCro"));
		
		tabelaDoutor.getColumns().addAll(colId,colNome,colSexo,colRg,colCpf,colDataNasc,colNumeroCro,
									colEspecialidade,colTelefone,colEndereco);
		
		tabelaDoutor.setItems(doutorControl.getListaDoutor());
		
		tabelaDoutor.getSelectionModel().selectedItemProperty()
							.addListener(new ChangeListener<Doutor>() {
			@Override
			public void changed(ObservableValue<? extends Doutor> observable,
					Doutor oldValue,
					Doutor newValue) {
				doDoutorParaFormulario(newValue);
				
			}
		});
		
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Doutor d = doFormularioParaDoutor();
				doutorControl.adicionarDoutor(d);
				limparFormulario();
				btnPesquisar.setDisable(false);
				btnNovo.setDisable(false);
				
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Confirmação");
				a.setHeaderText("Cadastro adicionado com sucesso!");
				a.showAndWait();
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
		
		btnPesquisar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				List<Doutor> lista = 
						doutorControl.pesquisarPorNome(txtNome.getText());
				System.out.println(lista.size());
				if(lista.size() > 0) {
					doDoutorParaFormulario(lista.get(0));
				}
				btnAdicionar.setDisable(true);
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
	
		
		btnNovo.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				limparFormulario();	
				btnAdicionar.setDisable(false);
				btnPesquisar.setDisable(true);
				btnNovo.setDisable(true);
			
			}
			
		});
		
		
		return painelPrincipal;
	}
	
	
	public Doutor doFormularioParaDoutor() {
		Doutor d = new Doutor();
		sexoSelecionado = (RadioButton) tgSexo.getSelectedToggle();
		
		d.setNome(txtNome.getText());
		d.setCpf(txtCpf.getText());
		d.setRg(txtRg.getText());
		d.setSexo(sexoSelecionado.getText());
		d.setTelefone(txtTelefone.getText());
		d.setEndereco(txtEndereco.getText());
		d.setEspecialidade(txtEspecialista.getText());
		d.setNumeroCro(Long.parseLong(txtNumCRO.getText()));
		LocalDate ld = dpDataNasc.getValue();
		Date data = Date.from(
				ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		d.setDataNasc(data);
		return d;
		
	}
	
	public void doDoutorParaFormulario(Doutor d) {
		txtId.setText(String.valueOf(d.getId()));
		txtNome.setText(d.getNome());
		txtCpf.setText(d.getCpf());
		txtRg.setText(d.getRg());
		if(d.getSexo().equals(rbSexoFem.getText())){
			rbSexoFem.setSelected(true);
		}else {
			rbSexoMasc.setSelected(true);
		}
		txtEndereco.setText(d.getEndereco());
		txtTelefone.setText(d.getTelefone());
		txtEspecialista.setText(d.getEspecialidade());
		txtNumCRO.setText(String.valueOf(d.getNumeroCro()));
		LocalDate localDate = d.getDataNasc()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		dpDataNasc.setValue(localDate);
		
	}
	
	public void limparFormulario() {
		txtId.setText("");
		txtNome.setText("");
		txtRg.setText("");
		txtCpf.setText("");
		txtNumCRO.setText("");
		txtEspecialista.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		rbSexoFem.setSelected(false);
		rbSexoMasc.setSelected(false);
		dpDataNasc.setValue(null);

		
	}

	

}
