package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSMSVerificationPage extends BasePage{
    public RegisterSMSVerificationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'The verification code was sent via SMS.')]")
    private WebElement verificationCodeSentElement;

    public boolean isTheVeirficationCodeWasSentDisplayed(){
        return verificationCodeSentElement.isDisplayed();
    }

}
