package application;
	
import application.gui.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	private static GUIManager guiManager;
	
	@Override
	public void start(Stage primaryStage) {
		guiManager = new GUIManager(primaryStage);
		
	}
	
	
	
	@Override
	public void stop() throws Exception {
		super.stop();
		
		guiManager.close();
		UserAccount.terminate();
	}



	public static void main(String[] args) {
		
		long first = System.currentTimeMillis();
		
		launch(args);
		
		long second = System.currentTimeMillis();
		String timeStamp = Utilities.getTimeStamp(second, first);
		System.out.println(timeStamp);
	}
	
	public static GUIManager getGUIManager() {
		return guiManager;
	}
}
