package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AppPage;
import pages.ChatPage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    ChatPage chatPage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    AppPage appPage;
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        appPage = new AppPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
