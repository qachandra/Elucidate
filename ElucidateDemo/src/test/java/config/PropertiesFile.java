package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.TC_Page1ValidationTest;



public class PropertiesFile {
	static Properties prop = new Properties();
	static String projpath = System.getProperty("user.dir");
	static TC_Page1ValidationTest cpage1=new TC_Page1ValidationTest();

	public void getProperties() {
		try {

			InputStream input = new FileInputStream(projpath + "/src/test/java/config/config.properties");
			prop.load(input);
			String broswer = prop.getProperty("browser");
			System.out.println("Browser : "+broswer);
			cpage1.browserName=broswer;
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
	}

	public static void setBrowserProperties(String browser) {
		try {
			OutputStream output = new FileOutputStream(projpath + "/src/test/java/config/config.properties");
			prop.setProperty("browser", browser);
			prop.store(output, null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
	}
}
