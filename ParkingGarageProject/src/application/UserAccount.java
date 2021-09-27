package application;

import java.util.HashMap;

public class UserAccount {
	private String username;
	private String password;
	
	private static UserAccount currentUser = null;
	
	private static HashMap<String, UserAccount> userData = new HashMap<>();
	
	
	public UserAccount() {
		
	}
	
	public String getUsername() {
		return this.username;
	}
	
	private String getPassword() {
		return this.password;
	}
	
	private void setUsername(String username) {
		this.username = username;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchesCredentials(String username, String password) {
		if (this.getUsername().equalsIgnoreCase(username) && this.getPassword().equals(password))
			return true;
		return false;
	}
	
	
	public static boolean createAttendant(String username, String password) {
		if (userData.containsKey(username))
			return false;
		UserAccount attendant = new UserAccount();
		attendant.setUsername(username);
		attendant.setPassword(password);
		
		userData.put(attendant.getUsername(), attendant);
		return true;
	}
	
	public static boolean deleteAttendant(String username) {
		if (!userData.containsKey(username))
			return false;
		userData.remove(username);
		return true;
	}
	
	public static HashMap<String, UserAccount> getUserData() {
		return userData;
	}
	
	public static UserAccount getUser(String username) {
		return userData.get(username);
	}
	
	public static void terminate() {
		UserAccount.userData.clear();
		UserAccount.userData = null;
	}
	
	public static UserAccount getCurrentUserAccount() {
		return currentUser;
	}
	
	public static void setCurrentUserAccount(UserAccount userAccount) {
		UserAccount.currentUser = userAccount;
	}

}
