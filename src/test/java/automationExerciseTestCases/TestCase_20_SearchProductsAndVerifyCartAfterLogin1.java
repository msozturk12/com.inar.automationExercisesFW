package automationExerciseTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.List;

public class TestCase_20_SearchProductsAndVerifyCartAfterLogin1 extends BaseTest {
    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    String searchedProduct="Men";
    @Test
    public void testCase2002(){
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        // Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
     softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/products");

     // Enter product name in search input and click search button
        pages.getProductsPage().setSearchProductBox(searchedProduct);
        pages.getProductsPage().clickSearchButton();

        //Verify 'SEARCHED PRODUCTS' is visible
        String searchedProductsText = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS",
                "ERROR-->Test Case 20 : Verify 'SEARCHED PRODUCTS' is visible");

        //Verify all the products related to search are visible
        List<String> listOfSearchedProducts = pages.getProductsPage().getListOfSearchedProducts();
        softAssert.assertTrue(listOfSearchedProducts.stream().allMatch(s->s.contains(searchedProduct)),
                "ERROR-->Test Case 20 : Verify all the products related to search are visible");

        //Add those products to cart
        pages.getProductsPage().clickAddToCartOfAllProducts();

        //Click 'Cart' button and verify that products are visible in cart
        pages.getProductsPage().clickCartButton();

        List<String> selectedProducts = pages.getViewCartPage().getSelectedProductsName();
        softAssert.assertEquals(listOfSearchedProducts,selectedProducts,
                "ERROR-->Test Case 20 : Verify searched products names are related");

        //Click 'Signup / Login' button and submit login details
        pages.getViewCartPage().clickSignUpLoginButton();
        //signupApp("neverEve@gmail.com","1234");

        //pages.getViewCartPage().clickSignUpLoginButton();
        pages.getLoginPage().setLoginEmailAddress("neverEve@gmail.com");
        pages.getLoginPage().setLoginPassword("1234");
        pages.getLoginPage().clickLoginButton();

        //Again, go to Cart page
        pages.getHomePage().clickCartButton();

        //Verify that those products are visible in cart after login as well
        List<String> selectedProducts2 = pages.getViewCartPage().getSelectedProductsName();
        softAssert.assertEquals(listOfSearchedProducts,selectedProducts2,
                "ERROR-->Test Case 20 : Verify searched products names are related");


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
