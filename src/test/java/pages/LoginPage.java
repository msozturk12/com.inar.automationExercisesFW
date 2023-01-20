package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    private WebElement signupNewUserNameBox;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    private WebElement signupEmailAddressBox;
    @FindBy(xpath = "//*[@data-qa='signup-button']")
    private WebElement signUpButton;


    @FindBy(xpath = "//*[@data-qa='login-email']")
    private WebElement loginEmailAddressBox;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    private WebElement loginPasswordBox;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    private WebElement loginButton;


    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignupMessage;

    @FindBy(css = "div[class='login-form'] h2")
    private WebElement logInToYourAccountMessage;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    private WebElement yourEmailOrPasswordIsIncorrect;

    @FindBy(xpath="//p[normalize-space()='Email Address already exist!']\n")
    private WebElement emailAddressAlreadyExistErrorMessage;


    public void setSignupNewUserName(String newUserName) {
        signupNewUserNameBox.sendKeys(newUserName);
    }

    public String getSignUpName() {
        return signupNewUserNameBox.getText();
    }

    public void setSignupEmailAddressBox(String emailAddress) {
        signupEmailAddressBox.sendKeys(emailAddress);
    }

    public void clickSignupButton() {
        signUpButton.click();
    }

    public void setLoginEmailAddress(String emailAddress) {
        loginEmailAddressBox.sendKeys(emailAddress);
    }

    public void setLoginPassword(String password) {
        loginPasswordBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getNewUserSignupMessage() {
        return newUserSignupMessage.getText();
    }

    public String getLoginToYourAccountMessage() {
        return logInToYourAccountMessage.getText();
    }

    public String getYourEmailOrPasswordIsIncorrectMessage() {
        return yourEmailOrPasswordIsIncorrect.getText();
    }

    public String getEmailAddressAlreadyExistErrorMessage() {
        return emailAddressAlreadyExistErrorMessage.getText();
    }





}
