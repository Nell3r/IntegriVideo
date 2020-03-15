package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/login");
    }

    public void signUp() {
        driver.findElement(By.name("email")).sendKeys("integri1234@mailinator.com");
        driver.findElement(By.name("password")).sendKeys("qwerty1234");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }
}
