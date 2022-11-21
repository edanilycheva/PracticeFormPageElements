package elements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class RadioButton extends BaseElement{

    private SelenideElement label;
    public RadioButton (SelenideElement container){
        super(container);
        this.label = container.$("label");
    }

    @Step("Установить кнопку в состояние 'Установлен'")
    public void setChecked(String value) {
            label.shouldHave(Condition.text(value)).click();
    }

}
