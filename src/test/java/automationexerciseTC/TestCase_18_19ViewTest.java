package automationexerciseTC;

import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase_18_19ViewTest extends BaseTest {
    @Test
    public void testCase18_ViewCategoryProducts() {
        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        // Verify that categories are visible on left side bar
        boolean categoryIsVisible = pages.getHomePage().areCategoriesVisible();
        softAssert.assertTrue(categoryIsVisible);

        //Click on 'Women' category
        pages.getHomePage().clickWomenCategory();

        //Click on any category link under 'Women' category, for example: TOPS
        pages.getHomePage().clickWomenTopsButton();

        //Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        String womanTopsProductsText = pages.getHomePage().getWomenTopsProductsText();
        softAssert.assertEquals(womanTopsProductsText, "WOMEN - TOPS PRODUCTS");

        //On left side bar, click on any sub-category link of 'Men' category
        pages.getHomePage().clickMenProductButton();
        pages.getHomePage().clickMenTshirtButton();

        //Verify that user is navigated to that category page
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/category_products/3");
        softAssert.assertAll();
    }
    @Test
    public void testCase19_ViewCartBrandProducts() {
        //Click on 'Products' button
       pages.getHomePage().clickProductButton();

       //Verify that Brands are visible on left side bar
        boolean isVisibleBrands = pages.getProductsPage().isVisibleBrandsText();
        softAssert.assertTrue(isVisibleBrands);

        // Click on any brand name
        pages.getProductsPage().clickBabyHugButton();

        //Verify that user is navigated to brand page and brand products are displayed
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/brand_products/Babyhug");

        String brandBabyHugProductText = pages.getProductsPage().getBrandBabyHugProductsText();
        softAssert.assertEquals(brandBabyHugProductText,"BRAND - BABYHUG PRODUCTS");

        //On left side bar, click on any other brand link
        pages.getProductsPage().clickPoloButton();

        //Verify that user is navigated to that brand page and can see products
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/brand_products/Polo");

        boolean areProductsVisible = pages.getProductsPage().isVisibleProducts();
        softAssert.assertTrue(areProductsVisible);

        softAssert.assertAll();

    }


}
