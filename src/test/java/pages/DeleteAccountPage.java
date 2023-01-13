package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    WebElement accountDeletedMessage;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;


    public String getAccountDeletedMessage() {
        return accountDeletedMessage.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
