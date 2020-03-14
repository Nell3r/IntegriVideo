package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class SettingModal extends BasePage {
    public SettingModal(WebDriver driver) {
        super(driver);
    }

    public void openSettings() {
        driver.findElement(By.cssSelector(".integri-chat-settings")).click();
    }

    public void changeName(String name) {
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys(name);
    }

    public void changeEmail(String mail) {
        driver.findElement(By.name("userEmail")).clear();
        driver.findElement(By.name("userEmail")).sendKeys(mail);
    }

    public void changeUrlPhoto(String URL) {
        driver.findElement(By.name("userPic")).sendKeys(URL);
    }

    public void clickSave() {
        driver.findElement(By.cssSelector(".integri-user-settings-save")).click();
    }

    public void assertUserName(String name) {
        WebElement username = driver.findElement(By.cssSelector(".integri-session-user-name"));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".integri-session-user-name"), name));
        String nameExist = username.getText();
        assertEquals(nameExist, name, "Не правильное имя");
    }

    public void assertEmailUser(String mail) {
        driver.findElement(By.cssSelector(".integri-chat-settings")).click();
        String newMail = driver.findElement(By.name("userEmail")).getAttribute("value");
        assertEquals(newMail, mail, "Не обновился имейл");
    }

    public void assertURLPhoto(String URL) {
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".integri-user-pic"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".integri-user-pic")));
        String urlstyle = driver.findElement(By.cssSelector(".integri-user-pic")).getAttribute("style");
        assertEquals(urlstyle, "background-image: url(\"" + URL + "\");", "Фото не поменялось");
    }
}
