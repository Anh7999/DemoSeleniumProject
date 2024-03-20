package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
    private static String CONFIG_PATH_PROPERTIES = System.getProperty("user.dir") + "\\src\\test\\java\\Datatest.properties";


    //  Lấy ra giá trị property bất kỳ theo key.
    public static String getProperty(String key) {
        Properties properties = new Properties();
        String value = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(CONFIG_PATH_PROPERTIES);
            properties.load(fileInputStream);
            value = properties.getProperty(key);
            return value;

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("Xảy ra lỗi khi đọc giá trị của  " + key);
            ex.printStackTrace();

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;

    }
}
