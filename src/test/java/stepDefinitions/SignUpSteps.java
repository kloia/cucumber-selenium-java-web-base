package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import stepDefinitions.Hooks; // Hooks sınıfını import etmeyi unutmayın.

public class SignUpSteps {

    private WebDriver webDriver;
    private SignUpPage signUpPage;

    public SignUpSteps() {
        this.webDriver = Hooks.getDriver(); // webDriver'ı başlatıyoruz.
        this.signUpPage = new SignUpPage(webDriver); // signUpPage nesnesini başlatıyoruz.
    }

    @Then("verify new user signup is visible")
    public void verifyNewUserSignupIsVisible() {
        signUpPage.verifyUserSignUpText();
    }

    @When("fill name and email address on sign up page")
    public void enterNameAndEmailAddress() {
        signUpPage.fillNameAndEmail();
    }

    @And("click sign up button on sign up page")
    public void clickSignupButton() {
        signUpPage.clickSignUpButton();
    }

    @And("fill details user information on sign up page")
    public void fillDetailsUserInformationOnSignUpPage() {
        signUpPage.fillUserInformation();
    }

    @And("select checkbox sign up for our newsletter and receive special offers from our partners")
    public void selectCheckboxSignUp() {
        signUpPage.selectAllCheckBox();
    }

    @Then("fill user address information on sign up page")
    public void fillUserAddressInformationOnSignUpPage() {
        signUpPage.fillUserAddressInformation();
    }

    @And("click create account button on sign up page")
    public void clickCreateAccountButtonOnSignUpPage() {
        signUpPage.clickCreateAccountButton();
    }

    @Then("verify that account created text is visible")
    public void verifyThatAccountCreatedTextIsVisible() {
        signUpPage.verifyCreateAccountText();
    }
}
