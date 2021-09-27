package application.gui.controllers;

import application.Main;
import application.UserAccount;
import application.gui.GUISceneType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private Button loginButton;
	@FXML
	private Label lognFailedLabel;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	
	private boolean isAdmin = false;
	
	
	
	@FXML
	public void loginButtonClicked() {
		if (checkAuthentication() ) {
			//Success
			if (this.isAdmin)
			{
				this.isAdmin = false;
				Main.getGUIManager().setScene(GUISceneType.ADMIN_SCENE);
			} else {
				//Display Attendant view
				Main.getGUIManager().setScene(GUISceneType.ATTENDANT_SCENE);
			}
		} else {
			//Fail
			//Toggle the login failed label.
			this.lognFailedLabel.setVisible(true);
		}
		//Clear both text fields
		this.clearFields();
	}
	
	@FXML
	private void clearFields() {
		this.usernameField.clear();
		this.passwordField.clear();
	}
	
	/**
	 * Method for when a user clicks on the text-field and sets it as a focus.
	 * Is used by usernameField & passwordField.
	 */
	@FXML
	public void textFieldInFocus() {
		//Since the text-field is in focus, set login failed label visibility to false.
		this.lognFailedLabel.setVisible(false);
	}
	
	/*
	 * Method defined to check the authenticity of the login credentials.
	 */
	@FXML
	private boolean checkAuthentication() {
		
		if (usernameField == null || passwordField == null)
			return false;
		
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		//Check if user is administrator
		if (username.equals("admin") && password.equals("password")) {
			this.isAdmin = true;
			return true;
		}
		else {
			
			UserAccount user = UserAccount.getUser(username);
			if (user == null)
				return false;
			
			if (!user.matchesCredentials(username, password))
				return false;
			
			UserAccount.setCurrentUserAccount(user);
			return true;
		}
	}

}
