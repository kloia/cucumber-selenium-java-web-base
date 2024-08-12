package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DataGenerator;
import utilities.PageHelper;

public class SignUpPage extends BasePage {

    private WebDriver webDriver;
    private Faker faker;
    private Actions actions;

    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.faker = new Faker();
        this.actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUpText;

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement nameBox;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement email;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(css = "#uniform-id_gender1")
    public WebElement genderText;

    @FindBy(css = "input[id='password']")
    public WebElement passwordBox;

    @FindBy(css = "select[id='days']")
    public WebElement days;

    @FindBy(css = "select[id='months']")
    public WebElement month;

    @FindBy(css = "select[id='years']")
    public WebElement year;

    @FindBy(css = "label[for='newsletter']")
    public WebElement newsLetterButton;

    @FindBy(css = "label[for='optin']")
    public WebElement partnersButton;

    @FindBy(css = "input[id='first_name']")
    public WebElement firstNameBox;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccount;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedText;

    public void verifyUserSignUpText() {
        Assert.assertTrue(newUserSignUpText.isDisplayed());
    }

    public void fillNameAndEmail() {
        nameBox.sendKeys(DataGenerator.generateRandomName());
        email.sendKeys(DataGenerator.generateRandomEmail());
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void fillUserInformation() {
        genderText.click();
        passwordBox.sendKeys(DataGenerator.createPassword());
        PageHelper.pageDown();
        days.sendKeys(DataGenerator.generateRandomBirthday());
        month.sendKeys(DataGenerator.generateRandomBirthMonth());
        year.sendKeys(DataGenerator.generateRandomBirthYear());
    }

    public void selectAllCheckBox() {
        newsLetterButton.click();
        partnersButton.click();
    }

    public void fillUserAddressInformation() {
        actions.click(firstNameBox)
                .sendKeys(DataGenerator.generateRandomName())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomSurname())
                .sendKeys(Keys.TAB)
                .sendKeys("kloia")
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomCountry())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomCountry())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomCity())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomZipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(DataGenerator.generateRandomPhoneNumber())
                .perform();
    }

    public void clickCreateAccountButton() {
        createAccount.click();
    }

    public void verifyCreateAccountText() {
        Assert.assertTrue(accountCreatedText.isDisplayed());
    }
}
