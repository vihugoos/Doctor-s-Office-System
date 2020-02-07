package Boundary;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import Controler.UsuarioControl;
import Entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BoundaryUsuario implements BoundaryConteudo{
	
	private Label lblId = new Label("Id");
	private TextField txtId = new TextField();
	private Label lblNome = new Label("Nome");
	private TextField txtNome = new TextField();
	private Label lblCpf = new Label("CPF");
	private TextField txtCpf = new TextField();
	private Label lblRg = new Label("RG");
	private TextField txtRg = new TextField();
	private Label lblSexo = new Label("Sexo");
	private RadioButton rbSexoMasc = new RadioButton("Masculino");
	private RadioButton rbSexoFem = new RadioButton("Feminino");
	private Label lblDataNasc = new Label("Data Nasc.");
	private DatePicker dpDataNasc = new DatePicker();
	private Label lblEndereco = new Label("Endereço");
	private TextField txtEndereco = new TextField();
	private Label lblTelefone = new Label("Telefone");
	private TextField txtTelefone = new TextField();
	private Label lblLogin = new Label("Usuario Login");
	private TextField txtLogin = new TextField();
	private Label lblSenha = new Label("Senha");
	private PasswordField psfSenha = new PasswordField();
	private Label lblConfSenha = new Label("Confirmar senha");
	private PasswordField psfConfSenha = new PasswordField();
	private Label lblExSenha = new Label(" Obs: Senha com 8 digitos (apena números)");
	private ToggleGroup tgSexo = new ToggleGroup();
	private Button btnAdicionar = new Button("Adicionar");
	
	private RadioButton sexoSelecionado;
	private UsuarioControl usuarioControl = new UsuarioControl();

	@Override
	public Pane gerarBoundary() {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		
		painelPrincipal.setCenter(painelCampos);
	
		rbSexoFem.setToggleGroup(tgSexo);
		rbSexoMasc.setToggleGroup(tgSexo);
		painelCampos.add(lblId, 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(lblNome, 0, 1);
		painelCampos.add(txtNome, 1, 1);
		painelCampos.add(lblSexo, 0, 2);
		painelCampos.add(rbSexoMasc, 1, 2);
		painelCampos.add(rbSexoFem, 2, 2);		
		painelCampos.add(lblCpf, 0, 3);
		painelCampos.add(txtCpf, 1, 3);
		painelCampos.add(lblRg, 0, 4);
		painelCampos.add(txtRg, 1, 4);	
		painelCampos.add(lblDataNasc, 0, 5);
		painelCampos.add(dpDataNasc, 1, 5);
		painelCampos.add(lblEndereco, 0, 6);
		painelCampos.add(txtEndereco, 1, 6);
		painelCampos.add(lblTelefone, 0, 7);
		painelCampos.add(txtTelefone, 1, 7);		
		painelCampos.add(lblLogin, 0, 8);
		painelCampos.add(txtLogin, 1, 8);
		painelCampos.add(lblSenha, 0, 9);
		painelCampos.add(psfSenha, 1, 9);
		painelCampos.add(lblExSenha, 2, 9);
		painelCampos.add(lblConfSenha, 0, 10);
		painelCampos.add(psfConfSenha, 1, 10);
		painelCampos.add(btnAdicionar, 0, 11);
	
		btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			if(psfSenha.getText().equals(psfConfSenha.getText())) {
					Usuario u = doFormularioParaUsuario();
					usuarioControl.adicionarUsuario(u);
				}else {
					System.out.println("Senha não confere");
				}
				
			}
			
		});
		
		return painelPrincipal;
	}
	
	public Usuario doFormularioParaUsuario() {
		Usuario u = new Usuario();
		sexoSelecionado = (RadioButton) tgSexo.getSelectedToggle();
		u.setNome(txtNome.getText());
		u.setSexo(sexoSelecionado.getText());
		u.setRg(txtRg.getText());
		u.setCpf(txtCpf.getText());
		LocalDate ld = dpDataNasc.getValue();
		Date data = Date.from(
				ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		u.setDataNasc(data);
		u.setEndereco(txtEndereco.getText());
		u.setTelefone(txtTelefone.getText());
		u.setNomeUsuario(txtLogin.getText());
		u.setSenha(Integer.parseInt(psfSenha.getText()));
		
		return u;
	}

}
