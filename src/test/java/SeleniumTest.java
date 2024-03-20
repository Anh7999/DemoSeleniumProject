import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;


    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());


    }


    void TestStep() {

        WebElement checkboxElm = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkboxElm.click();

        WebElement siginButonElm = driver.findElement(By.xpath("//li[normalize-space()='Sign In Portal']"));
        siginButonElm.click();

        WebElement userInputElm = driver.findElement(By.xpath("//input[@id='usr']"));
        userInputElm.sendKeys("sa");

        WebElement passInoutElm = driver.findElement(By.xpath("//input[@id='pwd']"));
        passInoutElm.sendKeys("sa");

        WebElement loginButtonElm = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButtonElm.click();

        WebElement shoeCategoryElm = driver.findElement(By.xpath("//div[@id='SmokeTests']//h3[@id='ShoeType']"));
        String expectFistCateory = "Formal Shoes";
        String actualFirstCategory = shoeCategoryElm.getText();
        Assert.assertEquals(expectFistCateory,actualFirstCategory);
        System.out.println(actualFirstCategory);

    }


    void close() {
        driver.close();
    }
}
