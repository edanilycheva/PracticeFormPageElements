package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$$;

public  class DropDownList extends BaseElement {

    public Input input;
    protected SelenideElement nameFilter;
    protected Button btnOpen;
    public ElementsCollection options;
    protected Button btnClear;


    public DropDownList(SelenideElement container) {
        super(container);
    }

    public DropDownList select() {
        return this;
    }

    @Step("Открыть выпадающий список '{this.alias}'")
    public void openDdl() {
        btnOpen.press();
        options.first().shouldBe(Condition.visible);
    }

    @Step("Закрыть выпадающий список '{this.alias}'")
    public void closeDdl() {
        btnOpen.press();
        options.first().shouldNotBe(Condition.visible);
    }

    @Step("Выбрать значение '{optionText}' в выпадающем списке '{this.alias}'")
    public void selectExactChoose(String optionText) {
        ElementsCollection filteredOptions = $$(options).filter(Condition.text(optionText));
        filteredOptions.shouldHave(CollectionCondition.sizeGreaterThan(0));
        filteredOptions.get(0).click();

    }

    @Step("Ввести значение '{valueText}' в фильтр '{this.alias}'")
    public void inputValue(String valueText) {
        input.setData(valueText);
        options.first().shouldBe(Condition.visible);
    }



}
