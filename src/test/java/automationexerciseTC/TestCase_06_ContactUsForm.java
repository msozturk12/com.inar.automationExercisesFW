package automationexerciseTC;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TestCase_06_ContactUsForm extends BaseTest{
    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    @Test
    public void test_Case_06_ContactUsForm(){

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        softAssert.assertEquals(homePageTitle, "Home");

        //Click on 'Contact Us' button
        pages.getHomePage().clickContactUsButton();

        // Verify 'GET IN TOUCH' is visible
        String getInTouchMessage = pages.getContactUsPage().getInTouchMessage();
        softAssert.assertEquals(getInTouchMessage,"GET IN TOUCH","ERROR : Test Case 6 -Verify 'GET IN TOUCH' is visible\n");

        // Enter name, email, subject and message

        pages.getContactUsPage().setEnterNameGetInTouch("mesut");
        pages.getContactUsPage().setEnterEmailGetInTouch("msozturk12@gmail.com");
        pages.getContactUsPage().setEnterSubjectGetInTouch("product");
        pages.getContactUsPage().setEnterMessageGetInTouch("i want to change my product...");

        //need to upload file...?
        pages.getContactUsPage().setUploadFileBox("C:\\Users\\mesut\\Desktop\\SDET\\screenshot.png");

        // Click 'Submit' button
        pages.getContactUsPage().clickSubmitButton();

        //Click OK button
        Driver.getDriver().switchTo().alert().accept();

        //Verify success message 'Success! Your details have been submitted successfully.' is visible

        String successMessage = pages.getContactUsPage().getSuccessYourDetailsHaveBeenSubmittedSuccessfullyMessage();
        softAssert.assertEquals(successMessage,"Success! Your details have been submitted successfully.",
                "ERROR : Test Case 6 -Verify success message 'Success! Your details have been submitted successfully.' is visible");

        //Click 'Home' button and verify that landed to home page successfully
        pages.getContactUsPage().clickHomeButton();

        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://automationexercise.com/",
                "ERROR : Test Case 6 -verify that landed to home page successfully");

        softAssert.assertAll();


    }
}
