package pl.codersLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    //Trzymamy nasze wszystkie szukane elementy w klasie a nie metodzie poniżej, nie mogą byc publiczne
    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressesButton;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    private WebElement createNewAddress;


    //Aby powyższe lokatory działały wywołujemy w konstruktorze: statyczną metodę PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();

        addressesButton.click();
        createNewAddress.click();
    }


}
