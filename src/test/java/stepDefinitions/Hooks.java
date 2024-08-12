package stepDefinitions;

import config.BaseConfig;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.LogUtil;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.addAttachment;

public class Hooks {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    BaseConfig baseConfig = new BaseConfig();

    private Hooks() {
        String browser = baseConfig.getBrowser();
        switch (browser) {
            case "chrome" -> {
                try {
                    ChromeOptions options = new ChromeOptions();
                    if (baseConfig.getHeadless()) options.addArguments("--headless=new");
                    options.addArguments("-incognito");
                    options.setBrowserVersion("stable");
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                } catch (Exception e) {
                    LogUtil.logError(browser + " not run. e -> ", e);
                }
            }
            case "remote-chrome" -> {
                try {
                    ChromeOptions options = new ChromeOptions();
                    if (baseConfig.getHeadless()) {
                        options.addArguments("--headless=new");
                    }
                    options.addArguments("-incognito");
                    Map<String, Object> chrome_prefs = new HashMap<>();
                    chrome_prefs.put("intl.accept_languages", "tr");
                    options.setExperimentalOption("prefs", chrome_prefs);
                    driver.set(new RemoteWebDriver(new URL(baseConfig.getRemoteServerUrl()), options));
                } catch (Exception e) {
                    LogUtil.logError(browser + " not run. e -> ", e);
                }
            }
            case "remote-firefox" -> {
                try {
                    FirefoxOptions options = new FirefoxOptions();
                    if (baseConfig.getHeadless()) {
                        options.addArguments("--headless=new");
                    }
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    firefoxProfile.setPreference("intl.accept_languages", "tr");
                    options.setProfile(firefoxProfile);
                    options.addArguments("-incognito");
                    driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), options));
                } catch (Exception e) {
                    LogUtil.logError(browser + " not run. e -> ", e);
                }
            }
            default -> LogUtil.logWarning(browser + " not found");
        }
        WebDriver driverInstance = getDriver();
        driverInstance.manage().deleteAllCookies();
        driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(BaseConfig.MODERATE_WAIT_TIMEOUT_SECONDS));
        driverInstance.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(BaseConfig.MODERATE_WAIT_TIMEOUT_SECONDS));
        driverInstance.manage().timeouts().scriptTimeout(Duration.ofSeconds(BaseConfig.MODERATE_WAIT_TIMEOUT_SECONDS));
        driverInstance.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Before
    public static void setUpDriver(Scenario scenario) {
        LogUtil.logInfo(scenario.getName() + " -> scenario started");
        new Hooks();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LogUtil.logInfo("Scenario failed => " + scenario.getName());
            try {
                File screenshotAs = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String scenarioName = scenario.getName().replace(" ", "_");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mmss");
                LocalDateTime timestamp = LocalDateTime.now();
                String filename = scenarioName + "_" + timestamp.format(formatter) + ".png";
                addAttachment(filename, FileUtils.openInputStream(screenshotAs));
            } catch (Exception var) {
                LogUtil.logError("Fail scenario screenshot failed", var);
            }
        } else {
            LogUtil.logInfo("Scenario success => " + scenario.getName());
        }
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
