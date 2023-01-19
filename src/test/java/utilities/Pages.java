package utilities;

import pages.*;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignUpPage signupPage;
    private ProductsPage productsPage;
    private AccountCreatedPage accountCreatedPage;
    private DeleteAccountPage deleteAccountPage;

    private ContactUsPage contactUsPage;

    private ProductDetailPage productDetailPage;
    private ViewCartPage viewCartPage;

    private CheckOutPage checkOutPage;

    private PaymentPage paymentPage;

    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.signupPage = new SignUpPage();
        this.productsPage = new ProductsPage();
        this.accountCreatedPage = new AccountCreatedPage();
        this.deleteAccountPage = new DeleteAccountPage();
        this.contactUsPage = new ContactUsPage();
        this.productDetailPage = new ProductDetailPage();
        this.viewCartPage = new ViewCartPage();
        this.checkOutPage = new CheckOutPage();
        this.paymentPage = new PaymentPage();
    }

    public SignUpPage getSignupPage() {
        return signupPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public AccountCreatedPage getAccountCreatedPage() {
        return accountCreatedPage;
    }

    public DeleteAccountPage getDeleteAccountPage() {
        return deleteAccountPage;
    }

    public ContactUsPage getContactUsPage() {
        return contactUsPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }

    public ViewCartPage getViewCartPage() {
        return viewCartPage;
    }

    public CheckOutPage getCheckOutPage() {
        return checkOutPage;
    }

    public PaymentPage getPaymentPage() {
        return paymentPage;
    }
}
