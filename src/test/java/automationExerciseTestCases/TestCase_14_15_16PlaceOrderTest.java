package automationExerciseTestCases;

import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase_14_15_16PlaceOrderTest extends BaseTest {

    @Test
    public void testCase_14PlaceOrderRegisterWhileCheckout() {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Add products to cart
        pages.getHomePage().clickProductButton();
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartButton5();
        pages.getProductsPage().clickContinueShoppingButton();

        // Click 'Cart' button
        pages.getProductsPage().clickCartButton();

        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");

        //Click Proceed To Checkout
        pages.getViewCartPage().clickProceedToCheckoutButton();

        //Click 'Register / Login' button
        pages.getViewCartPage().clickRegisterLoginButton();

        //Fill all details in Signup and create account
        pages.getLoginPage().setSignupNewUserName("Enes");
        pages.getLoginPage().setSignupEmailAddressBox("Enes3217@gmail.com");
        pages.getLoginPage().clickSignupButton();

        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("2112");
        pages.getSignupPage().setDateOfBirt("10", "May", "2017");

        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        pages.getSignupPage().setFirstName("Enes");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("Oracle12");
        pages.getSignupPage().setAddress1("Utrect");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCountry("New Zealand");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("Lille");
        pages.getSignupPage().setZipCode("321004");
        pages.getSignupPage().setMobileNumber("16a5698956");

        pages.getSignupPage().clickCreateAccountButton();

        // Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String accountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!",
                "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n");

        pages.getAccountCreatedPage().clickContinueButton();

        //Verify ' Logged in as username' at top
        boolean isVisibleLoggedInAsMessage=pages.getHomePage().isVisibleLoggedInAsUserNameSection();
        softAssert.assertTrue(isVisibleLoggedInAsMessage,"ERROR : Verify that 'Logged in as username' is visible");


        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Click 'Proceed To Checkout' button
        pages.getViewCartPage().clickProceedToCheckoutButton();

        //Verify Address Details and Review Your Order
        String addressDetailsText = pages.getCheckOutPage().getAddressDetailsText();
        softAssert.assertEquals(addressDetailsText, "Address Details");

        String reviewYourOrder = pages.getCheckOutPage().getReviewYourOrderText();
        softAssert.assertEquals(reviewYourOrder, "Review Your Order");

        //Enter description in comment text area and click 'Place Order'
        pages.getCheckOutPage().setMessageBox("are all these products made by %100 cotton");
        pages.getCheckOutPage().clickPlaceOrderButton();

        //Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pages.getPaymentPage().setNameOnCardBox("Enes");
        pages.getPaymentPage().setCardNumberButton("60005421");
        pages.getPaymentPage().setCvcBox("541");
        pages.getPaymentPage().setExpirationBox("11");
        pages.getPaymentPage().setYearBox("2030");


        //Click 'Pay and Confirm Order' button
        pages.getPaymentPage().clickPayAndConfirmOrder();

       /*
        //Verify success message 'Your order has been placed successfully!'
        String yourOrderHasBeenPlacedSuccessfullyMessage = pages.getPaymentPage().getYourOrderHasBeenPlacedSuccessfullyMessage();
        softAssert.assertEquals(yourOrderHasBeenPlacedSuccessfullyMessage,"Your order has been placed successfully!");
        */

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String accountDeletedText = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedText,"ACCOUNT DELETED!");

        pages.getDeleteAccountPage().clickContinueButton();

        softAssert.assertAll();
    }

    @Test
    public void testCase_15PlaceOrderRegisterBeforeCheckout(){

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //Fill all details in Signup and create account
        pages.getLoginPage().setSignupNewUserName("Belatrix");
        pages.getLoginPage().setSignupEmailAddressBox("Belatrix32@gmail.com");
        pages.getLoginPage().clickSignupButton();

        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("2112");
        pages.getSignupPage().setDateOfBirt("10", "May", "2017");

        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        pages.getSignupPage().setFirstName("Enes");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("Oracle12");
        pages.getSignupPage().setAddress1("Utrect");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCountry("New Zealand");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("Lille");
        pages.getSignupPage().setZipCode("321004");
        pages.getSignupPage().setMobileNumber("16a5698956");

        pages.getSignupPage().clickCreateAccountButton();

        // Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String accountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!",
                "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n");

        pages.getAccountCreatedPage().clickContinueButton();

        //Verify ' Logged in as username' at top
        boolean isVisibleLoggedInAsMessage=pages.getHomePage().isVisibleLoggedInAsUserNameSection();
        softAssert.assertTrue(isVisibleLoggedInAsMessage,"ERROR : Verify that 'Logged in as username' is visible");


        //Add products to cart
        pages.getHomePage().clickProductButton();
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartButton5();
        pages.getProductsPage().clickContinueShoppingButton();

        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/view_cart");

        //Click 'Proceed To Checkout' button
        pages.getViewCartPage().clickProceedToCheckoutButton();

        //Verify Address Details and Review Your Order
        String addressDetailsText = pages.getCheckOutPage().getAddressDetailsText();
        softAssert.assertEquals(addressDetailsText, "Address Details");

        String reviewYourOrder = pages.getCheckOutPage().getReviewYourOrderText();
        softAssert.assertEquals(reviewYourOrder, "Review Your Order");

        //Enter description in comment text area and click 'Place Order'
        pages.getCheckOutPage().setMessageBox("are all these products made by %90 cotton");
        pages.getCheckOutPage().clickPlaceOrderButton();

        //Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pages.getPaymentPage().setNameOnCardBox("EnesCan1");
        pages.getPaymentPage().setCardNumberButton("60005421");
        pages.getPaymentPage().setCvcBox("541");
        pages.getPaymentPage().setExpirationBox("11");
        pages.getPaymentPage().setYearBox("2030");


        //Click 'Pay and Confirm Order' button
        pages.getPaymentPage().clickPayAndConfirmOrder();

       /*
        //Verify success message 'Your order has been placed successfully!'
        String yourOrderHasBeenPlacedSuccessfullyMessage = pages.getPaymentPage().getYourOrderHasBeenPlacedSuccessfullyMessage();
        softAssert.assertEquals(yourOrderHasBeenPlacedSuccessfullyMessage,"Your order has been placed successfully!");
        */

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String accountDeletedText = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedText,"ACCOUNT DELETED!");

        pages.getDeleteAccountPage().clickContinueButton();

        softAssert.assertAll();


    }
    @Test
    public void testCase_16PlaceOrderLoginBeforeCheckout(){

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //--------------------------------------------
        //Fill all details in Signup and create account
       signupApp("never@gmail.com","1234");

        //----------------------------------------------

        pages.getHomePage().clickSignupLoginButton();
        //Fill email, password and click 'Login' button
        pages.getLoginPage().setLoginEmailAddress("never@gmail.com");
        pages.getLoginPage().setLoginPassword("1234");
        pages.getLoginPage().clickLoginButton();

        //Verify ' Logged in as username' at top
        boolean isVisibleLoggedInAsMessage=pages.getHomePage().isVisibleLoggedInAsUserNameSection();
        softAssert.assertTrue(isVisibleLoggedInAsMessage,"ERROR : Verify that 'Logged in as username' is visible");


        //Add products to cart
        pages.getHomePage().clickProductButton();
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartButton5();
        pages.getProductsPage().clickContinueShoppingButton();

        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/view_cart");

        //Click 'Proceed To Checkout' button
        pages.getViewCartPage().clickProceedToCheckoutButton();

        //Verify Address Details and Review Your Order
        String addressDetailsText = pages.getCheckOutPage().getAddressDetailsText();
        softAssert.assertEquals(addressDetailsText, "Address Details");

        String reviewYourOrder = pages.getCheckOutPage().getReviewYourOrderText();
        softAssert.assertEquals(reviewYourOrder, "Review Your Order");

        //Enter description in comment text area and click 'Place Order'
        pages.getCheckOutPage().setMessageBox("are all these products made by %90 cotton");
        pages.getCheckOutPage().clickPlaceOrderButton();

        //Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pages.getPaymentPage().setNameOnCardBox("EnesCan1");
        pages.getPaymentPage().setCardNumberButton("60005421");
        pages.getPaymentPage().setCvcBox("541");
        pages.getPaymentPage().setExpirationBox("11");
        pages.getPaymentPage().setYearBox("2030");


        //Click 'Pay and Confirm Order' button
        pages.getPaymentPage().clickPayAndConfirmOrder();

        /*
        //Verify success message 'Your order has been placed successfully!'
        String yourOrderHasBeenPlacedSuccessfullyMessage = pages.getPaymentPage().getYourOrderHasBeenPlacedSuccessfullyMessage();
        softAssert.assertEquals(yourOrderHasBeenPlacedSuccessfullyMessage,"Your order has been placed successfully!");
        */

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String accountDeletedText = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedText,"ACCOUNT DELETED!");

        pages.getDeleteAccountPage().clickContinueButton();

        softAssert.assertAll();

    }
    public  void signupApp(String email,String password) {
        pages.getLoginPage().setSignupNewUserName("Belatrix");
        pages.getLoginPage().setSignupEmailAddressBox(email);
        pages.getLoginPage().clickSignupButton();

        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirt("10", "May", "2017");

        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        pages.getSignupPage().setFirstName("Enes");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("Oracle12");
        pages.getSignupPage().setAddress1("Utrect");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCountry("New Zealand");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("Lille");
        pages.getSignupPage().setZipCode("321004");
        pages.getSignupPage().setMobileNumber("16a5698956");

        pages.getSignupPage().clickCreateAccountButton();

        pages.getAccountCreatedPage().clickContinueButton();
        pages.getHomePage().clickLogOutButton();
    }


}
