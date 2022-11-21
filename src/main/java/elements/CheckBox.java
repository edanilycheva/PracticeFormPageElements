package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CheckBox extends BaseElement {

    private SelenideElement text;

    public CheckBox(SelenideElement container) {
        super(container);
        this.text = container;
    }

    @Step("Установить чек-бокс '{this.alias}' в состояние 'Установлен'")
    public void setChecked(String value) {
            text.shouldHave(Condition.text(value)).click();
    }

    @Step("Установить чек-бокс '{this.alias}' в состояние 'Не установлен'")
    public void setNotChecked(String value) {
            text.shouldHave(Condition.text(value)).click();
    }

}
