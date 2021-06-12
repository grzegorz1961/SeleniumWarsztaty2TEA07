package pl.codersLab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtraHomePage {
    private WebDriver driver;
    private static String StatusOrder = "Awaiting check payment";
    private String referenceProduct;
    private String priceProduct;

    @FindBy(xpath = "//*[@id=\"history-link\"]/span")
    private WebElement OrderHistoryAndDetails;

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]/th")
    private WebElement numberOrderReference;

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]/td[2]")
    private WebElement totalPriceOrder;

    @FindBy(xpath = "//section[@id='content']//tbody/tr[1]//span")
    private WebElement statusOrder;

    public ExtraHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkOrderHistory(String referenceProduct, String priceProduct){
        Assert.assertEquals(referenceProduct, numberOrderReference.getText());
        Assert.assertEquals(priceProduct, totalPriceOrder.getText());
        Assert.assertEquals(StatusOrder, statusOrder.getText());
    }
}

