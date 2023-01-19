package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.BrowserUtils;

import java.io.File;

public class PaymentPage extends BasePage {

    @FindBy(css = "input[name='name_on_card']")
    WebElement nameOnCardBox;


    @FindBy(css = "input[name='card_number']")
    WebElement cardNumberButton;

    @FindBy(css = "input[placeholder='ex. 311']")
    WebElement cvcBox;

    @FindBy(css = "input[placeholder='MM']")
    WebElement expirationBox;

    @FindBy(css = "input[placeholder='YYYY']")
    WebElement yearBox;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement payAndConfirmOrderButton;


    @FindBy(css = "div[id='success_message'] div[class='alert-success alert']")
    WebElement YourOrderHasBeenPlacedSuccessfullyMessage;

    @FindBy(xpath = "(//a[normalize-space()='Download Invoice'])[1]")
    WebElement downloadInvoiceButton;

    @FindBy(css = ".btn.btn-primary")
    WebElement continueButton;



    //

    public void setNameOnCardBox(String nameOnCard) {
        nameOnCardBox.sendKeys(nameOnCard);
    }

    public void setCardNumberButton(String cardNumber) {
        cardNumberButton.sendKeys(cardNumber);
    }

    public void setCvcBox(String cvc) {
        cvcBox.sendKeys(cvc);
    }

    public void setExpirationBox(String expiration) {
        expirationBox.sendKeys(expiration);
    }

    public void setYearBox(String year) {
        yearBox.sendKeys(year);
    }

    public void clickPayAndConfirmOrder() {
        payAndConfirmOrderButton.click();
    }

    public String getYourOrderHasBeenPlacedSuccessfullyMessage() {
        return YourOrderHasBeenPlacedSuccessfullyMessage.getText();
    }

    public void clickDownloadInvoiceButton(){
        downloadInvoiceButton.click();
    }

    public void verifyIsDownloaded(){
        downloadInvoiceButton.click();
        BrowserUtils.wait(5);
        File file = new File("C:\\Users\\mesut\\Downloads\\invoice.txt");
        if (file.exists()){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
    }

    public void clickContinueButton(){
        continueButton.click();
    }



}
