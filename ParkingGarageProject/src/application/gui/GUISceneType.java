package application.gui;

public enum GUISceneType {
	
	LOGIN_SCENE(0, "LoginPage.fxml"),
	ADMIN_SCENE(1, "AdminView.fxml"),
	ATTENDANT_SCENE(2, "AttendantView.fxml");
	
	
	private int id;
	private String location;
	
	private GUISceneType(int id, String location) {
		this.id = id;
		this.location = location;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getFXMLLocation() {
		return "controllers/" + this.location;
	}

}
