package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.*;
import org.testng.Assert;

import static stepDefinitions.ST01_RegistrationStep.email;
import static stepDefinitions.ST01_RegistrationStep.password;

public class ST10_AddDifferentProductsToWhitListCard extends Hooks {
    P02_LoginPage loginPage;
    P03_HomePage homePage;
    P04_ShoesPage shoesPage;
    P05_NotebookPage notebookPage;
    @Given("user login correctly to the app")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user add one product from Notebooks in computer category to White List")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new P02_LoginPage(driver);
        homePage=new P03_HomePage(driver);
        notebookPage=new P05_NotebookPage(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        driver.findElements(notebookPage.getAddToCardButton()).get(0).click();
        Thread.sleep(4000);
        PageBase.scrollWithSpecificSize(driver,0,400);
        notebookPage.clickAddToWhiteListButton();
        Thread.sleep(3000);
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your wishlist");
    }

    @And("user add one product from Shoes in Apparel category to White List")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() throws InterruptedException {
        shoesPage=new P04_ShoesPage(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        driver.findElements(shoesPage.getAddToCardButton()).get(0).click();
        Thread.sleep(3000);
        PageBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.selectShoesSize();
        PageBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.clickAddToWhiteListButton();
        Thread.sleep(3000);
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your wishlist");
    }

    @Then("the selected two products should added correctly")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getWhiteListAmount(),"(3)");
        tearDown();
    }
}
