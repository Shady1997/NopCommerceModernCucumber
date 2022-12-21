package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.P02_LoginPage;
import org.testng.Assert;

import static stepDefinitions.ST01_RegistrationStep.email;

public class ST03_RestPasswordStep extends Hooks {

    P02_LoginPage loginPage;

    @Given("user is in login page and forget password")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user choose forget password link and add his email")
    public void userChooseForgetPasswordLinkAndAddHisEmail() {
        loginPage=new P02_LoginPage(driver);
        driver.findElement(loginPage.loginTap).click();
        loginPage.setPassword(email);
    }

    @Then("Confirmation message should appear to user to check mail")
    public void confirmationMessageShouldAppearToUserToCheckMail() {
        Assert.assertEquals(loginPage.getRecoverPasswordMessage(),"Email with instructions has been sent to you.");
        // extend report status
        test.log(LogStatus.PASS, "Password Reset Successfully");
        tearDown();
    }
}
