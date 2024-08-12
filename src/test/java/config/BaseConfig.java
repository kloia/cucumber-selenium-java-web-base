package config;

public class BaseConfig {

    public static BaseConfig getInstance() {
        return new BaseConfig();
    }

    public static final int SHORT_WAIT_TIMEOUT_SECONDS = 5;
    public static final int MODERATE_WAIT_TIMEOUT_SECONDS = 15;
    public static final int GLOBAL_WAIT_TIMEOUT_SECONDS = 30;
    public static final int LONG_WAIT_TIMEOUT_SECONDS = 60;

    String browser = System.getProperty("browser");
    String env = System.getProperty("env");
    String headless = System.getProperty("headless");
    String locale = System.getProperty("locale");
    String threadCount = System.getProperty("threadCount");
    String remoteServerUrl = System.getProperty("remoteServerUrl");

    public String getBrowser() {
        System.out.println("browser: " + browser);
        return (browser != null) ? browser : "chrome";
    }

    public String getUrl() {
        env = (env != null) ? env : "test";
        String url = null;
        switch (env) {
            case "test" -> url = "https://automationexercise.com/";
            case "prod" -> url = "https://www.google.com/";
        }
        return url;
    }

    public Boolean getHeadless() {
        return Boolean.parseBoolean(headless);
    }

    public String getLocale() {
        return (locale != null) ? locale : "en";
    }

    public String getThreadCount() {
        return (threadCount != null) ? threadCount : "1";
    }

    public String getRemoteServerUrl() {
        System.out.println("remoteServerUrl: " + remoteServerUrl);
        return (remoteServerUrl != null) ? remoteServerUrl : "http://selenium-hub:4444/";
    }

}