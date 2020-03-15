package tests;

import org.testng.annotations.Test;

public class FileUploadModalTest extends BaseTest {
    @Test
    public void uploadfile() {
        chatPage.openPage();
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("C:/Users/User/IdeaProjects/IntegriVideo/src/main/resources/Text.txt");
        fileUploadModal.assertUpload(1);
    }

    @Test
    public void uploadFiles() {
        chatPage.openPage();
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("C:/Users/User/IdeaProjects/IntegriVideo/src/main/resources/Text.txt");
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("C:/Users/User/IdeaProjects/IntegriVideo/src/main/resources/Тестовый файл.docx");
        fileUploadModal.assertUpload(2);

    }
}
