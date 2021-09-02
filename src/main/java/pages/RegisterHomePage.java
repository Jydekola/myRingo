package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterHomePage extends BasePage{
    public RegisterHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "field-Member_CLI")
    private WebElement mobileNumberElement;
    @FindBy(id = "field-Member_Email")
    private WebElement emailAddressElement;
    @FindBy(id = "field-MemberPassword")
    private WebElement passwordElement;
    @FindBy(css = "input[name='Marketing']")
    private WebElement productUpdateTickBoxElement;
    @FindBy(css = "input[name='DataSharing']")
    private WebElement thirdPartyTickBoxElement;
    @FindBy(css = "input[name='terms']")
    private WebElement termsAndConditionsElement;
    @FindBy(id = "labyrinth_UserDetails_next")
    private WebElement nextButtonElement;
    @FindBy(xpath = "//p[contains(text(),'There is an error in the form. Please check for details below.')]")
    private WebElement errorMessageElement;
    @FindBy(css = "span.error')]")
    private List<WebElement> errorMessagesElements;

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberElement.sendKeys(mobileNumber);
    }
    public void enterEmailAddress(String email) {
        emailAddressElement.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void clickOnProductUpdateOption() {
        productUpdateTickBoxElement.click();
    }
    public void clickOnThirdPartyTickBox() {
        thirdPartyTickBoxElement.click();
    }
    public void clickOnAcceptTermsAndConditions() {
        termsAndConditionsElement.click();
    }
    public void clickOnNextButton() {
        nextButtonElement.click();
    }

    public boolean isErrorOnFormMessageDisplayed(){
        return errorMessageElement.isDisplayed();
    }

    public String getMobileNumberErrorMessage(){
        return errorMessagesElements.get(0).getText();
    }
    public String getEmailErrorMessage(){
        return errorMessagesElements.get(1).getText();
    }
    public String getPasswordErrorMessage(){
        return errorMessagesElements.get(2).getText();
    }
    public String getTermsAndConditionsErrorMessage(){
        return errorMessagesElements.get(4).getText();
    }
}
