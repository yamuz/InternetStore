package utils.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop;

    public static Properties getSettings() throws IOException {
        if (prop == null){
            loadProperties();
        }
        return prop;
    }

    private static void loadProperties(){
        prop = new Properties();
        URL url = PropertyReader.class.getClassLoader().getResource("settings.properties");
        try(InputStream inputStream =  new FileInputStream(url.getFile())){
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isSQLDB(){
        if (prop == null){
            loadProperties();
        }
        return  prop.getProperty("has_sql_db", "false").equals("true");
    }
}
