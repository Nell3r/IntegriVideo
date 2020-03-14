package tests;

import org.testng.annotations.Test;

public class FileUploadModalTest extends BaseTest {
    @Test
    public void upload() {
        chatPage.openPage();
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("C:/Users/User/IdeaProjects/IntegriVideo/src/main/resources/Text.txt");
        fileUploadModal.assertUpload(1);
        fileUploadModal.openLoader();
        fileUploadModal.upLoadFile("C:/Users/User/IdeaProjects/IntegriVideo/src/main/resources/Тестовый файл.docx");
        fileUploadModal.assertUpload(2);
    }
}
