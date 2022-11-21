package elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class UploadFile extends BaseElement{
    protected SelenideElement file;
    public UploadFile(SelenideElement container) {
        super(container);
        this.file = container;

    }
    @Step("Загрузить файл")
    public void uploadFile(String value){
        file.uploadFromClasspath(value);

    }

}
