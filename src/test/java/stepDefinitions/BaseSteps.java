package stepDefinitions;

import config.BaseConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import utilities.PageHelper;

import java.util.Objects;

public class BaseSteps extends PageHelper{

    BasePage basePage = new BasePage();

    @Then("verify that {string} is visible successfully")
    public void verify_that_page_is_visible_successfully(String page) {
        if (Objects.equals(page, "home page")) {
            assertUrl(BaseConfig.getInstance().getUrl());
            basePage.acceptAllCookies();
        } else {
            assertUrl(BaseConfig.getInstance().getUrl() + page + "/");
        }
    }
    @When("user on the homepage")
    public void openHomePage() {
        basePage.HomePage();
    }
}
