package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ViewCartPage extends BasePage {

    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscriptionMessage;

    @FindBy(css = "#susbscribe_email")
    private WebElement subscribeEmail;

    @FindBy(css = ".fa.fa-arrow-circle-o-right")
    private WebElement subscribeArrow;

    @FindBy(css = ".alert-success.alert")
    private WebElement youHaveBeenSuccessfullySubscribedMessageViewCartPage;


    @FindBy(xpath = "(//button[normalize-space()='4'])[1]")
    private WebElement quantityValue;


    @FindBy(xpath = "(//a[normalize-space()='Proceed To Checkout'])[1]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    private WebElement registerLoginButton;

    @FindBy(xpath = "(//i[@class='fa fa-times'])[1]")
    private WebElement XButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement firstProductText;

    @FindBy(css = "p[class='text-center'] b")
    private WebElement cartIsEmptyText;

    @FindBy(xpath = "//img[@alt='Product Image']")
    private WebElement productsImagesInCart;


    //product1
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement signUpLoginButton;

    @FindBy(css = "tr[id='product-1'] td[class='cart_price'] p")
    private WebElement product1Price;

    @FindBy(css = "tr[id='product-1'] button[class='disabled']")
    private WebElement product1Quantity;

    @FindBy(css = "tr[id='product-1'] p[class='cart_total_price']")
    private WebElement product1TotalPrice;

    //product1
    @FindBy(css = "tr[id='product-3'] td[class='cart_price'] p")
    private WebElement product2Price;

    @FindBy(css = "tr[id='product-3'] button[class='disabled']")
    private WebElement product2Quantity;

    @FindBy(css = "tr[id='product-3'] p[class='cart_total_price']")
    private WebElement product2TotalPrice;

    @FindBy(xpath = "//h4/a")
    private List<WebElement> selectedProductsName;





    public String getSubscriptionMessage() {
        return subscriptionMessage.getText();
    }

    public void setSubscribeEmail(String email) {
        subscribeEmail.sendKeys(email);
    }

    public void clickArrowButton() {
        subscribeArrow.click();
    }

    public String getYouHaveBeenSuccessfullySubscribedMessageViewCartPage() {
        return youHaveBeenSuccessfullySubscribedMessageViewCartPage.getText();
    }

    public String getQuantityValue() {
        return quantityValue.getText();
    }
    public void  clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    public void clickRegisterLoginButton(){
        registerLoginButton.click();
    }

    public void clickXButton(){
        XButton.click();
    }

    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }

    public boolean areProductsVisible(){
        return productsImagesInCart.isDisplayed();
    }
    public void clickSignUpLoginButton(){
        signUpLoginButton.click();
    }


    public String getProduct1Price() {
        return product1Price.getText();
    }

    public String getProduct1Quantity() {
        return product1Quantity.getText();
    }

    public String getProduct1TotalPrice() {
        return product1TotalPrice.getText();
    }


    public String getProduct2Price() {
        return product2Price.getText();
    }

    public String getProduct2Quantity() {
        return product2Quantity.getText();
    }

    public String getProduct2TotalPrice() {
        return product2TotalPrice.getText();
    }

    public List<String> getSelectedProductsName(){
        return selectedProductsName.stream().map(s ->s.getText()).collect(Collectors.toList());
    }

}
