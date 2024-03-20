package Pages;

import Utils.PropertiesFileUtils;
import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String hamburgerMenuXpath = PropertiesFileUtils.getProperty("hamburgerMenuButton");
    public static String onlineProductXpath = PropertiesFileUtils.getProperty("onlineProductButton");

    public static void clickHamburgerMenu(){
        driver.findElement(By.xpath(hamburgerMenuXpath)).click();
    }

    public static void  clickOnlineProduct(){
        driver.findElement(By.xpath(onlineProductXpath)).click();
    }
}
