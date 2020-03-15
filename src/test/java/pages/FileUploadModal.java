package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".integri-chat-message-container")));
    }

    public void assertUpload(int numberOfElements) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".integri-chat-message-container")));
        List<WebElement> files = driver.findElements(By.cssSelector(".integri-chat-message-container"));
        assertEquals(files.size(), numberOfElements);
    }
}
