package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    @FindBy(id = "search_product")
    WebElement searchProductBox;

    @FindBy(css = ".title.text-center")
    WebElement allProductsTitle;

    //.brands-name
    @FindBy(css = ".brands-name")
    WebElement productsBrandsList;

    @FindBy(css = "a[href='/product_details/1']")
    WebElement viewProductButton;

    @FindBy(css = "#search_product")
    WebElement searchProductsBox;

    @FindBy(css = ".fa.fa-search")
    WebElement searchButton;

    @FindBy(xpath = "(//h2[normalize-space()='Searched Products'])[1]")
    WebElement searchedProductsMessage;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
    WebElement addToCartButton1;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[5]")
    WebElement addToCartButton5;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    WebElement continueShoppingButton;


    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    WebElement cartButton;

    @FindBy(css = "div[class='brands_products'] h2")
    WebElement brandsText;

    @FindBy(css = "a[href='/brand_products/Babyhug']")
    WebElement babyHugButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement brandBabyHugProductsText;

    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    WebElement brandPoloButton;

    @FindBy(xpath = "//img[@alt='ecommerce website products']")
    WebElement productsImages;

    @FindBy(xpath = "//img[contains(@alt,'ecommerce website products')]")
    WebElement menProductsImages;

    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = " //a[@href='#reviews']")
    WebElement writeYourNameReviewText;

    @FindBy(id = "name")
    WebElement nameBox;

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "review")
    WebElement reviewBox;

    @FindBy(id = "button-review")
    WebElement buttonReviewBox;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement submitButton;

    @FindBy(css = "div[class='alert-success alert'] span")
    WebElement thankYouForYourReviewText;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private List<WebElement> listOfSearchedProducts;

    @FindBy(css = ".btn.btn-default.add-to-cart")
    private List<WebElement> addToCartButtonAllProducts;


    public void searchProduct(String productName) {
        searchProductBox.sendKeys(productName);
    }

    public boolean allProductTitleIsVisible() {
        return allProductsTitle.isDisplayed();
    }

    public boolean productsBrandsListIsVisible() {
        return productsBrandsList.isDisplayed();
    }

    public void clickViewProductOfFirstProductButton() {
        viewProductButton.click();
    }

    public void setSearchProductBox(String searchProduct) {
        searchProductBox.sendKeys(searchProduct);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getSearchedProductsMessage() {
        return searchedProductsMessage.getText();
    }

    public boolean isVisibleSearchedProductsMessage() {
        return searchedProductsMessage.isDisplayed();
    }

    public void clickAddToCartButton1() {
        addToCartButton1.click();
        ;
    }

    public void clickAddToCartButton5() {
        addToCartButton5.click();
        ;
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }


    public boolean isVisibleBrandsText() {
        return brandsText.isDisplayed();
    }

    public void clickBabyHugButton() {
        babyHugButton.click();
    }

    public String getBrandBabyHugProductsText() {
        return brandBabyHugProductsText.getText();
    }

    public void clickPoloButton() {
        brandPoloButton.click();
    }

    public boolean isVisibleProducts() {
        return productsImages.isDisplayed();
    }

    public boolean isMenProductsVisible() {
        return menProductsImages.isDisplayed();
    }

    public List<String> getListOfSearchedProducts() {
        return listOfSearchedProducts.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public boolean isDisplayedMenProducts() {
        List<WebElement> products = driver.findElements(By.xpath("//img[@alt='ecommerce website products']/following-sibling::p"));
        List<String> listOfItems = products.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> listOfItemsForMen = listOfItems.stream().filter(s -> s.contains("Men")).collect(Collectors.toList());
        for (int i = 0; i < listOfItemsForMen.size(); i++) {
            if (!listOfItems.contains(listOfItemsForMen.get(i))) {
                return false;
            }
        }
        return true;
    }


    public String getWriteYourNameReviewText() {
        return writeYourNameReviewText.getText();
    }


    public void setNameBox(String name) {
        nameBox.sendKeys(name);
    }

    public void setEmailBox(String email) {
        emailBox.sendKeys(email);
    }

    public void setReviewBox(String review) {
        reviewBox.sendKeys(review);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getThankYouForYourReviewText() {
        return thankYouForYourReviewText.getText();
    }

    public void clickAddToCartOfAllProducts(){
        for (int i = 0; i <addToCartButtonAllProducts.size(); i+=2) {
            addToCartButtonAllProducts.get(i).click();
            continueShoppingButton.click();
        }
    }



}


/*
   List<WebElement> listOfWebElements = Driver.getDriver().findElements(By.xpath("//img[@alt='ecommerce website products']/following-sibling::p"));
    List<String> listOfItems = listOfWebElements.stream().map(s -> s.getText()).collect(Collectors.toList());
    List<String> listOfItemsForWomen = listOfItems.stream().filter(s -> s.contains("Women")).collect(Collectors.toList());
    for(int i = 0; i < listOfItemsForWomen.size(); i++) {
        if(!listOfItems.contains(listOfItemsForWomen.get(i))){
            return false;
 */