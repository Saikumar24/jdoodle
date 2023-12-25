package filepath;

import java.io.File;

public class FilePath {

    public static String getConfigPath(){
        return System.getProperty("user.dir").concat(File.separator).concat("src"+File.separator+"main"+File.separator+"resources"+File.separator+ "Config" +File.separator);
    }
}
