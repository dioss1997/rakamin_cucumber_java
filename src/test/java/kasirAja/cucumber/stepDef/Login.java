package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver; // set driver for test using webdriver from selenium
    String baseURL = "https://kasirdemo.belajarqa.com"; // set base url

    @Given("Halaman login kasir aja")
    public void halaman_login_kasir_aja(){
        WebDriverManager.chromedriver().setup(); // setup chrome driver automatically using web driver manager
        ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using headless node

        driver = new ChromeDriver(opt); // apply chrome driver setup to driver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set timeout for web driver on waiting element
        driver.manage().window().maximize(); // maximize window
        driver.get(baseURL); // access base url

        //Assertion
       String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
    }

    @When("Input username")
    public void input_username(){
        driver.findElement(By.id("email")).sendKeys("toko@untungterus.com");
    }

    @And("Input password")
    public void input_password(){
        driver.findElement(By.id("password")).sendKeys("Untungterus77");
    }

    @And("click login button")
    public void click_loggin_button(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("User in on dashboard page")
    public void user_in_on_dashboard_page(){
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username,"toko untung terus");
        driver.close();
    }

    @And("Input Invalid password")
    public void input_invalid_password(){
        driver.findElement(By.id("password")).sendKeys("Untungterus7777");
    }

    @Then("User get error message")
    public void user_get_error_message(){
        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin,"Kredensial yang Anda berikan salah");
        driver.close();
    }

    @When("I input (.*) as email$")
    public void i_input_toko_untung_terus_com_as_email(String email){
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I input (.*) as password$")
    public void i_input_untung_terus_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I verify (.*) login result$")
    public void i_verify_success_login_result(String status){
        if(status.equals("success")){//jika success
            driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
            String namaPaltform = driver.findElement(By.xpath("//h3[contains(text(),'kasirAja')]")).getText();
            Assert.assertEquals(namaPaltform,"kasirAja");
        } else {
            String ErrorLog = driver.findElement(By.xpath("//div[@role='alert']")).getText();
            Assert.assertEquals(ErrorLog,"Kredensial yang Anda berikan salah");
        }
        driver.close();
    }
}
