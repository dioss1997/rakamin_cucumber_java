package saucedemo.cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class testing {
    WebDriver driver;
    String baseURL = "https:///www.saucedemo.com";

    @Given("Halaman Login")
    public void login_page(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @When("Input Username")
    public void field_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void field_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click Login Button")
    public void login_button(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on first page")
    public void first_page_after_login(){
        driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        driver.close();
    }

    @And("Input Invalid Password")
    public void fill_invalid_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauces_");
    }

    @Then("User get error message")
    public void get_error_message(){
        driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        driver.close();
    }

    @And("First page after login success")
    public void success_login(){
        driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
    }

    @Then("Choice Product")
    public void choice_product(){//Add to cart Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.close();
    }

    @And("Pilih Product")
    public void pilih_remove(){//Add to cart Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }

    @Then("Choice Remove")
    public void remove_product(){//Remove to cart Sauce Labs Bolt T-Shirt
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();
        driver.close();
    }

    @And("Click Gambar Troli")
    public void click_gambar_troli(){
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("Click Checkout")
    public void click_checkout(){
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("Input Firstname")
    public void input_firstname(){
        driver.findElement(By.id("first-name")).sendKeys("Dio");
    }

    @And("Input Lastname")
    public void input_lastname(){
        driver.findElement(By.id("last-name")).sendKeys("Syahbana Suprono");
    }

    @And("Input Postal Code")
    public void input_postal_code(){
        driver.findElement(By.id("postal-code")).sendKeys("15324");
    }

    @And("Click Continue")
    public void click_continue(){
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("Checking and Finish")
    public void checking_and_Finish(){
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        driver.close();
    }

}
