package pages;


import elements.*;


import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    public RadioButton gender = new RadioButton($("#genterWrapper .custom-control-inline"));
    public Input firstName = new Input($("#firstName"));
    public Input lastName = new Input($("#lastName"));
    public Input userEmail = new Input($("#userEmail"));
    public Input mobile = new Input($("#userNumber"));
    public Input address = new Input($("#currentAddress"));
    public CheckBox hobbies = new CheckBox($("#hobbiesWrapper .custom-control-label"));
    public UploadFile picture = new UploadFile($("#uploadPicture"));
    public Button submit = new Button($("#submit"));
    public DropDownList subject = new DropDownList($("#subjectsInput")){{
        input = new Input(container);
        options = $$(".subjects-auto-complete__menu");

    }};

    public DatePicker dateOfBirth = new DatePicker($("#dateOfBirth-wrapper"));

    public DropDownList state = new DropDownList($("#state")){{
        btnOpen = new Button($("#state"));
        options = $$x("//div[@class=' css-26l3qy-menu']/div/div");
    }};
    public DropDownList city = new DropDownList($("#city")){{
        btnOpen = new Button($("#city"));
        options = $$x("//div[@class=' css-26l3qy-menu']/div/div");
    }};
    public Table result = new Table($(".table-responsive"));


}
