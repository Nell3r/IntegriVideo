package tests;

import org.testng.annotations.Test;

import java.io.File;

public class FileUploadModalTest extends BaseTest {
    @Test
    public void uploadfile() {
        chatPage.openPage();
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("Text.txt");
        fileUploadModal.assertUpload(1);
    }

    @Test
    public void uploadFiles() {
        chatPage.openPage();
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("Text.txt ");
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("Тестовый файл.docx");
        fileUploadModal.assertUpload(2);

    }
}
