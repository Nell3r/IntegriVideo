package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {
    @FindBy(css = "textarea")
    WebElement textarea;

    public ChatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ChatPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(textarea));
        return this;
    }

    public ChatPage openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        isPageOpened();
        return this;
    }

    public void writeText(String text) {
        textarea.sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
    }

    public void messageShouldExist(int messageIndex, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".integri-chat-message")));
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message do not exist");
    }

    public void inviteUserButton() {
        driver.findElement(By.id("invite-users-to-chat")).click();
        try {
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            assertEquals(driver.getCurrentUrl(), data, "Разные ссылки");
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enterSend() {
        textarea.sendKeys(Keys.ENTER);
    }

    public void sendText(String text) {
        textarea.sendKeys(text);
    }

    public void formatMessage(String text) {
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-pencil")).click();
        driver.findElement(By.cssSelector("textarea")).clear();
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
    }

    public void deleteMessage() {
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-trash2")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void assertError() {
        String error = driver.findElement(By.cssSelector(".integri-notify.integri-notify-error")).getText();
        assertEquals(error, "Message cannot be empty!");
    }

    public void sendMessages(String text) {
        for (int i = 1; i < 12; i++) {
            textarea.sendKeys(text);
            textarea.sendKeys(Keys.ENTER);
            if (i != 11) {
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".integri-chat-message-text"), i));
            } else {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".close-demo-screen")));
            }
        }
    }

    public void messagesAssert(String textButtonAlert) {
        WebElement closeScreen = driver.findElement(By.cssSelector(".close-demo-screen"));
        String textScreen = closeScreen.getText();
        assertEquals(textScreen, textButtonAlert, "ошибка не появилась");
    }
}
