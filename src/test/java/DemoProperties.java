import Utils.PropertiesFileUtils;
import org.testng.annotations.Test;

public class DemoProperties {
    @Test
    public void printText(){
        String name = PropertiesFileUtils.getProperty("name");
        System.out.println(name);
    }
}
