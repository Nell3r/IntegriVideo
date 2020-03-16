package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage extends BasePage {
    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AppPage isPageOpened() {
        return this;
    }

    @Override
    public AppPage openPage() {
        return this;
    }

    public void addProject() {
        driver.findElement(By.cssSelector(".iv-icon-file-add")).click();
    }

    public void createForm(String name, String domain) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("domains[]")).sendKeys(domain);
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public void projectButton() {
        driver.findElement(By.cssSelector(".btn.actve")).click();
    }

    public void yourProject() {
        driver.findElement(By.xpath("//div[contains(text(),'TB')]")).click();
    }
}
