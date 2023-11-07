package property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {
    private static String url, validUsername, validPassword, invalidUsername, invalidPassword;
    private static String propertyFilePath = "src/main/resources/property.properties";
    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadDate();
        }
        System.out.println(instance);
        return instance;
    }
    private void loadDate(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        url = properties.getProperty("url");
        validUsername = properties.getProperty("validUsername");
        validPassword = properties.getProperty("validPassword");
        invalidUsername = properties.getProperty("invalidUsername");
        invalidPassword = properties.getProperty("invalidPassword");
    }
    public static void changeProperty(String key, String newValue){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(fileInputStream);
            properties.setProperty(key, newValue);
            properties.store(new FileOutputStream(propertyFilePath), null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        instance = null;
    }

    public String getUrl() {
        return url;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }
}
