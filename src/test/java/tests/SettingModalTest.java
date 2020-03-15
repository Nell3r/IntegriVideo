package tests;

import model.User;
import org.testng.annotations.Test;

public class SettingModalTest extends BaseTest {
    User user = new User("devintegri@mailinator.com","qwer1234","https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1","Test");

    @Test
    public void changeUserName() {
        settingModal.openPage();
        settingModal.changeName("Test");
        settingModal.clickSave();
        settingModal.assertUserName("Test");
    }

    @Test
    public void changeMail() {
        settingModal.openPage();
        settingModal.changeEmail("test@mail.com");
        settingModal.clickSave();
        settingModal.assertEmailUser("test@mail.com");
    }

    @Test
    public void changeURL() {
        settingModal.openPage();
        settingModal.changeUrlPhoto("https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1");
        settingModal.clickSave();
        settingModal.assertURLPhoto("https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1");
    }
    @Test
    public void testSettingModal(){
        settingModal
                .openPage()
                .changeName(user.getName())
                .changeEmail(user.getEmail())
                .changeUrlPhoto(user.getUrlPhoto())
                .clickSave()
                .assertURLPhoto(user.getUrlPhoto())
                .assertUserName(user.getName())
                .assertEmailUser(user.getEmail());
    }
}
