package tests;

import model.User;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    @Test
    public void addProject() {
        appPage.openPage();
        loginPage.login(user);
        appPage.addProjectButton();
        appPage
                .projectName("Test")
                .projectDescription("Test")
                .projectDomain(1,"test.com")
                .projectDomain(2,"test2.com")
                .createButton();
        appPage.verificationProject(1);
    }
}
