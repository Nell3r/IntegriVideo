package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.ChatPage;
import pages.FileUploadModal;
import pages.SettingModal;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    ChatPage chatPage;
    private WebDriver driver;
    FileUploadModal fileUploadModal;
    SettingModal settingModal;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        fileUploadModal = new FileUploadModal(driver);
        settingModal = new SettingModal(driver);
    }

    //@AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
