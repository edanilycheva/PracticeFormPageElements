import com.codeborne.selenide.Configuration;
import models.StateAndCity;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.codeborne.selenide.Selenide.open;



public class RegistrationTest {

    private final StateAndCity fromNCRState = new StateAndCity(StateAndCity.TypeOfState.FROM_NCR);
    private RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.numerify("##########");
    String currentAddress = faker.address().fullAddress();

    String day = "30", month = "July", year = "2008";
    String gender = "Male", hobbies = "Sports",subjects = "Maths";


    @BeforeSuite
    static void BeforeSuite() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void givenString_thenCorrect() {
        assertThat(gender, anyOf(equalTo("Male"),equalTo("Female"),equalTo("Other")));
        assertThat(userNumber, hasLength(10));
    }

    @Test
    public void registration(){
        open("https://demoqa.com/automation-practice-form");
        registrationPage.firstName.checkInputPlaceholder("First Name");
        registrationPage.firstName.setData(firstName);
        registrationPage.lastName.setData(lastName);
        registrationPage.userEmail.setData(userEmail);
        registrationPage.gender.setChecked(gender);
        registrationPage.mobile.setData(userNumber);
        registrationPage.dateOfBirth.openCalendar();
        registrationPage.dateOfBirth.setYear(year);
        registrationPage.dateOfBirth.setMonth(month);
        registrationPage.dateOfBirth.setDay(day);
        registrationPage.subject.inputValue(subjects);
        registrationPage.subject.selectExactChoose(subjects);
        registrationPage.hobbies.setChecked(hobbies);
        registrationPage.picture.uploadFile("pic.png");
        registrationPage.address.setData(currentAddress);
        registrationPage.state.openDdl();
        registrationPage.state.selectExactChoose(fromNCRState.getState());
        registrationPage.city.openDdl();
        registrationPage.city.selectExactChoose(fromNCRState.getCity());
        registrationPage.submit.press();


        registrationPage.result.checkResultsValue("Student Name",firstName + " " + lastName);
        registrationPage.result.checkResultsValue("Student Email", userEmail);
        registrationPage.result.checkResultsValue("Gender", gender);
        registrationPage.result.checkResultsValue("Mobile", userNumber);
        registrationPage.result.checkResultsValue("Date of Birth", day + " "+month+ ","+year);
        registrationPage.result.checkResultsValue("Subjects", subjects);
        registrationPage.result.checkResultsValue("Hobbies", hobbies);
        registrationPage.result.checkResultsValue("Picture", "pic.png");
        registrationPage.result.checkResultsValue("Address", currentAddress);
        registrationPage.result.checkResultsValue("State and City",fromNCRState.getState()+" "+fromNCRState.getCity());
    }


}
