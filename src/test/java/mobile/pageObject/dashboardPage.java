package mobile.pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class dashboardPage {
    AndroidDriver driver;

    //construct android driver
    public dashboardPage(AndroidDriver driver){
        this.driver = driver;
    }

    //locator
    By pageTittle = By.xpath("//*[contain(@text,'kasirAja')]");

    //method or function to do the task
    public void assertDashboardPageTittle(){
        driver.findElement(pageTittle).isDisplayed();
    }

}
