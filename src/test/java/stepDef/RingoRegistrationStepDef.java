package stepDef;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterHomePage;
import pages.RegisterSMSVerificationPage;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RingoRegistrationStepDef extends BaseUtil {
    private BaseUtil base;

    public RingoRegistrationStepDef(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on a the Ringo Registration Home screen {string}")
    public void i_am_on_a_the_ringo_registration_home_screen(String url) {
        base.driver.manage().window().maximize();
base.driver.get(url);
    }
    @When("I enter valid {string}, {string} and {string}")
    public void i_enter_valid_and(String mobileNumber, String emailAddress, String pword) {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
                registerHomePage.enterMobileNumber(mobileNumber);
        registerHomePage.enterEmailAddress(emailAddress);
        registerHomePage.enterPassword(pword);

    }
    @When("I tick option to get emails")
    public void i_tick_option_to_get_emails() {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        registerHomePage.clickOnProductUpdateOption();
    }
    @When("I tick option to share my info with third party partners")
    public void i_tick_option_to_share_my_info_with_third_party_partners() {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        registerHomePage.clickOnThirdPartyTickBox();
    }
    @When("I agree to the Terms and Conditions and Privacy option")
    public void i_agree_to_the_terms_and_conditions_and_privacy_option() {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        registerHomePage.clickOnAcceptTermsAndConditions();
    }
    @When("I click Next button")
    public void i_click_next_button() {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        registerHomePage.clickOnNextButton();
    }


    @Then("sms verification page is displayed")
    public void smsVerificationPageIsDisplayed() {
        RegisterSMSVerificationPage registerSMSVerificationPage = new RegisterSMSVerificationPage(base.driver);
        assertThat(registerSMSVerificationPage.isTheVeirficationCodeWasSentDisplayed(), is(equalTo(true)));
    }

    @Then("error in the form is dispalyed")
    public void errorInTheFormIsDispalyed() {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        assertThat(registerHomePage.isErrorOnFormMessageDisplayed(), is(equalTo(true)));
    }


    @And("{string} msg is displayed under the {string} field")
    public void msgIsDisplayedUnderTheField(String errorMsg, String arg1) {
        RegisterHomePage registerHomePage = new RegisterHomePage(base.driver);
        assertThat(registerHomePage.getMobileNumberErrorMessage(), is(equalTo(errorMsg)));
    }

    @And("{string} msg is displayed under the Terms and Conditions")
    public void msgIsDisplayedUnderTheTermsAndConditions(String errorMsg) {
        msgIsDisplayedUnderTheField(errorMsg, "a1");
    }
}
