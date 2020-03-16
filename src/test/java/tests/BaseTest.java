package tests;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    User user = new User("devintegri@mailinator.com","qwer1234","https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1","Test");
    ChatPage chatPage;
    FileUploadModal fileUploadModal;
    SettingModal settingModal;
    LoginPage loginPage;
    AppPage appPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        fileUploadModal = new FileUploadModal(driver);
        settingModal = new SettingModal(driver);
        loginPage = new LoginPage(driver);
        appPage = new AppPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    //@AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
