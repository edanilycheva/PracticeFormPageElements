package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Button  extends BaseElement{

    protected SelenideElement description;

    public Button(SelenideElement container) {
        super(container);
     //   this.description = container.$x("./span[contains(@class,'text')]").as("Название кнопки");
    }

    @Step("Нажать на кнопку '{this.alias}'")
    public void press() {
        container.click();
    }

/*    @Step("Проверить текст на кнопке '{this.alias}'")
    public void checkDescription(String btnDescription){
        description.shouldHave(Condition.exactText(btnDescription));
    }*/

/*
    @Step("Проверить, что кнопка '{this.alias}' неактивна")
    public void checkDisableButton(){
        //container.shouldHave(cssClass("disabled"));
        System.out.println(container.getAttribute("disabled"));
    }

    @Step("Проверить, что кнопка '{this.alias}' активна")
    public void checkActiveButton(){
        container.shouldNotHave(cssClass("disabled"));
    }
*/

}
