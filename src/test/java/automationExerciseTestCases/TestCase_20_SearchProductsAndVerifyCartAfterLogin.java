package automationExerciseTestCases;

import org.testng.annotations.Test;
import pages.BasePage;

public class TestCase_20_SearchProductsAndVerifyCartAfterLogin extends BaseTest {

    @Test
    public void testCase_20SearchProductsAndVerifyCartAfterLogin() {
        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
        boolean allProductsText = pages.getProductsPage().allProductTitleIsVisible();
        softAssert.assertTrue(allProductsText);

        //Enter product name in search input and click search button
        pages.getProductsPage().setSearchProductBox("Men");
        pages.getProductsPage().clickSearchButton();


        //Verify 'SEARCHED PRODUCTS' is visible
        String searchedProductsText = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS");

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

        signupApp("neverEver@gmail.com","1234");

        pages.getLoginPage().setLoginEmailAddress("neverEver@gmail.com");
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
