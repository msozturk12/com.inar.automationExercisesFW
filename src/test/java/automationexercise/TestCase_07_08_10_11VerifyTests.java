package automationexercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TestCase_07_08_10_11VerifyTests extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testCase_07_VerifyTestCasesPage() {


        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 7 - Verify that home page is visible successfull\n");

        //Click on 'Test Cases' button
        pages.getHomePage().clickTestCaseButton();

        //Verify user is navigated to test cases page successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/test_cases", "ERROR:TestCase_07 Verify user is navigated to test cases page successfully ");
        softAssert.assertAll();

    }

    @Test
    public void testCase_08_VerifyAllProductsAndProductDetailPage() {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 8 - Verify that home page is visible successfull\n");

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
        boolean isVisibleAllProductsPage = pages.getProductsPage().allProductTitleIsVisible();
        softAssert.assertTrue(isVisibleAllProductsPage, "ERROR : Test Case 8 - Verify user is navigated to ALL PRODUCTS page successfully\n");

        //The products list is visible
        boolean isVisibleProductsBrands = pages.getProductsPage().productsBrandsListIsVisible();
        softAssert.assertTrue(isVisibleProductsBrands, "ERROR : Test Case 8 - The products list is visible\n");

        //Click on 'View Product' of first product
        pages.getProductsPage().clickViewProductOfFirstProductButton();

        // User is landed to product detail page
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/product_details/1",
                "ERROR : Test Case 8 - User is landed to product detail page\n");

        //Verify that detail is visible: product name, category, price, availability, condition, brand

        boolean isVisibleProductName = pages.getProductDetailPage().isVisibleProductName();
        softAssert.assertTrue(isVisibleProductName, "ERROR : Test Case 8 - Verify that detail is visible: product name\n");

        boolean isVisibleProductCategory = pages.getProductDetailPage().isVisibleProductCategory();
        softAssert.assertTrue(isVisibleProductCategory, "ERROR : Test Case 8 - Verify that detail is visible:category,\n");

        boolean isVisibleProductPrice = pages.getProductDetailPage().isVisibleProductPrice();
        softAssert.assertTrue(isVisibleProductPrice, "ERROR : Test Case 8 - Verify that detail is visible: price\n");

        boolean isVisibleProductAvailability = pages.getProductDetailPage().isVisibleProductAvailability();
        softAssert.assertTrue(isVisibleProductAvailability, "ERROR : Test Case 8 - Verify that detail is visible: availability\n");

        boolean isVisibleProductCondition = pages.getProductDetailPage().isVisibleProductCondition();
        softAssert.assertTrue(isVisibleProductCondition, "ERROR : Test Case 8 - Verify that detail is visible: availability\n");

        boolean isVisibleProductBrand = pages.getProductDetailPage().isVisibleProductBrand();
        softAssert.assertTrue(isVisibleProductBrand, "ERROR : Test Case 8 - Verify that detail is visible: brand\n");

        softAssert.assertAll();

    }

    @Test
    public void testCase_10_VerifySubscriptionInHomePage() {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 10 - Verify that home page is visible successfull\n");

        //Scroll down to footer
        BrowserUtils.scrollDown("5000");

        // Verify text 'SUBSCRIPTION'
        String subscriptionMessage = pages.getHomePage().getSubscriptionMessage();
        softAssert.assertEquals(subscriptionMessage, "SUBSCRIPTION", "ERROR : Test Case 10 -  Verify text 'SUBSCRIPTION'\n");

        //Enter email address in input and click arrow button
        pages.getHomePage().setEmailAddressBox("inar@gmail.com");
        pages.getHomePage().clickArrowButton();

        //Verify success message 'You have been successfully subscribed!' is visible
        String youHaveBeenSuccessfullySubscribed = pages.getHomePage().getYouHaveBeenSuccessfullySubscribedMessage();
        softAssert.assertEquals(youHaveBeenSuccessfullySubscribed, "You have been successfully subscribed!",
                "ERROR : Test Case 10 - Verify success message 'You have been successfully subscribed!' is visible");

        softAssert.assertAll();
    }

    @Test
    public void testCase_11_VerifySubscriptionInCartPage() {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 10 - Verify that home page is visible successfull\n");

        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Scroll down to footer
        BrowserUtils.scrollDown("2000");

        //Verify text 'SUBSCRIPTION'
        String subscriptionMessage = pages.getViewCartPage().getSubscriptionMessage();
        softAssert.assertEquals(subscriptionMessage, "SUBSCRIPTION",
                "ERROR : Test Case 11 - Verify text 'SUBSCRIPTION'");

        //Enter email address in input and click arrow button
        pages.getViewCartPage().setSubscribeEmail("supernova@gmail.com");
        pages.getViewCartPage().clickArrowButton();

       //Verify success message 'You have been successfully subscribed!' is visible
        String youHaveBeenSuccessfullySubscribedMessage = pages.getViewCartPage().getYouHaveBeenSuccessfullySubscribedMessageViewCartPage();
        softAssert.assertEquals(youHaveBeenSuccessfullySubscribedMessage,"You have been successfully subscribed!",
                "ERROR : Test Case 11 - Verify success message 'You have been successfully subscribed!");
        softAssert.assertAll();

// You have been successfully subscribed!
    }

}
