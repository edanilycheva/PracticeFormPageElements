package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;


public class Table extends BaseElement{

    private ElementsCollection resultsTable;

    public Table(SelenideElement container) {
        super(container);
        this.resultsTable = container.$$(".table").as("Таблица результов");

    }

    @Step("Проверить для '{key}' значение '{value}'")
    public void checkResultsValue(String key, String value) {
        resultsTable.findBy(text(key)).parent().shouldHave(text(value));

    }
}
