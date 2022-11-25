import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import models.StateAndCity;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;
import servise.CustomAssert;
import static org.hamcrest.Matchers.*;





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
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @Test
    @Step("Проверка значений")
    public void givenString_thenCorrect() {
        CustomAssert.assertThat(gender, anyOf(equalTo("Male"),equalTo("Female"),equalTo("Other")));
        CustomAssert.assertThat(userNumber, hasLength(10));

    }


    @Test
    public void registration(){

        registrationPage.openPage();
        registrationPage.firstNameInput.checkInputPlaceholder("First Name");
        registrationPage.firstNameInput.setData(firstName);
        registrationPage.lastNameInput.setData(lastName);
        registrationPage.userEmailInput.setData(userEmail);
        registrationPage.genderRadioBtn.setChecked(gender);
        registrationPage.mobileInput.setData(userNumber);
        registrationPage.dateOfBirthDatePicker.openCalendar();
        registrationPage.dateOfBirthDatePicker.setYear(year);
        registrationPage.dateOfBirthDatePicker.setMonth(month);
        registrationPage.dateOfBirthDatePicker.setDay(day);
        registrationPage.subjectDdl.inputValue(subjects);
        registrationPage.subjectDdl.selectExactChoose(subjects);
        registrationPage.hobbiesCheckBox.setChecked(hobbies);
        registrationPage.pictureUpload.uploadFile("pic.png");
        registrationPage.addressInput.setData(currentAddress);
        registrationPage.stateDdl.openDdl();
        registrationPage.stateDdl.selectExactChoose(fromNCRState.getState());
        registrationPage.cityDdl.openDdl();
        registrationPage.cityDdl.selectExactChoose(fromNCRState.getCity());
        registrationPage.submitBtn.press();


        registrationPage.resultTable.checkResultsValue("Student Name",firstName + " " + lastName);
        registrationPage.resultTable.checkResultsValue("Student Email", userEmail);
        registrationPage.resultTable.checkResultsValue("Gender", gender);
        registrationPage.resultTable.checkResultsValue("Mobile", userNumber);
        registrationPage.resultTable.checkResultsValue("Date of Birth", day + " "+month+ ","+year);
        registrationPage.resultTable.checkResultsValue("Subjects", subjects);
        registrationPage.resultTable.checkResultsValue("Hobbies", hobbies);
        registrationPage.resultTable.checkResultsValue("Picture", "pic.png");
        registrationPage.resultTable.checkResultsValue("Address", currentAddress);
        registrationPage.resultTable.checkResultsValue("State and City",fromNCRState.getState()+" "+fromNCRState.getCity());
    }


}
