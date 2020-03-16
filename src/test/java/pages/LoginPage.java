package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn-primary")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public LoginPage email(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage password(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public AppPage clickLogin(){
        loginButton.click();
        AppPage projects = new AppPage(driver);
        projects.isPageOpened();
        return projects;
    }
    public LoginPage openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        return this;
    }

    public LoginPage login (User user){
        email(user.getEmail());
        password(user.getPassword());
        clickLogin();
        return this;
    }
}
