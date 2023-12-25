package filereader;

import logger.LoggingManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    public Properties properties;

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public String fileName;

    public PropertyFileReader(String fileName){
        this.fileName = fileName;
        loadProperty();
    }

    public void loadProperty() {
        try(InputStream is = new FileInputStream(fileName)){
            properties = new Properties();
            properties.load(is);
        } catch (IOException e){
            LoggingManager.logger.info(e);
        }
    }
}
