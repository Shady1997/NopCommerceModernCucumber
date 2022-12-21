package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.P01_RegistrationPage;
import org.example.pageObjects.PageBase;
import org.testng.Assert;

public class ST01_RegistrationStep extends Hooks {

    P01_RegistrationPage registrationPage;
    public static String email;
    public static String password;
    @Given("user is in main page")
    public void userInMainPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user choose register tap")
    public void userChooseRegisterTap() {
        registrationPage=new P01_RegistrationPage(driver);
        driver.findElement(registrationPage.registerTap).click();
    }

    @And("fill all data and click register button")
    public void fillAllDataAndClickRegisterButton() {
        email=PageBase.generateString(5)+"@yahoo.com";
        password=PageBase.generateString(5)+PageBase.generateInteger(100);
        registrationPage.registerNewUser(
                PageBase.generateString(5),
                PageBase.generateString(5),
                email,
                PageBase.generateString(5),
                password);
    }

    @Then("user navigate to user page")
    public void userNavigateToHomePage() {
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));
        driver.findElement(registrationPage.continueButton).click();
        Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
        // extend report status
        test.log(LogStatus.PASS, "Register Successfully to Application");
        tearDown();
    }
}
