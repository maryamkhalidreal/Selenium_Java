package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	File file = new File("src/test/resources/config.properties");
	FileInputStream fileInput;
	Properties prop;
	public ConfigReader() {
		try {
			fileInput= new FileInputStream(file);
			prop= new Properties();
			prop.load(fileInput);
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
	}
	
	public String getPropertyByName(String name) {
		System.out.println(prop.getProperty(name));
		return prop.getProperty(name);
	}
}
