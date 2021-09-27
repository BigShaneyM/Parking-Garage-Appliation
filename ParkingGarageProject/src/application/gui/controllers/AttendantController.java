package application.gui.controllers;

import application.Main;
import application.UserAccount;
import application.gui.GUISceneType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AttendantController {

	@FXML
	private Button enterVehicleButton;
	@FXML
	private Button exitVehicleButton;
	@FXML
	private Button invoicesButton;
	@FXML
	private Button parkingSpotsButton;
	@FXML
	private Button logoutButton;
	@FXML
	private ListView<String> transactionList;
	@FXML
	private Label currentUserLabel;
	
	
	@FXML
	private void logout() {
		Main.getGUIManager().setScene(GUISceneType.LOGIN_SCENE);
	}
	
	@FXML
	public void enterNewVehicleInformation() {
		
	}
	
	@FXML
	public void processExistingVehicleInformation() {
		
	}
	
	@FXML
	public void onOpen() {
		this.currentUserLabel.setText(UserAccount.getCurrentUserAccount().getUsername());
	}

}
