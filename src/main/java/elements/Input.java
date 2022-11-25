package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Input extends BaseElement{

    private SelenideElement input;


    public Input(SelenideElement container) {
        super(container);
        this.input = container.as("Поле ввода");

    }

    @Step("Проверить текст плейсхолдера '{placeholderText}'")
    public void checkInputPlaceholder(String placeholderText){
        input.shouldHave(Condition.attribute("placeholder",placeholderText));
    }

    @Step("Установить значение '{data}' в поле '{this.alias}'")
    public void setData(String data) {
        input.click();
        input.setValue(data);
    }

    @Step("Очистить поле ввода")
    public void clearInput(){
        input.clear();
    }

    @Step("Проверить, что поле ввода '{this.alias}' пустое")
    public void shouldBeEmpty(){
        input.shouldBe(Condition.empty);
    }


}
