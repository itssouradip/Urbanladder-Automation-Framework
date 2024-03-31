package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public Properties property;
	
	public void propertyReader() throws IOException {
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		property = new Properties();
		property.load(file);
	}
	
	public String readProperty(String propertyName) {
		String propertyDetails = property.getProperty(propertyName);
		return propertyDetails;
	}
}
