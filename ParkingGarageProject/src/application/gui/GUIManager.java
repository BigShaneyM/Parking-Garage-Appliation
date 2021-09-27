package application.gui;

import java.util.HashMap;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIManager {
	
	public static final int GUI_WINDOW_WIDTH = 960;
	public static final int GUI_WINDOW_HEIGHT = 720;
	
	private Stage primaryStage;
	
	private HashMap<GUISceneType, GUISceneWrapper> sceneWrappers;
	
	public GUIManager(Stage pStage) {
		this.primaryStage = pStage;
		int sceneListLength = GUISceneType.values().length;
		this.sceneWrappers = new HashMap<>(sceneListLength);
		this.initialize();
		
		//Set up first scene as login page.
		this.setScene(GUISceneType.LOGIN_SCENE);
		this.primaryStage.show();
	}
	
	private void initialize() {
		for (GUISceneType sceneType : GUISceneType.values()) {
			sceneWrappers.put(sceneType, new GUISceneWrapper(sceneType));
		}
		
		//Set the primary stage options
		this.primaryStage.initStyle(StageStyle.DECORATED);
		this.primaryStage.setAlwaysOnTop(true);
		this.primaryStage.setResizable(true);
		primaryStage.setTitle("PARKING GARAGE SYSTEMS");
	}
	
	public GUISceneWrapper getSceneWrapper(GUISceneType sceneType) {
		return null;
	}
	
	public void setScene(GUISceneType sceneType) {
		GUISceneWrapper sceneWrapper = this.sceneWrappers.get(sceneType);
		this.primaryStage.setScene(sceneWrapper.getScene());
	}
	
	public void close() {
		this.primaryStage.close();
	}
	

}
