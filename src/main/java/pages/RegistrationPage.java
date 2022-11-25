package pages;


import elements.*;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    public RadioButton genderRadioBtn = new RadioButton($("#genterWrapper .custom-control-inline").as("Gender"));
    public Input firstNameInput = new Input($("#firstName").as("First Name"));
    public Input lastNameInput = new Input($("#lastName").as("Last Name"));
    public Input userEmailInput = new Input($("#userEmail").as("Email"));
    public Input mobileInput = new Input($("#userNumber").as("Mobile"));
    public Input addressInput = new Input($("#currentAddress").as("Current Address"));
    public CheckBox hobbiesCheckBox = new CheckBox($("#hobbiesWrapper .custom-control-label").as("Hobbies"));
    public UploadFile pictureUpload = new UploadFile($("#uploadPicture").as("Picture"));
    public Button submitBtn = new Button($("#submit").as("Submit"));
    public DropDownList subjectDdl = new DropDownList($("#subjectsInput").as("Subjects")){{
        input = new Input(container);
        options = $$(".subjects-auto-complete__menu").as("Элементы выпадающего списка");

    }};

    public DatePicker dateOfBirthDatePicker = new DatePicker($("#dateOfBirth-wrapper").as("Date of Birth"));

    public DropDownList stateDdl = new DropDownList($("#state").as("State")){{
        btnOpen = new Button($("#state").as("State"));
        options = $$x("//div[@class=' css-26l3qy-menu']/div/div").as("Элементы выпадающего списка");
    }};
    public DropDownList cityDdl = new DropDownList($("#city").as("City")){{
        btnOpen = new Button($("#city").as("City"));
        options = $$x("//div[@class=' css-26l3qy-menu']/div/div").as("Элементы выпадающего списка");
    }};
    public Table resultTable = new Table($(".table-responsive").as("Results"));

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

    }

}
