import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IntegriVideo {
    @Test
    public void locators() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='btn']"));
        driver.findElement(By.cssSelector(".integri-watermark"));
        driver.findElement(By.xpath("//button[@title='Video conference']"));
        driver.findElement(By.xpath("//button[@title='Send message']"));
        driver.findElement(By.tagName("textarea"));
        driver.findElement(By.xpath("//span[@class='iv-icon iv-icon-cog']")).click();
        driver.findElement(By.name("userName"));
        driver.findElement(By.name("userEmail"));
        driver.findElement(By.name("userPic"));
        driver.findElement(By.xpath("//button[text()='Save']"));
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-cross"));
        driver.findElement(By.xpath("//a[text()='Cancel']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Drag & drop')]")).click();
        driver.findElement(By.xpath("//span[text()='browse']"));
        driver.findElement(By.xpath("//button[text()='Start']"));
        driver.findElement(By.xpath("//button[text()='Cancel']")).click();
    }
}
