package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    SelenideElement titleLabel = $(".practice-form-wrapper");
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderWrapper = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddressTextArea = $("#currentAddress");
    SelenideElement selectStateDropdown = $("#state");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    SelenideElement selectCityDropdown = $("#city");
    SelenideElement submitButton = $("#submit");


    public RegistrationPage openPage(String pageAddress) {
        step("Откываем форму, удаляем рекламу ", () -> {
            open(pageAddress);
            titleLabel.shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        step("Вводим имя студента", () -> {
            firstNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setLastName(String value) {
        step("Вводим фамилию студента", () -> {
            lastNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setEmail(String value) {
        step("Вводим email студента", () -> {
            userEmailInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setGender(String value) {
        step("Вводим пол студента", () -> genderWrapper.$(byText(value)).click());
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        step("Вводим телефон студента", () -> {
            userNumberInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        step("Вводим дату рождения студента", () -> {
            dateOfBirthInput.click();
            calendar.setDate(day, month, year);
        });
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        step("Вводим предметы", () -> {
            subjectsInput.setValue(subject).pressEnter();
        });
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        step("Вводим хобби студента", () -> hobbiesWrapper.$(byText(hobby)).click());
        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        step("Загружаем фото студента", () -> {
            uploadPictureInput.uploadFromClasspath(fileName);
        });
        return this;
    }

    public RegistrationPage setAddress(String address) {
        step("Вводим адрес студента", () -> {
            currentAddressTextArea.setValue(address);
        });
        return this;
    }

    public RegistrationPage setState(String state) {
        step("Вводим название штата", () -> {
            selectStateDropdown.click();
            stateCityWrapper.$(byText(state)).click();
        });
        return this;
    }

    public RegistrationPage setCity(String city) {
        step("Вводим название города", () -> {
            selectCityDropdown.click();
            stateCityWrapper.$(byText(city)).click();
        });
        return this;
    }

    public void clickSubmitButton() {
        step("Нажимаем кнопку Submit", () -> submitButton.click());
    }

}
