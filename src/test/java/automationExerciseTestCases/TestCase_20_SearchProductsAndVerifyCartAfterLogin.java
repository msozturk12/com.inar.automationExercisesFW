package automationExerciseTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

public class TestCase_20_SearchProductsAndVerifyCartAfterLogin extends BaseTest {
    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    @Test
    public void testCase_20SearchProductsAndVerifyCartAfterLogin() {
        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home",
                "ERROR-->Test Case 20 : Verify home page is visible");

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
        boolean allProductsText = pages.getProductsPage().allProductTitleIsVisible();
        softAssert.assertTrue(allProductsText,"ERROR-->Test Case 20 : Verify all products page is visible");


        //Enter product name in search input and click search button
        pages.getProductsPage().setSearchProductBox("Men");
        pages.getProductsPage().clickSearchButton();


        //Verify 'SEARCHED PRODUCTS' is visible
        String searchedProductsText = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS",
           "ERROR-->Test Case 20 : Verify 'SEARCHED PRODUCTS' is visible");

        //boolean searchedProductsText = pages.getProductsPage().isVisibleSearchedProductsMessage();
        //softAssert.assertTrue(searchedProductsText);


        //Verify all the products related to search are visible
        boolean menProducts = pages.getProductsPage().isMenProductsVisible();
        softAssert.assertTrue(menProducts);

        //Add those products to cart
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartButton5();
        pages.getProductsPage().clickContinueShoppingButton();

        //Click 'Cart' button and verify that products are visible in cart
        pages.getProductsPage().clickCartButton();

        boolean areProductsVisible = pages.getViewCartPage().areProductsVisible();
        softAssert.assertTrue(areProductsVisible);

        //Click 'Signup / Login' button and submit login details
        pages.getViewCartPage().clickSignUpLoginButton();

        signupApp("neverEve@gmail.com","1234");

        pages.getViewCartPage().clickSignUpLoginButton();
        pages.getLoginPage().setLoginEmailAddress("neverEve@gmail.com");
        pages.getLoginPage().setLoginPassword("1234");
        pages.getLoginPage().clickLoginButton();

        //Again, go to Cart page
        pages.getHomePage().clickCartButton();


        //Verify that those products are visible in cart after login as well
        boolean afterLoginAreProductsVisible = pages.getViewCartPage().areProductsVisible();
        softAssert.assertTrue(afterLoginAreProductsVisible);

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
