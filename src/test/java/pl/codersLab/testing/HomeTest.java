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
import pl.codersLab.pages.AddressPage;
import pl.codersLab.pages.HomePage;
import pl.codersLab.pages.LoginPage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HomeTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void LoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.loginAs("nkssnglcxxajzysope@twzhhq.com", "Kasia2021!");
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");

        HomePage homePage = new HomePage(driver);
        homePage.homeAs("XL", 2);
    }

    @After
    public void takeScreenshot() {
// Setting your Chrome options (Desired capabilities)
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments(
//                "--start-maximized",
//                "--start-fullscreen"
//        );
        //take screenshot of the page
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Setting your Chrome options (Desired capabilities)
        try {
            FileUtils.copyFile(src, new File("C:\\testPhoto\\screen.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }

    public void tearDown() {
        //  driver.quit();
    }
}

