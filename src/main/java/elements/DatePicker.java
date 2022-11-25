package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


public class DatePicker extends BaseElement{

    protected Button open;
    protected DropDownList month;
    protected DropDownList year;
    protected ElementsCollection enabledDays;




    public DatePicker(SelenideElement container) {
        super(container);
        this.open = new Button(container.$("input").as("Открытие календаря"));

        this.month = new DropDownList(container.$(".react-datepicker__month-select").as("Месяц")) {{
             btnOpen = new Button($(".react-datepicker__month-select").as("Месяц"));
             options = $$(".react-datepicker__month-select option").as("Месяц");
        }};

        this.year = new DropDownList(container.$(".react-datepicker__year-select").as("Год")) {{
              btnOpen = new Button($(".react-datepicker__year-select").as("Год"));
             options = $$(".react-datepicker__year-select option").as("Год");
        }};
        this.enabledDays = $$x("//div[contains(@class, 'react-datepicker__day--0') and not (contains(@class, 'react-datepicker__day--outside-month'))]").as("Доступные дни");

          }

    @Step("Открыть календарь")
    public void openCalendar() {
        open.press();
        $(".react-datepicker__month-container").shouldBe(Condition.visible);
    }

    @Step("Выбрать в календаре год {date}")
    public void setYear(String date) {
        year.openDdl();
        year.selectExactChoose(date);

    }

    @Step("Выбрать в календаре месяц {date}")
    public void setMonth(String date) {
        month.openDdl();
        month.selectExactChoose(date);

    }

    @Step("Выбрать в календаре день {date}")
    public void setDay(String date) {
        enabledDays.find(Condition.exactText(date)).click();

    }

}
