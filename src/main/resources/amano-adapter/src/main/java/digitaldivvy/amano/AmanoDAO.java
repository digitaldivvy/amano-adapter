package digitaldivvy.amano;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * The trigger will read the DB.
 *
 */
class AmanoDAO {

	/**
	 * Cache the configuration on class load
	 */
	
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private	String url;
    private String userName;
    private String password;
    private InputStream input;
    private static Properties prop= new Properties();
    private static String CONFIG_FILE="config.properties";
    
	
	public AmanoDAO(){
	    try{
	    	input=AmanoDAO.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            
            prop.load(input);
            url=prop.getProperty("url")+";databaseName=pidcodb";
            userName=prop.getProperty("userName");
            password=prop.getProperty("password");
    		System.out.println("userName: "+userName);
    		System.out.println("password: "+password);
    		System.out.println("url: "+url);
    		

        }catch(Exception e)
        {
            System.err.println("Exception in initialization.");
        	System.err.println(e);
        	System.exit(1);//exit the system.
        }
	}
	
}
