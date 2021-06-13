package pl.codersLab.testing;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pl.codersLab.function.LoginSetUp;
import pl.codersLab.pages.HomePage;
import pl.codersLab.pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeTest {
    private static WebDriver driver;
    private String product = "Hummingbird Printed Sweater";
    private String size = "M";
    private int qty = 0;

    private enum Size {S, M, L, XL}

    @Before
    public void setUp() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");

        HomePage homePage = new HomePage(driver);

        homePage.setSearch(product);
        if (product != "Hummingbird Printed Sweater") {
            Assert.fail("There are not enough products in stock");
        }

        homePage.getProduct();

        homePage.homeAs("M", 5, 20);
        if (!(size.equals(Size.M.toString()))) {
            Assert.fail();
        }
        if (!(qty <= 5)) {
            Assert.fail();
        }
    }

    @After
    public void getScreenShot() {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();

        File scrFile;
        scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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

