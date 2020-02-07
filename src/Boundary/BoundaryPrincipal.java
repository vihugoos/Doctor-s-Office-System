package Boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BoundaryPrincipal extends Application{
	
	private MenuBar mnuBar = new MenuBar();
	private Menu mnuArquivo = new Menu ("Arquivo");
	private Menu mnuCadastro = new Menu("Cadastro");
	private MenuItem mnuDoutor = new MenuItem("Doutor");
	private MenuItem mnuPaciente = new MenuItem("Paciente");
	private MenuItem mnuUsuario = new MenuItem("Usuario");
	private MenuItem mnuAgenda = new MenuItem("Agenda"); 
	@Override
	public void start(Stage stage) {
		BorderPane painel = new BorderPane();
		Scene scn = new Scene(painel,1000,600);
		
		mnuCadastro.getItems().addAll(mnuDoutor,mnuPaciente,mnuUsuario,mnuAgenda);
		mnuBar.getMenus().addAll(mnuArquivo,mnuCadastro);
		
		painel.setTop(mnuBar);
		
		mnuDoutor.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				painel.setCenter(new BoundaryDoutor().gerarBoundary());
			}
		});
		
		mnuPaciente.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				painel.setCenter(new BoundaryPaciente().gerarBoundary());
				
			}
			
		});
		
		mnuUsuario.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				painel.setCenter(new BoundaryUsuario().gerarBoundary());
				
			}
			
		});
		
		mnuAgenda.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				painel.setCenter(new BoundaryAgenda().gerarBoundary());
				
			}
			
		});
		
	
		
		
		stage.setTitle("Sistema Consultório");
		stage.setScene(scn);
		stage.show();
	}

	public static void main(String[] args) {
		launch(BoundaryPrincipal.class,args);
	}
}
