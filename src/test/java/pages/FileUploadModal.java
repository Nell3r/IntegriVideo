package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FileUploadModal extends BasePage {
    public FileUploadModal(WebDriver driver) {
        super(driver);
    }

    public FileUploadModal isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(".integri-modal-shown"))));
        return this;
    }

    public FileUploadModal openPage() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
        isPageOpened();
        return this;
    }

    public void upLoadFile(String fileName) {
        String file = new File("src/test/resources/"+fileName).getAbsolutePath();
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        upload.sendKeys(file);
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

    public void assertUpload(int numberOfElements) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".integri-chat-message-type-file"),numberOfElements));
        List<WebElement> files = driver.findElements(By.cssSelector(".integri-chat-message-type-file"));
        assertEquals(files.size(), numberOfElements);
    }
}
