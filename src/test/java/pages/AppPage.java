package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.LoginPageTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AppPage extends BasePage {
    @FindBy(name = "name")
    WebElement projectNameField;
    @FindBy(css = "textarea")
    WebElement projectDescriptionField;

    public AppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public AppPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".iv-icon-file-add"))));
        return this;
    }

    public AppPage openPage() {
        driver.get("https://dev.integrivideo.com/app");
        return this;
    }

    public void addProjectButton() {
        driver.findElement(By.cssSelector(".iv-icon-file-add")).click();
    }

    public AppPage projectName(String name){
        projectNameField.sendKeys(name);
        return this;
    }
    public AppPage projectDescription(String description){
        projectDescriptionField.sendKeys(description);
        return this;
    }
    public AppPage projectDomain(int number,String domainName){
        List<WebElement> domains = driver.findElements(By.name("domains[]"));
        domains.get(number-1).sendKeys(domainName);
        return this;
    }
    public AppPage createButton(){
        driver.findElement(By.cssSelector(".btn")).click();
        return this;
    }
    public void verificationProject(int projectOnPage){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".iv-icon-file-add"))));
        List<WebElement> projects = driver.findElements(By.cssSelector(".project"));
        assertEquals(projects.size()-1,projectOnPage,"Не верное количество проетов");

    }
    public void projectButton() {
        driver.findElement(By.cssSelector(".btn.actve")).click();
    }

    public void yourProject() {
        driver.findElement(By.xpath("//div[contains(text(),'TB')]")).click();
    }
}
