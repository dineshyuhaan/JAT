package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {

    public Properties properties;

    public ConfigProperty() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Dinesh\\eclipse-workspace\\Ecommerce\\src\\test\\java\\utils\\config.properties");
        properties = new Properties();
        properties.load(fis);
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}
