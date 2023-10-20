package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import mobile.pageObject.loginPage;
import mobile.pageObject.dashboardPage;

public class loginPOM {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseURL = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void login_success() throws MalformedURLException {
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

        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        //get elemant & input username, password then click login button. Then Assert
        loginPage.inputUsername("toko@untungterus.com");
        loginPage.inputPassword("Untungterus77");
        loginPage.clickLoginButton();
        dashboardPage.assertDashboardPageTittle();
    }

    @Test
    public void login_failed() throws MalformedURLException{
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

        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        //get elemant & input username, password then click login button. Then Assert
        loginPage.inputUsername("toko@untungterus.com");
        loginPage.inputPassword("1234567890");
        loginPage.clickLoginButton();
        loginPage.assertErrorMessageLogin();
    }
}
