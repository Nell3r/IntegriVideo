package tests;

import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void login(){
        loginPage
                .openPage()
                .login(user)
                .clickLogin()
                .addProjectButton();
    }
}
