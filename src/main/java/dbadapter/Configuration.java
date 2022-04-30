package dbadapter;

public class Configuration {

	private static final String SERVER = "localhost";
	private static final String TYPE = "mysql";
	private static final int PORT = 3306;
	private static final String DATABASE = "mrapp";
	private static final String USER = "root";
	private static final String PASSWORD = "Steven123.";
	public static String getServer() {
		return SERVER;
	}
	public static String getType() {
		return TYPE;
	}
	public static int getPort() {
		return PORT;
	}
	public static String getDatabase() {
		return DATABASE;
	}
	public static String getUser() {
		return USER;
	}
	public static String getPassword() {
		return PASSWORD;
	}
	
	
	
	
}
