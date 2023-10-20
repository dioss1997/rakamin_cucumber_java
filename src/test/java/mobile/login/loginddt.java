package mobile.login;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class loginddt {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseURL = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void login_mobile_ddt(){

        String csvDir = System.getProperty("user.dir")+"/src/test/data/testdata.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String email = nextLine[0]; //read column 1 for email
                String password = nextLine[1]; //read column 2 for password
                String status = nextLine[2]; //read column 3 for expected login status

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

                //Interaksi Element/pengisian form
                driver.findElement(By.xpath("//*[contain(@text,'email')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys(email);
                driver.findElement(By.xpath("//*[contain(@text,'password')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys(password);
                driver.findElement(By.xpath("//*[contain(@text,'login')]/parent::android.widget.Button")).click();

                //Assertion
                if(status.equals("success")){//jika success
                    driver.findElement(By.xpath("//*[contain(@text,'kasirAja')]")).isEnabled();
                } else {
                    driver.findElement(By.xpath("//*[contain(@text,'Kredensial yang Anda berikan salah')]")).isEnabled();
                }
                System.out.println("Run " + status + " case");
            }
        } catch (CsvValidationException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
