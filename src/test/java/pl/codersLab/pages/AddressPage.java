package pl.codersLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    private static WebDriver driver;

//    @FindBy( xpath= "//*[@id=\"_desktop_user_info\"]/div/a[1]")
//    private WebElement  singOut;

//    @FindBy( css= "#addresses-link > span")
//    @FindBy( xpath= "//*[@id=\"address-link\"]/span")
//    private WebElement   adfFirstAddress;

//    @FindBy(xpath="//*[@id=\"content\"]/div[3]/a/span")
//    private WebElement createNewAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInput;
    private String alians ="//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[4]/div[1]/input")
    private WebElement companyInput;
    private String company = "//*[@id=\"content\"]/div/div/form/section/div[4]/div[1]/input";

    @FindBy(name = "vat_number")
    private WebElement vat_numberInput;

    @FindBy(name = "address1")
    private WebElement address1Input;

    @FindBy(name = "address2")
    private WebElement address2Input;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityInput;
    private String city = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input";

    @FindBy(name = "id_country")
    private WebElement countryInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInput;
    private String phone = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input";

    @FindBy(xpath =  " //*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span")
    private WebElement home;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addressAs(String alias, String company, String vat_number,
                          String address1, String address2, String city,String postcode, String phone ) {
//        adfFirstAddress.click();

//        createNewAddress.click();

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        companyInput.click();
        companyInput.clear();
        companyInput.sendKeys(company);

        vat_numberInput.click();
        vat_numberInput.clear();
        vat_numberInput.sendKeys(vat_number);

        address1Input.click();
        address1Input.clear();
        address1Input.sendKeys(address1);

        address2Input.click();
        address2Input.clear();
        address2Input.sendKeys(address2);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

//        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        Select id_country = new Select(countryInput);
        id_country.selectByVisibleText("United Kingdom");

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        signInButton.click();

        home.click();
    }
}




