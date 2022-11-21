package pages;


import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
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

 //   public CalendarComponent calendarComponent = new CalendarComponent();
    public DatePicker dateOfBirth = new DatePicker($("#dateOfBirth-wrapper"));


   // public DropDownList state = new DropDownList($("#state"));
   // public DropDownList city = new DropDownList($("#state"));







}
