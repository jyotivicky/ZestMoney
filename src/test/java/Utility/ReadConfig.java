package request_Utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.File;

  public class ReadConfig {
	static Properties Pro;
	public ReadConfig() {
		File src                                        = new File("Config_File\\Config.properties");
		String path                                     = src.getAbsolutePath();
		try {
			FileInputStream fis                         = new FileInputStream(src);
			Pro                                         = new Properties();
			Pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception Is : " + e.getMessage());
		}
	}

	public static String getPropertyValue(String str) {
		String getValue                                      = Pro.getProperty(str);
		return getValue;
	}
   }










