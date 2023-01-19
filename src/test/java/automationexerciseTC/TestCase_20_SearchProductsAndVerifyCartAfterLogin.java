package automationexerciseTC;

import org.testng.annotations.Test;

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

        pages.getLoginPage().setLoginEmailAddress("Enes321@gmail.com");
        pages.getLoginPage().setLoginPassword("2112");
        pages.getLoginPage().clickLoginButton();

        //Again, go to Cart page
        pages.getHomePage().clickCartButton();

        //Verify that those products are visible in cart after login as well
        boolean afterLoginAreProductsVisible = pages.getViewCartPage().areProductsVisible();
        softAssert.assertTrue(afterLoginAreProductsVisible);

        softAssert.assertAll();

    }
}
