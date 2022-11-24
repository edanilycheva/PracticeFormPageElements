package elements;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Button  extends BaseElement{

    protected SelenideElement description;

    public Button(SelenideElement container) {
        super(container);
    }

    @Step("Нажать на кнопку '{this.alias}'")
    public void press() {
        container.click();
    }



}
