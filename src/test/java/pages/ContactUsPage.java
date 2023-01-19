package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getInTouchMessage;

    @FindBy(css = "input[placeholder='Name']")
    WebElement enterNameGetInTouch;

    @FindBy(css = "input[placeholder='Email']")
    WebElement enterEmailGetInTouch;

    @FindBy(xpath= "//input[@placeholder='Subject']")
    WebElement enterSubjectGetInTouch;

    @FindBy(css= "#message")
    WebElement enterMessageGetInTouch;

    @FindBy(css= "input[name='upload_file']")
    WebElement uploadFileBox;

    @FindBy(xpath= "//input[@name='submit']")
    WebElement submitButton;

    @FindBy(xpath= "//div[@class='status alert alert-success']")
    WebElement successYourDetailsHaveBeenSubmittedSuccessfullyMessage;

    @FindBy(xpath= " //span[normalize-space()='Home']")
    WebElement homeButton;





    //  ul[id='address_delivery'] li:nth-child(4)



    public String getInTouchMessage(){
        return getInTouchMessage.getText();
    }

    public void setEnterNameGetInTouch(String name){
        enterNameGetInTouch.sendKeys(name);
    }

    public void setEnterEmailGetInTouch(String email){
        enterEmailGetInTouch.sendKeys(email);
    }

    public void setEnterSubjectGetInTouch(String subject){
        enterSubjectGetInTouch.sendKeys(subject);
    }

    public void setEnterMessageGetInTouch(String message) {
        enterMessageGetInTouch.sendKeys(message);
    }

    public void setUploadFileBox(String filePath){
        uploadFileBox.sendKeys(filePath);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getSuccessYourDetailsHaveBeenSubmittedSuccessfullyMessage() {
        return successYourDetailsHaveBeenSubmittedSuccessfullyMessage.getText();
    }

    public void clickHomeButton(){
        homeButton.click();
    }



}
