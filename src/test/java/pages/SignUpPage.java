package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
    //Fill details: Title, Name, Email, Password, Date of birth

    @FindBy(xpath = "//*[@id='form']/div/div/div/div[1]/h2")
    private WebElement enterAccountInformationTitle;

    @FindBy(xpath = "//*[@id='id_gender1']")
    private WebElement id_genderMR;

    @FindBy(xpath = "//*[@id='id_gender2']")
    private WebElement id_genderMRS;


    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@data-qa='days']")
    private WebElement dateOfBirt_DAYs;
    @FindBy(xpath = "//*[@data-qa='months']")
    private WebElement dateOfBirt_MONTHs;

    @FindBy(xpath = "//*[@data-qa='years']")
    private WebElement dateOfBirt_YEARs;

    @FindBy(css = "a[href='/products']")
    private WebElement productsPageButton;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement checkboxSignUpForOurNewsletter;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement checkboxReceiveSpecialOffersFromOurPartners;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement enterFirstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement enterLastName;

    @FindBy(css = "#company")
    private WebElement enterCompanyName;

    @FindBy(css = "#address1")
    private WebElement enterAddress1;

    @FindBy(css = "#address2")
    private WebElement enterAddress2;

    @FindBy(css = "#country")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement enterState;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement enterCity;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement enterZipCode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement enterMobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;


    ////p[normalize-space()='Email Address already exist!']


    public SignUpPage() {
    }


    public String getEnterAccountInformationTitle() {
        return enterAccountInformationTitle.getText();

    }

    public void selectTitleMen() {
        id_genderMR.click();
    }

    public void selectTitleWomen() {
        id_genderMRS.click();
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);

    }

    public void setDateOfBirt(String day, String month, String year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }


    private void setDay(String day) {
        Select select = new Select(dateOfBirt_DAYs);
        select.selectByVisibleText(day);
    }

    private void setMonth(String month) {
        Select select = new Select(dateOfBirt_MONTHs);
        select.selectByVisibleText(month);
    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirt_YEARs);
        select.selectByVisibleText(year);

    }

    public void selectProductsPageButton() {
        productsPageButton.click();
    }

    public void selectCheckboxSignUpForOurNewsletter() {
        checkboxSignUpForOurNewsletter.click();
    }


    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        checkboxReceiveSpecialOffersFromOurPartners.click();

    }

    public void setFirstName(String firstName) {
        enterFirstName.sendKeys(firstName);
    }

    public String getFirstName(){
        return enterFirstName.getText();
    }

    public WebElement getEnterFirstName() {
        return enterFirstName;
    }

    public void setLastName(String lastName) {
        enterLastName.sendKeys(lastName);
    }

    public void setCompanyName(String companyName) {
        enterCompanyName.sendKeys(companyName);
    }

    public void setAddress1(String address1) {
        enterAddress1.sendKeys(address1);
    }

    public String getAddress1() {
        return enterAddress1.getText();
    }

    public void setAddress2(String address2) {
        enterAddress2.sendKeys(address2);
    }

    public void setCountry(String country) {
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
    }

    public void setState(String state) {
        enterState.sendKeys(state);
    }

    public void setCity(String city) {
        enterCity.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        enterZipCode.sendKeys(zipCode);
    }

    public void setMobileNumber(String mobileNumber) {
        enterMobileNumber.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }




}
