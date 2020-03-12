package tests;

import org.testng.annotations.Test;

public class SettingModalTest extends BaseTest {
    @Test
    public void changeName() {
        chatPage.openPage();
        chatPage.writeText("test");
        chatPage.clickSend();
        settingModal.assertUserName("Guest");
        settingModal.openSettings();
        settingModal.changeName("Test");
        settingModal.clickSave();
        settingModal.assertUserName("Test");
    }

    @Test
    public void changeMail() {
        chatPage.openPage();
        settingModal.openSettings();
        settingModal.changeEmail("test@mail.com");
        settingModal.clickSave();
        settingModal.assertEmailUser("test@mail.com");
    }

    @Test
    public void changeURL() {
        chatPage.openPage();
        settingModal.openSettings();
        settingModal.changeUrlPhoto("https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1");
        settingModal.clickSave();
        settingModal.assertURLPhoto("https://sun9-47.userapi.com/c836533/v836533215/12ff/G8OnjPQdLnU.jpg?ava=1");
    }
}
