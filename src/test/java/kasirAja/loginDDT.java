package kasirAja;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class loginDDT {
    //login menggunakan fitur Data Drive Test (DDT)
    @Test
    public void login_ddt(){
        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/"; //set baseURL

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions(); // create object to setup option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using headless mode

        String csvDir = System.getProperty("user.dir")+"/src/test/data/testdata.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String email = nextLine[0]; //read column 1 for email
                String password = nextLine[1]; //read column 2 for password
                String status = nextLine[2]; //read column 3 for expected login status

                driver = new ChromeDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize(); // maximize window
                driver.get(baseURL);

                //Interaksi Element/pengisian form
                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//button[@type='submit']")).click();

                //Assertion
                if(status.equals("success")){//jika success
                    driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
                    String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
                    Assert.assertEquals(username,"toko untung terus");
                } else {
                    String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                    Assert.assertEquals(ErrorLogin,"Kredensial yang Anda berikan salah");
                }
                driver.close();
            }
        } catch (CsvValidationException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
