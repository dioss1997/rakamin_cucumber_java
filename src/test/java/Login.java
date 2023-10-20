import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    @Test //tag untuk running script dibawah ini
    public void open_browser(){
        WebDriver driver; // set driver for test using webdriver from selenium
        String baseURL = "https://kasirdemo.belajarqa.com/"; //set baseURL

        WebDriverManager.chromedriver().setup(); // setup chrome driver automatically using web driver manager
        ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using headless mode

        // apply chrome driver setup
        driver = new ChromeDriver(opt); // apply chrome driver setup to driver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseURL); // access baseURL
        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
    }

    @Test //tag untuk running script dibawah ini
    public void get_title(){
        WebDriver driver; // set driver for test using webdriver from selenium
        String baseURL = "https://kasirdemo.belajarqa.com/"; //set baseURL

        WebDriverManager.chromedriver().setup(); // setup chrome driver automatically using web driver manager
        ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using headless mode

        // apply chrome driver setup
        driver = new ChromeDriver(opt); // apply chrome driver setup to driver
        driver.manage().window().maximize(); // maximize window
        driver.get(baseURL); // access baseURL
        String title = driver.getTitle();
        System.out.println(title);

        String username_button = "Username";

        // get form
        WebElement ele1 = driver.findElement(By.id(username_button));
        ele1.click();
        ele1.sendKeys("email.com");
        ele1.getText();

        WebElement ele2 = driver.findElement(By.className("button"));
        ele2.isDisplayed();
        ele2.click();

        driver.findElement(By.xpath("/*contains")).isDisplayed();
        driver.findElement(By.cssSelector("#button")).isDisplayed();

        driver.close();
    }
}
