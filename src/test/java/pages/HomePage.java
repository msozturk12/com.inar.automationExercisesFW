package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement SignupLoginButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productButton;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homePageIcon;

    @FindBy(css = "li:nth-child(10) a:nth-child(1)")
    private WebElement loggedInAsMessage;

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutButton;



    public void clickSignupLoginButton() {
        SignupLoginButton.click();
    }

    public void clickProductButton() {
        BrowserUtils.verifyElementDisplayed(productButton);
        productButton.click();
    }

    public String getHomePageHomeTitle() {
        return homePageIcon.getText();

    }

    public String getLoggedInAsMessage() {
        return loggedInAsMessage.getText();
    }


    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public boolean isVisibleLoggedInAsUserNameSection(){
        return loggedInAsMessage.isDisplayed();
    }

    public void clickLogOutButton(){
        logOutButton.click();
    }


}
