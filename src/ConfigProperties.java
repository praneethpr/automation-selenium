import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	public Properties getProperties(Properties prop) {
		
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");
			
			//load a properties file
			prop.load(input);
			
			return prop;
			} catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (input != null) {
		            try {
		                input.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		
		return null;
	}
}
