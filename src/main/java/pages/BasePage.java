package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver,20);
    }
    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void selectFromDropDownUsingVisibleText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectFromDropDownUsingIndex(WebElement element, int index){
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void testingOverideMethod(){
        System.out.println("I am in Basepage");
    }
}
