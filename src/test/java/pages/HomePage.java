package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageHelper;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".fa.fa-lock")
    public WebElement signUpButton;

    public void clickSignUpButton() {
        PageHelper.clickElement(signUpButton);
    }
}
