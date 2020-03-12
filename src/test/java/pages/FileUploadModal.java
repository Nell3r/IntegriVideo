package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadModal extends BasePage {
    public FileUploadModal(WebDriver driver) {
        super(driver);
    }

    public void openLoader() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
    }

    public void upLoadFile() {
        WebElement upload = driver.findElement(By.cssSelector(".integri-file-upload-manual-init"));
        upload.sendKeys(System.getProperty("user.dir") + "src/main/resources/G8OnjPQdLnU.jpg");
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }
}
