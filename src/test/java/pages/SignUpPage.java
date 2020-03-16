package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.UUID;

import static org.testng.Assert.assertEquals;

public class SignUpPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn.btn-primary")
    WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public SignUpPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".iv-icon-user-plus"))));
        return this;
    }

    public SignUpPage openPage() {
        driver.get("https://dev.integrivideo.com/signup");
        isPageOpened();
        return this;
    }

    public SignUpPage enterRandomEmail(){
        emailField.sendKeys(UUID.randomUUID().toString()+"@gmail.com");
        return this;
    }
    public SignUpPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public SignUpPage clickSignUp(){
        signUpButton.click();
        return this;
    }
    public SignUpPage signUpVerification(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-notify='message']")));
       String message = driver.findElement(By.xpath("//span[@data-notify='message']")).getText();
       assertEquals(message,"Message with instructions was sent");
        return this;
    }
}
