package pl.codersLab.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.codersLab.testing.HomeTest;


public class HomePage {
    private static WebDriver driver;

    private enum Size {S, M, L, XL}

    private int qty = 0;
    private int discountProduct = 0;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span")
    private WebElement home;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement search;

    @FindBy(xpath = "//div[@class='products row']/article//a")
    private WebElement product;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/button/i")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img")
    private WebElement productButton;

    @FindBy(id = "group_1")
    private WebElement sizeSelect;
    private String size = "group_1";

    @FindBy(className = "regular-price")
    private WebElement regularPriceProduct;

    @FindBy(xpath = "//*[@class='current-price']/*[@itemprop='price']")
    private WebElement currentPriceProduct;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"")
    private WebElement quantityInput;
    private String quantity = "//*[@id=\"quantity_wanted\"]";

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")
    private WebElement quantityCounter;
    private String counter = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i";

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
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

    //*[@id="order-details"]/ul/li[1]
    @FindBy(xpath = "//div[@id='order-details']//li[1]") //oki
    private WebElement orderReferenceProduct;

    @FindBy(xpath = "//*[@class='price']/strong") //oki
    private WebElement priceProduct;

    @FindBy(xpath = "//*[@id=\"history-link\"]/span") //oki
    private WebElement OrderHistoryAndDetails;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearch(String searchItem) {
        home.click();

        search.sendKeys(searchItem);
        search.sendKeys(Keys.ENTER);
    }

    public void getProduct() {

        product.click();
    }

    public void homeAs(String size, int qty, int discount) {

        double regularPrice = Double.parseDouble(regularPriceProduct.getText().substring(1, 6));
        double currentPrice = Double.parseDouble(currentPriceProduct.getText().substring(1, 6));
        int discountProduct = (int) (((regularPrice - currentPrice) / regularPrice) * 100);
        Assert.assertEquals(discount, discountProduct);
        System.out.println("I checked that the discount on the product is: " + discountProduct + "%");

        Select group_1 = new Select(sizeSelect);
        group_1.selectByVisibleText(size);

        for (int i = 1; i <= qty; i++) {
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
            try {
                Thread.sleep(1000);
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

    public String getPriceProduct() {
        String price = priceProduct.getText();
        return price;
    }

    public String getOrderReferenceProduct() {
        String referenceProduct = orderReferenceProduct.getText().substring(17, 26);
        return referenceProduct;
    }

}
