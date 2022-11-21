import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class RegistrationTest {

    private RegistrationPage registrationPage = new RegistrationPage();

    @BeforeSuite
    static void BeforeSuite() {
        Configuration.browserSize = "1920x1080";
    }
    @Test

    public void registration(){
        open("https://demoqa.com/automation-practice-form");
        registrationPage.gender.setChecked("Male");
        registrationPage.firstName.checkInputPlaceholder("First Name");
        registrationPage.firstName.setData("Вася");
        registrationPage.lastName.setData("Смирнов");
        registrationPage.userEmail.setData("vasyasmirnov@test.ru");
        registrationPage.mobile.setData("79109448205");
        registrationPage.dateOfBirth.openCalendar();
        registrationPage.dateOfBirth.setYear("2008");

        registrationPage.dateOfBirth.setMonth("July");
        registrationPage.dateOfBirth.setDay("30");
        registrationPage.hobbies.setChecked("Sports");
        registrationPage.address.setData("Test address");
        registrationPage.picture.uploadFile("pic.png");
       // registrationPage.state.openDdl();
       // registrationPage.state.inputValue("NCR");
       // registrationPage.city.openDdl();
       // registrationPage.city.inputValue("Delhi");


    }
}
