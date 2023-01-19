package automationexerciseTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;


public class TestCase_09SearchProduct extends BaseTest{

    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    @Test
    public void TestCase_09_Search_Product(){

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click on 'Products' button
        pages.getHomePage().clickProductButton();

        //Verify user is navigated to ALL PRODUCTS page successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/products",
                "ERROR : Test Case 9 - Verify user is navigated to ALL PRODUCTS page successfully\n " );

        //Enter product name in search input and click search button
        pages.getProductsPage().setSearchProductBox("Men");
        pages.getProductsPage().clickSearchButton();

        // Verify 'SEARCHED PRODUCTS' is visible
        String searchedProducts = pages.getProductsPage().getSearchedProductsMessage();
        softAssert.assertEquals(searchedProducts,"SEARCHED PRODUCTS",
                "ERROR : Test Case 9 - Verify 'SEARCHED PRODUCTS' is visible\n ");


        //Verify all the products related to search are visible

        boolean areRelatedProductsVisible = pages.getProductsPage().isDisplayedMenProducts();
        softAssert.assertTrue(areRelatedProductsVisible);


        softAssert.assertAll();



    }




}
