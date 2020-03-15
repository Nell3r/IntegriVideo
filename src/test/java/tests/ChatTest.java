package tests;

import model.User;
import org.junit.Test;

import static org.graalvm.compiler.options.OptionType.User;


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
        chatPage.inviteUserButton();
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
        chatPage.sendText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec id maximus felis, et consectetur dui. Cras lobortis ligula dolor, at elementum libero laoreet eu. Praesent porta enim at nibh mollis imperdiet. Nullam dui risus, tempor eu suscipit vel, pulvinar vel tellus. Praesent tristique ultricies libero, fermentum tincidunt erat elementum vel. Aenean id orci pharetra, consectetur nulla ac, posuere diam. Nullam sodales orci neque, non interdum risus rhoncus non. Mauris ante nibh, sodales nec nisi ac, accumsan tempus sem. Vivamus consequat eros quis purus iaculis rhoncus. Vestibulum porta lorem odio, cursus tempor quam tincidunt vitae. Pellentesque vitae felis luctus, dapibus libero sit amet, mattis tortor. Donec sed ex leo");
        chatPage.enterSend();
        chatPage.messageShouldExist(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec id maximus felis, et consectetur dui. Cras lobortis ligula dolor, at elementum libero laoreet eu. Praesent porta enim at nibh mollis imperdiet. Nullam dui risus, tempor eu suscipit vel, pulvinar vel tellus. Praesent tristique ultricies libero, fermentum tincidunt erat elementum vel. Aenean id orci pharetra, consectetur nulla ac, posuere diam. Nullam sodales orci neque, non interdum risus rhoncus non. Mauris ante nibh, sodales nec nisi ac, accumsan tempus sem. Vivamus consequat eros quis purus iaculis rhoncus. Vestibulum porta lorem odio, cursus tempor quam tincidunt vitae. Pellentesque vitae felis luctus, dapibus libero sit amet, mattis tortor. Donec sed ex leo");
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
        chatPage.messageShouldExist(1, "<html><body><p>test</p></body></html>");
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
        chatPage.sendMessages("test");
        chatPage.messagesAssert("Skip");
    }
}
