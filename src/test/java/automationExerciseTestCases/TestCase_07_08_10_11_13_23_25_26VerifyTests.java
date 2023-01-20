package automationExerciseTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TestCase_07_08_10_11_13_23_25_26VerifyTests extends BaseTest {

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
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 11 - Verify that home page is visible successfull\n");

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

        BrowserUtils.wait(2);
        //Verify success message 'You have been successfully subscribed!' is visible
        String youHaveBeenSuccessfullySubscribedMessage = pages.getViewCartPage().getYouHaveBeenSuccessfullySubscribedMessageViewCartPage();
        softAssert.assertEquals(youHaveBeenSuccessfullySubscribedMessage, "You have been successfully subscribed!",
                "ERROR : Test Case 11 - Verify success message 'You have been successfully subscribed!");

        softAssert.assertAll();

    }

    @Test
    public void testCase_13_VerifyProductQuantityInCart() {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 13 - Verify that home page is visible successfull\n");

        //Click 'View Product' for any product on home page
        pages.getHomePage().clickViewProductButton();

        //Verify product detail is opened
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/product_details/2",
                "ERROR : Test Case 13 - Verify product detail is opened\n");

        // Increase quantity to 4
        BrowserUtils.doubleClick(pages.getProductDetailPage().clickQuantityBox());
        pages.getProductDetailPage().clearQuantityBox();
        pages.getProductDetailPage().setQuantityBox("4");

        //Click 'Add to cart' button
        pages.getProductDetailPage().clickAddToCartButton();

        //Click 'View Cart' button
        pages.getProductDetailPage().clickViewCartButton();

        // Verify that product is displayed in cart page with exact quantity
        String quantityValue = pages.getViewCartPage().getQuantityValue();
        softAssert.assertEquals(quantityValue, "4");

        softAssert.assertAll();

    }

    @Test
    public void testCase_23_VerifyAddressDetailsInCheckoutPage() {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 13 - Verify that home page is visible successfull\n");

        //Click 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //Fill all details in Signup and create account
        pages.getLoginPage().setSignupNewUserName("Zara");
        pages.getLoginPage().setSignupEmailAddressBox("Sare32@gmail.com");
        pages.getLoginPage().clickSignupButton();

        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("2112");
        pages.getSignupPage().setDateOfBirt("10", "May", "2007");

        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        pages.getSignupPage().setFirstName("Zara");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("Oracle12");
        pages.getSignupPage().setAddress1("Utrect");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCountry("Canada");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("Lille");
        pages.getSignupPage().setZipCode("321004");
        pages.getSignupPage().setMobileNumber("16a5698956");
        String address = pages.getSignupPage().getAddress1();
        //String name = pages.getSignupPage().getFirstName();


        // Click 'Create Account button'
        pages.getSignupPage().clickCreateAccountButton();

        //Verify that 'ACCOUNT CREATED!' is visible
        String accountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!",
                "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n");

        //Click 'Continue' button
        pages.getAccountCreatedPage().clickContinueButton();

        //Verify ' Logged in as username' at top
        String loggedInAsMessage = pages.getHomePage().getLoggedInAsMessage();
        softAssert.assertEquals(loggedInAsMessage, "Logged in as Zara",
                "ERROR : Verify that 'Logged in as username' is visible");

        //Add products to cart
        pages.getProductsPage().clickAddToCartButton5();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();

        //Click 'Cart' button
        pages.getProductsPage().clickCartButton();

        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");

        //Click Proceed To Checkout
        pages.getViewCartPage().clickProceedToCheckoutButton();

        //Verify that the delivery address is same address filled at the time registration of account

        String deliverAddress = pages.getCheckOutPage().getBillingAddressText();
        softAssert.assertEquals("Utrect", deliverAddress);

        //Verify that the billing address is same address filled at the time registration of account
        String billingAddress = pages.getCheckOutPage().getDeliveryAddressText();
        softAssert.assertEquals("Utrect", billingAddress);


        //14. Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //15.Verify 'ACCOUNT DELETED!' and click 'Continue' button.
        String accountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!");
        pages.getDeleteAccountPage().clickContinueButton();

        softAssert.assertAll();

    }

    @Test
    public void testCase_25VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 13 - Verify that home page is visible successfull\n");

        //Scroll down page to bottom
        BrowserUtils.scrollDown("10_000");

        //Verify 'SUBSCRIPTION' is visible
        String subscribeMessage = pages.getHomePage().getSubscriptionMessage();
        softAssert.assertEquals(subscribeMessage, "SUBSCRIPTION");

        //Click on arrow at bottom right side to move upward
        pages.getHomePage().clickScrollUpButton();

        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        String fullFledgedText = pages.getHomePage().getFullFledgedText();
        softAssert.assertEquals(fullFledgedText, "Full-Fledged practice website for Automation Engineers");
        softAssert.assertAll();

    }

    @Test
    public void testCase_26VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        //Verify that home page is visible successfully
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 13 - Verify that home page is visible successfull\n");

        //Scroll down page to bottom
        BrowserUtils.scrollDown("9000");

        //Verify 'SUBSCRIPTION' is visible
        String subscribeMessage = pages.getHomePage().getSubscriptionMessage();
        softAssert.assertEquals(subscribeMessage, "SUBSCRIPTION");

        // Scroll up page to top
        BrowserUtils.scrollDown("-9000");

        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        String fullFledgedText = pages.getHomePage().getFullFledgedText();
        softAssert.assertEquals(fullFledgedText, "Full-Fledged practice website for Automation Engineers");
        softAssert.assertAll();

    }


}
