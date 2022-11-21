package elements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public abstract class BaseElement {

    protected SelenideElement container; //если простой, то сам элемент, если составной, но контейнер, где будут остальные элементы
    protected String alias;

    public BaseElement(SelenideElement container) {
        this.container = container;
        alias = (container.getAlias()!=null && !container.getAlias().isEmpty()) ? container.getAlias() : container.getSearchCriteria();
    }


    public void scrollIntoView(){
        container.scrollIntoView(true);
    }

    public void scrollTo(){
        container.scrollTo();
    }

    public SelenideElement shouldBe(Condition... var1){
        return container.shouldBe(var1);
    }

    public SelenideElement parent(){
        return container.parent();
    }

}
