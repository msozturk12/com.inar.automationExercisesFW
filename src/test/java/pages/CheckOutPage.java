package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    @FindBy(css = "ul[id='address_delivery'] li:nth-child(4)")
    WebElement deliveryAddressText;

    @FindBy(css = "ul[id='address_invoice'] li:nth-child(4)")
    WebElement billingAddressText;


    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    WebElement addressDetailsText;

    @FindBy(xpath = "(//h2[normalize-space()='Review Your Order'])[1]")
    WebElement reviewYourOrderText;


    @FindBy(css = "textarea[name='message']")
    WebElement messageBox;

    @FindBy(xpath = "(//a[normalize-space()='Place Order'])[1]")
    WebElement placeOrderButton;




    //

    public String getDeliveryAddressText() {
        return deliveryAddressText.getText();
    }

    public String getBillingAddressText() {
        return billingAddressText.getText();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public String getAddressDetailsText() {
        return addressDetailsText.getText();
    }

    public String getReviewYourOrderText() {
        return reviewYourOrderText.getText();
    }

    public void setMessageBox(String message) {
        messageBox.sendKeys(message);
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }




}
