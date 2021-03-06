package properties;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class App3 {
	
	public static void main( String[] args ){

		Properties prop = new Properties();
		InputStream input = null;
	
		try {
	
			String filename = "configuration.properties";
			input = App3.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
		            System.out.println("Sorry, unable to find " + filename);
			    return;
			}
	
			//load a properties file from class path, inside static method
			prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("email"));
	        System.out.println(prop.getProperty("sms"));
	        System.out.println(prop.getProperty("voice"));
	        
	        Enumeration<?> e = prop.propertyNames();
	        while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
	    }
	}
}
