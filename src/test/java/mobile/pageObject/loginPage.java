package mobile.pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class loginPage {
    AndroidDriver driver;

    //construct android driver
    public loginPage(AndroidDriver driver){
        this.driver = driver;
    }

    //locator
    By usernameField = By.xpath("//*[contain(@text,'email')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText");
    By passwordField = By.xpath("//*[contain(@text,'password')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText");
    By loginButton = By.xpath("//*[contain(@text,'login')]/parent::android.widget.Button");
    By failedLogin = By.xpath("//*[contain(@text,'Kredensial yang Anda berikan salah')]");

    //method or function to do the task
    public void inputUsername(String email){
        driver.findElement(usernameField).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void assertErrorMessageLogin(){
        driver.findElement(failedLogin).isDisplayed();
    }
}
