package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector("textarea");

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
    }

    public void messageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message do not exist");
    }

    public void inviteUser() {
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
        driver.findElement(CHAT_INPUT).sendKeys(Keys.ENTER);
    }

    public void sendText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
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
        for (int i = 0; i < 11; i++) {
            driver.findElement(CHAT_INPUT).sendKeys(text);
            driver.findElement(CHAT_INPUT).sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.numberOfElementsToBe((By) driver.findElements(By.cssSelector(".integri-chat-message-text")), 1));
        }
    }
}
