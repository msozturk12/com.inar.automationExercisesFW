package automationexercise;

import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class TestCase_24DownloadInvoiceAfterPurchaseOrder extends BaseTest {

    @Test
    public void testcase_24Download_Invoice_After_Purchase_Order() {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home", "ERROR : Test Case 1 - Verify that home page is visible successfull\n");

        //Add products to cart
        pages.getHomePage().clickAddToCartButton7();
        pages.getHomePage().clickContinueShopping();
        pages.getHomePage().clickAddToCartButton13();
        pages.getHomePage().clickContinueShopping();


        // Click 'Cart' button
        pages.getHomePage().clickCartButton();


        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");

        //Click Proceed To Checkout
        pages.getViewCartPage().clickProceedToCheckoutButton();


        //Click 'Register / Login' button
        pages.getViewCartPage().clickRegisterLoginButton();

        //Fill all details in Signup and create account
        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName("Zeynep");
        pages.getLoginPage().setSignupEmailAddressBox("Yujkilop3205@gmail.com");
        pages.getLoginPage().clickSignupButton();

        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("2112");
        pages.getSignupPage().setDateOfBirt("10", "May", "2007");

        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        pages.getSignupPage().setFirstName("Zeynep");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("JetBrain");
        pages.getSignupPage().setAddress1("TillBurg");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCountry("Canada");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("London");
        pages.getSignupPage().setZipCode("32100");
        pages.getSignupPage().setMobileNumber("165698956");

        pages.getSignupPage().clickCreateAccountButton();

        //Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String accountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!",
                "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n");

        pages.getAccountCreatedPage().clickContinueButton();

        //Verify ' Logged in as username' at top

        String loggedInAsMessage = pages.getHomePage().getLoggedInAsMessage();
        softAssert.assertEquals(loggedInAsMessage, "Logged in as Zeynep",
                "ERROR : Verify that 'Logged in as username' is visible");

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
        pages.getCheckOutPage().setMessageBox("are all these products made by %90 cotton it can be %100");
        pages.getCheckOutPage().clickPlaceOrderButton();


        // Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pages.getPaymentPage().setNameOnCardBox("Zeynep");
        pages.getPaymentPage().setCardNumberButton("60005421");
        pages.getPaymentPage().setCvcBox("541");
        pages.getPaymentPage().setExpirationBox("11");
        pages.getPaymentPage().setYearBox("2026");


        //Click 'Pay and Confirm Order' button
        pages.getPaymentPage().clickPayAndConfirmOrder();

        /*
        //Verify success message 'Your order has been placed successfully!'
         String yourOrderHasBeenPlacedSuccessfullyMessage = pages.getPaymentPage().getYourOrderHasBeenPlacedSuccessfullyMessage();
         softAssert.assertEquals(yourOrderHasBeenPlacedSuccessfullyMessage, "Your order has been placed successfully!");
         */

        //Click 'Download Invoice' button and verify invoice is downloaded successfully
        pages.getPaymentPage().clickDownloadInvoiceButton();
        pages.getPaymentPage().verifyIsDownloaded();

        // Click 'Continue' button
        pages.getPaymentPage().clickContinueButton();

        //Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String accountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!",
                "ERROR :Verify that 'ACCOUNT DELETED!' is visible");

        pages.getDeleteAccountPage().clickContinueButton();
        softAssert.assertAll();

    }

}
