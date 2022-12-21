package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.*;

import java.io.IOException;

import static stepDefinitions.ST01_RegistrationStep.email;
import static stepDefinitions.ST01_RegistrationStep.password;

public class ST12_CreateSuccessfulOrder extends Hooks {

    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P06_CheckOutPage checkOutPage;
    @Given("user login Successfully to Nop Commerce App")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user click go to card button and complete checkout")
    public void userClickGoToCardButtonAndCompleteCheckout() throws InterruptedException {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        checkOutPage=new P06_CheckOutPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.getShoppingCard());
        homePage.clickGoToCardButton();
        checkOutPage.checkTermsOfService();
        checkOutPage.ClickCheckoutButton();
        // fill billing address form
        checkOutPage.fillBillingAddress();
        Thread.sleep(2000);
        // choose shipping method
        checkOutPage.chooseShippingMethod();
        Thread.sleep(2000);
        // choose payment method
        checkOutPage.choosePaymentMethod();
        Thread.sleep(2000);
        // fill payment information
        checkOutPage.fillPaymentInformation();
        Thread.sleep(2000);
        // complete payment
        checkOutPage.confirmPayment();
    }

    @Then("order should created successfully")
    public void orderShouldCreatedSuccessfully() throws IOException {
        homePage.logout();
        tearDown();
        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
