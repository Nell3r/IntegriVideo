package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class SettingModal extends BasePage {
    @FindBy(name = "userName")
    WebElement userNameField;
    @FindBy(name = "userEmail")
    WebElement userEmailField;
    @FindBy(name = "userPic")
    WebElement userPicField;
    @FindBy(css = ".integri-user-settings-save")
    WebElement saveButton;
    @FindBy(css = ".integri-chat-settings")
    WebElement settingsPage;

    public SettingModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public SettingModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        return this;
    }
    public SettingModal openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        settingsPage.click();
        isPageOpened();
        return this;
    }


    public SettingModal changeName(String name) {
        userNameField.clear();
        userNameField.sendKeys(name);
        return this;
    }

    public SettingModal changeEmail(String mail) {
        userEmailField.clear();
        userEmailField.sendKeys(mail);
        return this;
    }

    public SettingModal changeUrlPhoto(String URL) {
        userPicField.sendKeys(URL);
        return this;
    }

    public SettingModal clickSave() {
        saveButton.click();
        return this;
    }

    public SettingModal assertUserName(String name) {
        WebElement username = driver.findElement(By.cssSelector(".integri-session-user-name"));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".integri-session-user-name"), name));
        String nameExist = username.getText();
        assertEquals(nameExist, name, "Не правильное имя");
        return this;
    }

    public SettingModal assertEmailUser(String mail) {
        settingsPage.click();
        String newMail = userEmailField.getAttribute("value");
        assertEquals(newMail, mail, "Не обновился имейл");
        return this;
    }

    public SettingModal assertURLPhoto(String URL) {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".integri-user-pic"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".integri-user-pic")));
        String urlstyle = driver.findElement(By.cssSelector(".integri-user-pic")).getAttribute("style");
        assertEquals(urlstyle, "background-image: url(\"" + URL + "\");", "Фото не поменялось");
        return this;
    }
}
