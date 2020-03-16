package tests;

import model.User;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    @Test
    public void addProject() {
        loginPage.login(user);
        appPage.addProject();
        appPage.createForm("tut.by", "tut.by");
    }

    @Test
    public void yourProject() {
        addProject();
        appPage.projectButton();
        appPage.yourProject();
    }
}
