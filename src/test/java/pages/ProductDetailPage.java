package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

    @FindBy(css = "div[class='product-information'] h2")
    WebElement productName;
    @FindBy(xpath = "//div[@class='product-information'] / p[1]")
    WebElement productCategory;

    @FindBy(xpath = "(//span[normalize-space()='Rs. 500'])[1]")
    WebElement productPrice;

    @FindBy(xpath = "//div[@class='product-details']//p[2]")
    WebElement productAvailability;

    @FindBy(xpath = "//body//section//p[3]")
    WebElement productCondition;

    @FindBy(xpath = "//body//section//p[4]")
    WebElement productBrand;

    @FindBy(css = "#quantity")
    WebElement quantityBox;

    @FindBy(css = "button[type='button']")
    WebElement addToCartButton;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartButton;


    //
    public boolean isVisibleProductName() {
        return productName.isDisplayed();
    }

    public boolean isVisibleProductCategory() {
        return productCategory.isDisplayed();
    }

    public boolean isVisibleProductPrice() {
        return productPrice.isDisplayed();
    }

    public boolean isVisibleProductAvailability() {
        return productAvailability.isDisplayed();
    }

    public boolean isVisibleProductCondition() {
        return productCondition.isDisplayed();
    }

    public boolean isVisibleProductBrand() {
        return productBrand.isDisplayed();
    }

    public WebElement clickQuantityBox() {
        return quantityBox;
    }

    public void setQuantityBox(String quantity){
        quantityBox.sendKeys(quantity);
    }
    public void clearQuantityBox(){
        quantityBox.clear();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickViewCartButton(){
        viewCartButton.click();
    }




}
