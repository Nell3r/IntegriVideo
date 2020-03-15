package tests;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void signUp() {
        signUpPage.openPage();
        signUpPage.signUp();
    }
}
