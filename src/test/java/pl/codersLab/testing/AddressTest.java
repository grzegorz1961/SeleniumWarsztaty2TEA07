package pl.codersLab.testing;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.codersLab.pages.AddressPage;
import pl.codersLab.pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class AddressTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");

        AddressPage addressPage = new AddressPage(driver);
        addressPage.addressAs("wojek01", "GFT Polska", "7251947829", "Sterlinga 8 A", "",
                "Lodz", "91-425", "42 663 08 60");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

