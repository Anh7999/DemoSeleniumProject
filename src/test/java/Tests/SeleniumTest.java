package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import Utils.PropertiesFileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static WebDriver driver;

    public static ExtentReports reports;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PropertiesFileUtils.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        HomePage.clickHamburgerMenu();
        HomePage.clickOnlineProduct();
    }

    public static String capture(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/"+System.currentTimeMillis()+".png");
        String errfpath=Dest.getAbsolutePath();
        FileUtils.copyFile(srcFile,Dest);
        return errfpath;
    }

    @Test
    public void validateTitleOnlineProduct() throws IOException {
        test = extent.createTest("Validate Shoe Title On Product Page", "This test i validates that the different shoes types are correct on Online Product Page");
        ProductsPage.sportShoes_verifyTitle();
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();

    }

    @Test
    public void validateFistFormalShoes() {
        test = extent.createTest("Validate First Shoe On Product Page", "Validate first shoe in table shoe");
        ProductsPage.formalShoes_firstShoes_validate();


    }

    @Test
    public void validateFistSpokeShoes() {
        test = extent.createTest("Validate First Spoke Shoe On Product Page", "Validate first spoke shoe in table shoe");
        ProductsPage.sportShoes_firstshoes_validate();
    }

    @Test
    public void validateFistSneaker() {
        ProductsPage.sneakers_firstname_validate();
    }

    @AfterSuite
    void close() {
        extent.flush();
        driver.close();
    }
}
