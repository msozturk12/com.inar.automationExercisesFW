package automationexercise;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase_01_05Registration extends BaseTest {

    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    @BeforeSuite
    public void setUpSuite() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        System.out.println("::::::Test Information ::::::\n\tURL :" + URL + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);

    }

    @Test(priority = 0)
    public void TestCase_1_Register_User() {
        //Launch browser and Navigate to url 'http://automationexercise.com'

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        Assert.assertEquals(homePageTitle, "Home");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();


        //Verify 'New User Signup!' is visible
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!",
                "ERROR : Test Case 1 - Verify 'New User Signup!' is visible\n");


        //Enter name and email address
        pages.getLoginPage().setSignupNewUserName("Johnnn");
        pages.getLoginPage().setSignupEmailAddressBox("JohnnOz1234@gmail.com");

        // Click 'Signup' button
        pages.getLoginPage().clickSignupButton();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION",
                "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");


        // Fill details: Title, Name, Email, Password, Date of birth
        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("2112");
        pages.getSignupPage().setDateOfBirt("10", "May", "2007");

        // Select checkbox 'Sign up for our newsletter!'
        pages.getSignupPage().selectCheckboxSignUpForOurNewsletter();


        //Select checkbox 'Receive special offers from our partners!'
        pages.getSignupPage().selectCheckboxReceiveSpecialOffersFromOurPartners();

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        pages.getSignupPage().setFirstName("Mesut");
        pages.getSignupPage().setLastName("OZTURK");
        pages.getSignupPage().setCompanyName("Oracle");
        pages.getSignupPage().setAddress1("TillBurg");
        pages.getSignupPage().setAddress2("Harleem");
        pages.getSignupPage().setCompanyName("Canada");
        pages.getSignupPage().setState("Yorkshire");
        pages.getSignupPage().setCity("London");
        pages.getSignupPage().setZipCode("32100");
        pages.getSignupPage().setMobileNumber("165698956");

        // Click 'Create Account button'
        pages.getSignupPage().clickCreateAccountButton();

        //Verify that 'ACCOUNT CREATED!' is visible
        String accountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(accountCreatedMessage,"Account Created!",
                "ERROR : Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible\n" );

        //Click 'Continue' button
        pages.getAccountCreatedPage().clickContinueButton();

       BrowserUtils.navigateBackAndForwardToDismissAds();

        //Verify that 'Logged in as username' is visible
        //String name = pages.getLoginPage().getSignUpName();

        String loggedInAsMessage = pages.getHomePage().getLoggedInAsMessage();
        softAssert.assertEquals(loggedInAsMessage,"Logged in as Johnn",
                "ERROR : Verify that 'Logged in as username' is visible");

        // Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String accountDeletedMessage = pages.getDeleteAccountPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage,"ACCOUNT DELETED!",
                "ERROR :Verify that 'ACCOUNT DELETED!' is visible");

        pages.getDeleteAccountPage().clickContinueButton();


    }

    @Test
    public void Test_Case_5_RegisterUserWithExistingEmail(){

        //Verify that home page is visible successfull
        String homePageTitle = pages.getHomePage().getHomePageHomeTitle();
        Assert.assertEquals(homePageTitle, "Home");

        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();


        //Verify 'New User Signup!' is visible
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignUpMessage, "Verify 'New User Signup!' is visible",
                "ERROR : Test Case 5 - Verify 'New User Signup!' is visible\n");

        // Enter name and already registered email address
        pages.getLoginPage().setSignupNewUserName("Johnn");
        pages.getLoginPage().setSignupEmailAddressBox("msozturk1jklkk2@gmail.com");

        //Click 'Signup' button
        pages.getLoginPage().clickSignupButton();


        //Verify error 'Email Address already exist!' is visible
        String emailAddressAlreadyExistErrorMessage=pages.getLoginPage().getEmailAddressAlreadyExistErrorMessage();
        softAssert.assertEquals(emailAddressAlreadyExistErrorMessage,"Email Address already exist!",
               "ERROR : Test Case 5 - Verify error 'Email Address already exist!' is visible\n" );

    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }

}
