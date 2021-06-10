package pl.codersLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span")
    private WebElement home;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement search;


    private String nameProduct = "Hummingbird Printed T-Shirt";

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/button/i")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img")
    private WebElement productButton;
    private String product = "//*[@id=\"content\"]/section/div/article[2]/div/a/img";

    @FindBy(id = "group_1") //oki
    private WebElement sizeSelect;
    private String size = "group_1";

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"")
    private WebElement quantityInput;
    private String quantity = "//*[@id=\"quantity_wanted\"]";

    //*[@id="add-to-cart-or-refresh"]/div[2]/div/div[1]/div/span[3]/button[1]/i
    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")
    private WebElement quantityCounter;
    private String counter = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i";

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button") //oki
    private WebElement addProductButton;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement goToCheckout;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private WebElement confirmAddressButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[1]/div/div")
    private WebElement selectsCollectionMethod;
    private String collectionMethod = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[1]/div/div";

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement goContinueButton;
    private String goContinue = "//*[@id=\"js-delivery\"]/button";

    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/label/span")
    private WebElement orderPay;
    private String pay = "//*[@id=\"payment-option-1-container\"]/label/span";

    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement approveTermsAndConditions;
    private String approve = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]";

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement obligationToPayButton;
    private String obligation = "//*[@id=\"payment-confirmation\"]/div[1]/button";


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void homeAs(String size, int qty) {
        // public void homeAs(String size) {

        home.click();

        search.click();
        search.clear();
        search.sendKeys(nameProduct);

        searchButton.click();

        productButton.click();

        Select group_1 = new Select(sizeSelect);
        group_1.selectByVisibleText(size);

        for (int i = 1; i <= qty; i++) {
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
                System.out.println("There are not enough products in stock");
            }
            driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).click();
        }

        addProductButton.click();

        goToCheckout.click();

        proceedToCheckout.click();

        confirmAddressButton.click();

        selectsCollectionMethod.click();

        goContinueButton.click();

        if (!orderPay.isSelected())
            orderPay.click();

        if (!approveTermsAndConditions.isSelected())
            approveTermsAndConditions.click();

        obligationToPayButton.click();
    }
}
