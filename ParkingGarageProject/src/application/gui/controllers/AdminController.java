package application.gui.controllers;

import application.Main;
import application.UserAccount;
import application.gui.GUISceneType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AdminController {
	
	@FXML
	private TextField createUser;
	@FXML
	private TextField createPass;
	@FXML
	private TextField deleteUser;
	@FXML
	private Button createUserButton;
	@FXML
	private Button deleteUserButton;
	@FXML
	private Button logoutButton;
	@FXML
	private ListView<String> userListView;

	
	
	@FXML
	public void logout() {
		Main.getGUIManager().setScene(GUISceneType.LOGIN_SCENE);
	}
	
	@FXML
	public void createUser() {
		if (this.createUser.getText() != null && this.createPass.getText() != null) {
			String username = this.createUser.getText();
			String password = this.createPass.getText();
			
			if (UserAccount.createAttendant(username, password)) {
				this.userListView.getItems().add(username);
			}
		}
	}
	
	@FXML
	public void deleteUser() {
		if (this.deleteUser.getText() != null) {
			String username = this.deleteUser.getText();
			if (UserAccount.deleteAttendant(username))
				this.userListView.getItems().remove(username);
		}
	}
	
}
