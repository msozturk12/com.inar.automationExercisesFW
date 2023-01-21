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

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "header[id='header'] li:nth-child(5) a:nth-child(1)")
    private WebElement testCaseButton;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionMessage;

    @FindBy(css = "#susbscribe_email")
    private WebElement emailAddressBox;

    @FindBy(css = ".fa.fa-arrow-circle-o-right")
    private WebElement arrowButton;

    @FindBy(id = "success-subscribe")
    private WebElement youHaveBeenSuccessfullySubscribedMessage;

    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement cartButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstButton;

    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    private WebElement scrollUpButton;

    @FindBy(css = "div[class='item active'] div[class='col-sm-6'] h2")
    private WebElement fullFledgedText;

    @FindBy(css = "#accordian")
    private WebElement categoryLocator;

    @FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
    private WebElement womenCategoryButton;

    @FindBy(css = "a[href='/category_products/2']")
    private WebElement womenTopsButton;

    //--------------------------category_products/2---------page
    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement womenTopsProductsText;


    @FindBy(xpath = "(//i[@class='fa fa-plus'])[2]")
    private WebElement menProductsButton;

    //----------------------category_products/3-----------page
    @FindBy(xpath = "//a[normalize-space()='Tshirts']")
    private WebElement menTshirtButton;

    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    private WebElement recommendedItemsText;

    @FindBy(xpath = "//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
    private WebElement addToCartRecommended1;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[73]")
    private WebElement getAddToCartRecommended2;

    @FindBy(xpath = "(//button[normalize-space()='Continue Shopping'])[1]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//html/body/section[2]/div/div/div/div/div")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[7]")
    private WebElement addToCartButton7;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[13]")
    private WebElement addToCartButton13;


    //

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


    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public boolean isVisibleLoggedInAsUserNameSection() {
        return loggedInAsMessage.isDisplayed();
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void clickTestCaseButton() {
        testCaseButton.click();
    }

    public String getSubscriptionMessage() {
        return subscriptionMessage.getText();
    }

    public void setEmailAddressBox(String email) {
        emailAddressBox.sendKeys(email);

    }

    public void clickArrowButton() {
        arrowButton.click();
    }

    public String getYouHaveBeenSuccessfullySubscribedMessage() {
        return youHaveBeenSuccessfullySubscribedMessage.getText();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickViewProductOfFirstButton() {
        viewProductOfFirstButton.click();
    }

    public void clickScrollUpButton() {
        scrollUpButton.click();
    }

    public String getFullFledgedText() {
        return fullFledgedText.getText();
    }

    public boolean areCategoriesVisible() {
        return categoryLocator.isDisplayed();
    }

    public void clickWomenCategory() {
        womenCategoryButton.click();
    }

    public void clickWomenTopsButton() {
        womenTopsButton.click();
    }

    //--------------------------category_products/2---------pages

    public String getWomenTopsProductsText() {
        return womenTopsProductsText.getText();
    }

    public void clickMenProductButton() {
        menProductsButton.click();
    }


    //----------------------category_products/3-----------page
    public void clickMenTshirtButton() {
        menTshirtButton.click();
    }


    public boolean isVisibleRecommendedItemsText() {
        return recommendedItemsText.isDisplayed();
    }

    public void clickAddToCartRecommended1() {
        addToCartRecommended1.click();
    }

    public void clickAddToCartRecommended2() {
        getAddToCartRecommended2.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickAddToCartButton7(){
        addToCartButton7.click();
    }

    public void clickAddToCartButton13(){
        addToCartButton13.click();
    }


}



     /*   public void clickAddToCartButton(){
        addToCartButton.click();
    }

   public void addProductsToCart(String searchedText) {
        List<WebElement> allProductsName = Driver.getDriver().findElements(By.xpath("//p"));
        List<String> productsName=allProductsName.stream().map(s ->s.getText()).collect(Collectors.toList());
        List<WebElement> buttonLink = driver.findElements(By.xpath("//a[@class='btn btn-default add-to-cart']"));

        while(productsName.contains(searchedText)){
           for(WebElement addToCart : buttonLink){
               addToCart.click();
               continueShoppingButton.click();
           }

        }
*/
//a[class='btn btn-default add-to-cart']


/*
   List<WebElement> listOfWebElements = Driver.getDriver().findElements(By.xpath("//img[@alt='ecommerce website products']/following-sibling::p"));
    List<String> listOfItems = listOfWebElements.stream().map(s -> s.getText()).collect(Collectors.toList());
    List<String> listOfItemsForWomen = listOfItems.stream().filter(s -> s.contains("Women")).collect(Collectors.toList());
    for(int i = 0; i < listOfItemsForWomen.size(); i++) {
        if(!listOfItems.contains(listOfItemsForWomen.get(i))){
            return false;
 */
