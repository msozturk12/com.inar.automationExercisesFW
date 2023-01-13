package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends  BasePage{
    @FindBy(css="h2[class='title text-center'] b")
    private WebElement accountCreatedMessage;

    @FindBy(css=".btn.btn-primary")
    private WebElement continueButton;


    public String getAccountCreatedMessage(){
        return accountCreatedMessage.getText();
    }

    public void clickContinueButton(){
        continueButton.click();
    }
}
