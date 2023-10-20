package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class openApps {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseURL = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void main() throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","14");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/java/mobile/apk/kasirAja_311222.apk");
        capabilities.setCapability("autoGrantPermissions",true);// set auto accept permisson request setting
        capabilities.setCapability("autoAcceptAlerts",true);// set auto accept all possible appearing alert

        //open apps
        URL url = new URL(baseURL);
        driver = new AndroidDriver(url, capabilities);
        //timeout
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //get elemant & input username, password then click login button. Then Assert
        driver.findElement(By.xpath("//*[contain(@text,'email')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys("toko@untungterus.com");
        driver.findElement(By.xpath("//*[contain(@text,'password')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys("Untungterus77");
        driver.findElement(By.xpath("//*[contain(@text,'login')]/parent::android.widget.Button")).click();
        driver.findElement(By.xpath("//*[contain(@text,'kasirAja')]")).isEnabled();
    }
}
