package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class P01_RegistrationPage {
    WebDriver driver;

    public P01_RegistrationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // registration tap
//    @FindBy(xpath = "//a[@class='ico-register']")
    public By registerTap= RelativeLocator.with(By.xpath("//a[@class='ico-register']"));

    // user data
//    @FindBy(xpath = "(//input[@type='radio'])[1]")
    final private By gender=RelativeLocator.with(By.xpath("(//input[@type='radio'])[1]"));
//    @FindBy(xpath = "//input[@name='FirstName']")
    final private By firstName=RelativeLocator.with(By.xpath("//input[@name='FirstName']"));
//    @FindBy(xpath = "//input[@name='LastName']")
    final private By lastName=RelativeLocator.with(By.xpath("//input[@name='LastName']"));
//    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    public By continueButton=RelativeLocator.with(By.xpath("//a[@class='button-1 register-continue-button']"));
//    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    final private By dayOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthDay']"));
//    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    final private By monthOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthMonth']"));
//    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    final private By yearOfBirth=RelativeLocator.with(By.xpath("//select[@name='DateOfBirthYear']"));
//    @FindBy(xpath = "//input[@type='email']")
    final private By email=RelativeLocator.with(By.xpath("//input[@type='email']"));
//    @FindBy(xpath = "//input[@name='Company']")
    final private By company=RelativeLocator.with(By.xpath("//input[@name='Company']"));
//    @FindBy(xpath = "(//input[@type='password'])[1]")
    final private By password=RelativeLocator.with(By.xpath("(//input[@type='password'])[1]"));
//    @FindBy(xpath = "(//input[@type='password'])[2]")
    final private By confirmPassword=RelativeLocator.with(By.xpath("(//input[@type='password'])[2]"));
//    @FindBy(xpath = "(//button[@type='submit'])[2]")
    final private By registerButton=RelativeLocator.with(By.xpath("(//button[@type='submit'])[2]"));

    public void registerNewUser(
            String fname,
            String lname,
            String useerEmail,
            String companyName,
            String userPassword){
        // TODO: add new user
        // fill user data
        driver.findElement(gender).click();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);

        Select select=new Select(driver.findElement(dayOfBirth));
        select.selectByIndex(1);
        select=new Select(driver.findElement(monthOfBirth));
        select.selectByIndex(1);
        select=new Select(driver.findElement(yearOfBirth));
        select.selectByIndex(1);

        driver.findElement(email).sendKeys(useerEmail);
        driver.findElement(company).sendKeys(companyName);

        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(confirmPassword).sendKeys(userPassword);

        driver.findElement(registerButton).click();
    }

}
