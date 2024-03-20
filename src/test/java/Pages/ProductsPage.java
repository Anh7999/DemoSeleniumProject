package Pages;

import Utils.PropertiesFileUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.*;

public class ProductsPage {
    public static String formalShoesTitleXpath = PropertiesFileUtils.getProperty("formalShoesTitleXpath");
    public static String sportShoesTitleXpath = PropertiesFileUtils.getProperty("sportShoesTitleXpath");
    public static String sneakerTitleXpath = PropertiesFileUtils.getProperty("sneakerTitleXpath");
    public static String formalShoes_dropdown_xpath = PropertiesFileUtils.getProperty("formalShoes_dropdown_xpath");
    public static String sportShoes_dropdown_xpath = PropertiesFileUtils.getProperty("sportShoes_dropdown_xpath");
    public static String sneakers_dropdown_xpath = PropertiesFileUtils.getProperty("sneakers_dropdown_xpath");

    public static String formalShoes_table_fistsname = PropertiesFileUtils.getProperty("formalShoes_table_fist_shoe_name");
    public static String sportshoes_table_fistname = PropertiesFileUtils.getProperty("sportshoes_table_fistnamee");
    public static String sneaker_table_firstname = PropertiesFileUtils.getProperty("sneaker_table_firstname");


    public static void formalShoes_verifyTitle() throws IOException {
        String expectedTitleFS = "Formal Shoess";
        String actualTitleFS = driver.findElement(By.xpath(formalShoesTitleXpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);
        if(expectedTitleFS.equals(actualTitleFS)){
            test.log(Status.PASS,"test pass for title formal shoes validation");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Pass");
        }else if(false) {
//            test.log(Status.FAIL,"test fail for title formal shoes validation");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
        System.out.println("formalShoes_verifyTitle :"+expectedTitleFS+" "+actualTitleFS);

    }

    public static void sportShoes_verifyTitle() {
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportShoesTitleXpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if(expectedTitleSS.equals(actualTitleSS)){
            test.log(Status.PASS,"test pass for title sport shoes validation");
        }

    }

    public static void sneakers_verifyTitle() {
        String expectedTitleSN = "Sneakers";
        String actualTitleSN = driver.findElement(By.xpath(sneakerTitleXpath)).getText();
        Assert.assertEquals(expectedTitleSN, actualTitleSN);
        if(expectedTitleSN.equals(actualTitleSN)){
            test.log(Status.PASS,"test pass for title sneaker validation");
        }
    }

    public static void formalShoes_firstShoes_validate() {
        driver.findElement(By.xpath(formalShoes_dropdown_xpath)).click();
        String actualFirstShoe = driver.findElement(By.xpath(formalShoes_table_fistsname)).getText();
        String expectedFirstShoes = "   Classic Cheltenham";
        Assert.assertEquals(actualFirstShoe,expectedFirstShoes);
        if(actualFirstShoe.equals(expectedFirstShoes)){
            test.log(Status.PASS,"test pass for fist shoe");
        }
    }

    public static void sportShoes_firstshoes_validate() {
        driver.findElement(By.xpath(sportShoes_dropdown_xpath)).click();

        String actualFirstShoe = driver.findElement(By.xpath(sportshoes_table_fistname)).getText();
        String expectedFirstShoes = "   Ultimate";
        Assert.assertEquals(actualFirstShoe,expectedFirstShoes);
        if(actualFirstShoe.equals(expectedFirstShoes)){
            test.log(Status.PASS,"test pass for fist sport shoe");
        }
    }

    public static void sneakers_firstname_validate() {
        driver.findElement(By.xpath(sneakers_dropdown_xpath)).click();
        String actualFirstSneaker= driver.findElement(By.xpath(sneaker_table_firstname)).getText();
        String expectedFirstSneaker = "   Archivo";
        Assert.assertEquals(actualFirstSneaker,expectedFirstSneaker);
        if(actualFirstSneaker.equals(expectedFirstSneaker)){
            test.log(Status.PASS,"test pass for sneaker");
        }
    }

    public static void formalshoes_fistname_getTitle() {
        driver.findElement(By.xpath(formalShoes_table_fistsname)).getText();
    }

    public static void spokeshoes_fistname_getTitle() {
        driver.findElement(By.xpath(sportshoes_table_fistname)).getText();
    }

    public static void sneaker_fistname_getTitle() {
        driver.findElement(By.xpath(sneaker_table_firstname)).getText();
    }
}
