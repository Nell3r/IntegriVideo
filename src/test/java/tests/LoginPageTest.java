package tests;

import org.junit.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void login(){
        loginPage
                .openPage()
                .login(user)
                .clickLogin()
                .addProject();
    }
}
