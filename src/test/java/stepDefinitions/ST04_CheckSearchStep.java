package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.P02_LoginPage;
import org.example.pageObjects.P03_HomePage;

import static stepDefinitions.ST01_RegistrationStep.email;
import static stepDefinitions.ST01_RegistrationStep.password;

public class ST04_CheckSearchStep extends Hooks {

    P02_LoginPage loginPage;
    P03_HomePage homePage;

    @Given("user login to nop commerce web application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("search for product")
    public void searchForProduct() {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        loginPage.login(email,password);
        homePage.searchProducts();

    }

    @Then("results should appear correctly")
    public void resultsShouldAppearCorrectly(){
        homePage.checkSearchResult();
        // extend report status
        test.log(LogStatus.PASS, "Searching Work Correctly");
        tearDown();
//        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
