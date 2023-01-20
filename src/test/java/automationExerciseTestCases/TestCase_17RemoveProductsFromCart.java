package automationExerciseTestCases;

import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase_17RemoveProductsFromCart extends BaseTest {

    @Test
    public void testCase_17RemoveProductsFromCart() throws InterruptedException {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Add products to cart
        pages.getHomePage().clickProductButton();
        pages.getProductsPage().clickAddToCartButton1();
        pages.getProductsPage().clickContinueShoppingButton();


        //Click 'Cart' button
        pages.getHomePage().clickCartButton();

        //Verify that cart page is displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart");

        //Click 'X' button corresponding to particular product
        pages.getViewCartPage().clickXButton();

        //Verify that product is removed from the cart
        String cartIsEmptyText = pages.getViewCartPage().getCartIsEmptyText();
        softAssert.assertNotEquals(cartIsEmptyText, "Cart is empty!");

        softAssert.assertAll();


    }

}
