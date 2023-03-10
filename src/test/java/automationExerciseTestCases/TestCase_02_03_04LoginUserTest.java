package automationExerciseTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TestCase_02_03_04LoginUserTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test


    @Test
    public void test_Case_2_LoginUserWithCorrectEmailAndPassword() {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        Assert.assertEquals(homePageTitle, "Home");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();
        signupApp("Weasly321@gmail.com","1234");


        //Verify 'Login to your account' is visible
        String logInToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(logInToYourAccountMessage, "Login to your account",
                "ERROR : Test Case 2 - Verify 'Login to your account' is visible\n");

        //Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress("Weasly321@gmail.com");
        pages.getLoginPage().setLoginPassword("1234");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify that 'Logged in as username' is visible
        boolean isVisibleLoggedInAsUsername = pages.getHomePage().isVisibleLoggedInAsUserNameSection();
        softAssert.assertTrue(isVisibleLoggedInAsUsername, "ERROR : Test Case 02 - Verify that 'Logged in as username' is visible");

        // Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String accountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!",
                "ERROR :Verify that 'ACCOUNT DELETED!' is visible");

        softAssert.assertAll();

    }


    @Test
    public void test_Case_3_LoginUserWithIncorrectEmailAndPassword() {

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        Assert.assertEquals(homePageTitle, "Home");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //Verify 'Login to your account' is visible
        String logInToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(logInToYourAccountMessage, "Login to your account",
                "ERROR : Test Case 2 - Verify 'Login to your account' is visible\n");

        //Enter incorrect email address and password
        pages.getLoginPage().setLoginEmailAddress("qwer@gmail.com");
        pages.getLoginPage().setLoginPassword(",ias,");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify error 'Your email or password is incorrect!' is visible
        String yourEmailOrPasswordIsIncorrectMessage = pages.getLoginPage().getYourEmailOrPasswordIsIncorrectMessage();
        softAssert.assertEquals(yourEmailOrPasswordIsIncorrectMessage, "Your email or password is incorrect!",
                "ERROR : Test Case 3 - Verify error 'Your email or password is incorrect!' is visible");

        softAssert.assertAll();

    }

    @Test
    public void test_Case_4_LogOutUser() {
        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        Assert.assertEquals(homePageTitle, "Home");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //Verify 'Login to your account' is visible
        String logInToYourAccountMessage = pages.getLoginPage().getLoginToYourAccountMessage();
        softAssert.assertEquals(logInToYourAccountMessage, "Login to your account",
                "ERROR : Test Case 2 - Verify 'Login to your account' is visible\n");


        //Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress("Hobby32@gmail.com");
        pages.getLoginPage().setLoginPassword("1234");

        //Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //Verify that 'Logged in as username' is visible
        boolean isVisibleLoggedInAsUsername = pages.getHomePage().isVisibleLoggedInAsUserNameSection();
        softAssert.assertTrue(isVisibleLoggedInAsUsername, "ERROR : Test Case 02 - Verify that 'Logged in as username' is visible\n");

        // Click 'Logout' button
        pages.getHomePage().clickLogOutButton();

        //Verify that user is navigated to login page
        String currentPageUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(currentPageUrl, "https://automationexercise.com/login",
                "ERROR : Test Case 04 - Verify that user is navigated to login page\n");
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