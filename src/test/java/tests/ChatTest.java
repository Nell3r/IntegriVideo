package tests;

import org.testng.annotations.Test;

public class ChatTest extends BaseTest {
    @Test
    public void sendMessage() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "Text");
    }

    @Test
    public void inviteButton() {
        chatPage.openPage();
        chatPage.inviteUser();
    }

    @Test
    public void enterSend() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.enterSend();
        chatPage.messageShouldExist(1, "Text");
    }

    @Test
    public void sendText() {
        chatPage.openPage();
        String result = chatPage.sendText("Text.txt");
        chatPage.enterSend();
        chatPage.shouldHaveMessage(1, result.trim());
    }

    @Test
    public void sendURL() {
        chatPage.openPage();
        chatPage.writeText("http://tms-auto.tilda.ws/");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "http://tms-auto.tilda.ws/");
    }

    @Test
    public void sendCode() {
        chatPage.openPage();
        chatPage.writeText("<html><body><p>test</p></body></html>");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "test");
    }

    @Test
    public void formatMessage() {
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.clickSend();
        chatPage.formatMessage("FormatText");
        chatPage.enterSend();
        chatPage.messageShouldExist(1, "FormatText");
    }

    @Test
    public void deleteMessage() {
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.clickSend();
        chatPage.deleteMessage();
        chatPage.messageShouldExist(1, "removed...");
    }

    @Test
    public void deleteText() {
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.clickSend();
        chatPage.formatMessage("");
        chatPage.enterSend();
        chatPage.assertError();
    }

    @Test
    public void sendMessages() {
        chatPage.openPage();
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chatPage.writeText("Test");
            chatPage.clickSend();
        }
    }
}
