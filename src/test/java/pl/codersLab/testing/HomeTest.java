package pl.codersLab.testing;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.codersLab.function.LoginSetUp;
import pl.codersLab.pages.AddressPage;
import pl.codersLab.pages.HomePage;
import pl.codersLab.pages.LoginPage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class HomeTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
   }

    @Test
    public void LoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");

        HomePage homePage = new HomePage(driver);
        homePage.homeAs("M", 5);
    }

    @After
    public void getScreenShot() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = "ScreenProduct";
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshot/" + fileName + "-" + dateFormat.format(date) + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }
    public void tearDown() {
        //  driver.quit();
    }
}

