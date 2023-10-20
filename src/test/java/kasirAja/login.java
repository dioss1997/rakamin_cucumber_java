package kasirAja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    @Test
    public void success_login_case(){
        WebDriver driver; // set driver for test using webdriver from selenium
        String baseURL = "https://kasirdemo.belajarqa.com/"; //set baseURL

        WebDriverManager.chromedriver().setup(); // setup chrome driver automatically using web driver manager
        //ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        //opt.setHeadless(false); // set chrome driver to not using headless mode

        // apply chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver(); // apply chrome driver setup to driver
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL); // access baseURL
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
        //input email
        driver.findElement(By.id("email")).sendKeys("toko@untungterus.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("Untungterus77");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert nama toko di dashboard page
        String namaToko = driver.findElement(By.xpath("//h3[contains(text(),'kasirAja')]")).getText();
        Assert.assertEquals(namaToko,"kasirAja");

        //quit
        driver.close();
    }


    @Test
    public void failed_login_case(){
        WebDriver driver; // set driver for test using webdriver from selenium
        String baseURL = "https://kasirdemo.belajarqa.com/"; //set baseURL

        WebDriverManager.chromedriver().setup(); // setup chrome driver automatically using web driver manager
        //ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        //opt.setHeadless(false); // set chrome driver to not using headless mode

        // apply chrome driver setup
        //membuka halaman login
        driver = new ChromeDriver(); // apply chrome driver setup to driver
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL); // access baseURL
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
        //input email
        driver.findElement(By.id("email")).sendKeys("toko@untungterus.com");
        //input password yang salah
        driver.findElement(By.id("password")).sendKeys("Untungterus7777");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin,"Kredensial yang Anda berikan salah");

        driver.close();
    }
}
