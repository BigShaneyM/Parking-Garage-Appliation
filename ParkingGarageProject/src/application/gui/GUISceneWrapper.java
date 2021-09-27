package application.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GUISceneWrapper {

	private GUISceneType sceneType;
	private Scene scene;
	
	public GUISceneWrapper(GUISceneType sceneType) {
		this.sceneType = sceneType;
		this.initScene();
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	public GUISceneType getSceneType() {
		return this.sceneType;
	}
	
	public void setSceneStyleSheet(String fileResourceLocation) {
		this.scene.getStylesheets().add(this.getClass().getResource(fileResourceLocation).toExternalForm());
	}
	
	private void initScene() {
		try {
			Parent root = (Parent) FXMLLoader.load(this.getClass().getResource(this.sceneType.getFXMLLocation()));
			this.scene = new Scene(root, GUIManager.GUI_WINDOW_WIDTH, GUIManager.GUI_WINDOW_HEIGHT);
		} catch (IOException e) {
			System.out.println("Problem initiating scene for " + this.getSceneType().name() + "!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
