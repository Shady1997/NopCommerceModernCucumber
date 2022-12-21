package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class P04_ShoesPage {
    WebDriver driver;
    public P04_ShoesPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // elements in shoes page
//    @FindBy(xpath = "(//span[@class='attribute-square'])[2]")
    final private By redShoes=RelativeLocator.with(By.xpath("(//span[@class='attribute-square'])[2]"));
    public void filterShoes(){
        driver.findElement(redShoes).click();}
//    @FindBy(xpath = "//button[text()='Add to cart']")
    final private By addToCard=RelativeLocator.with(By.xpath("//button[text()='Add to cart']"));
//    @FindBy(xpath = "//button[text()='Add to wishlist']")
    final private By addToWhitList=RelativeLocator.with(By.xpath("//button[text()='Add to wishlist']"));
//    @FindBy(xpath = "//button[text()='Add to compare list']")
    final private By addToCompareList=RelativeLocator.with(By.xpath("//button[text()='Add to compare list']"));
//    @FindBy(id = "product_attribute_9")
    final private By shoesSize=RelativeLocator.with(By.xpath("//select[@id='product_attribute_9']"));
//    @FindBy(xpath = "//p[@class='content']")
    final private By confirmationMessage=RelativeLocator.with(By.xpath("//p[@class='content']"));
//    @FindBy(xpath = "(//button[text()='Add to wishlist'])[1]")
    final private By addWhiteListButton=RelativeLocator.with(By.xpath("(//button[text()='Add to wishlist'])[1]"));
    public void clickAddToWhiteListButton(){
        driver.findElement(addWhiteListButton).click();
    }
    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }
    public By getAddToCardButton(){return addToCard;}
    public By getAddToWhitList(){return addToWhitList;}
    public By getAddToCompareList(){return addToCompareList;}
    public void selectShoesSize(){
        Select select=new Select(driver.findElement(shoesSize));
        select.selectByIndex(1);
    }
}
