package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class FileUploadModal extends BasePage {
    public FileUploadModal(WebDriver driver) {
        super(driver);
    }

    public void openLoader() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
    }

    public void upLoadFile(String file) {
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        upload.sendKeys(file);
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

    public void assertUpload(int fileIndex) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".integri-chat-message-text")));
        List<WebElement> files = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        Boolean isExist = files.get(fileIndex - 1).isEnabled();
        assertTrue(isExist);
    }
}
