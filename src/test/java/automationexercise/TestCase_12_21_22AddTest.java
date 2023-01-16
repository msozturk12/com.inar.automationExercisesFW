package automationexercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TestCase_12_21_22AddTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TestCase_12_Add_ProductsIn_Cart() {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Hover over second product and click 'Add to cart'
        pages.getProductsPage().clickAddToCartButton1();

        //Click 'Continue Shopping' button
        pages.getProductsPage().clickContinueShoppingButton();

        //Hover over second product and click 'Add to cart'
        pages.getProductsPage().clickAddToCartButton5();

        //Click 'View Cart' button
        pages.getProductsPage().clickCartButton();

        //Verify both products are added to Cart


        //Verify their prices, quantity and total price


    }

    @Test
    public void TestCase_21_Add_ReviewOnProducts() {

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/products",
                "ERROR : Test Case 9 - Verify user is navigated to ALL PRODUCTS page successfully\n ");

        //Click on 'View Product' button
        pages.getProductsPage().clickViewProductOfFirstProductButton();

        //Verify 'Write Your Review' is visible
        String writeYourNameReviewText =  pages.getProductsPage().getWriteYourNameReviewText();
        softAssert.assertEquals(writeYourNameReviewText,"WRITE YOUR REVIEW");

        //Enter name, email and review
        pages.getProductsPage().setNameBox("Nihal");
        pages.getProductsPage().setEmailBox("Nihal32@gmail.com");
        pages.getProductsPage().setReviewBox("It was good,it can be better:)");

        //Click 'Submit' button
        pages.getProductsPage().clickSubmitButton();

        //Verify success message 'Thank you for your review.'
        String thankYouForYourReviewText = pages.getProductsPage().getThankYouForYourReviewText();
        softAssert.assertEquals(thankYouForYourReviewText,"Thank you for your review.");

        softAssert.assertAll();
    }

    @Test
    public void testCase_22_AddToCartFromRecommendedItems(){

        // Scroll to bottom of page
        BrowserUtils.scrollDown("5000");

        // Verify 'RECOMMENDED ITEMS' are visible
        boolean isVisibleRecommendedItemText = pages.getHomePage().isVisibleRecommendedItemsText();
        softAssert.assertTrue(isVisibleRecommendedItemText);

        //Click on 'Add To Cart' on Recommended product
        pages.getHomePage().clickAddToCartRecommended1();
        pages.getHomePage().clickContinueShopping();
        pages.getHomePage().clickAddToCartRecommended2();
        pages.getHomePage().clickContinueShopping();

        //Click on 'View Cart' button
        pages.getHomePage().clickCartButton();

        //Verify that product is displayed in cart page
        boolean afterLoginAreProductsVisible = pages.getViewCartPage().areProductsVisible();
        softAssert.assertTrue(afterLoginAreProductsVisible);
        softAssert.assertAll();



    }


}
