package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class Table extends BaseElement{

    private ElementsCollection resultsTable;

    public Table(SelenideElement container) {
        super(container);
        this.resultsTable = container.$$(".table");

    }

    @Step("Проверить таблицу")
    public void checkResultsValue(String key, String value) {
        resultsTable.findBy(text(key)).parent().shouldHave(text(value));

    }
}
