package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    SelenideElement
            titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            selectStateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            selectCityDropdown = $("#city"),
            submitButton = $("#submit"),
            userForm = $("#userForm");


    public RegistrationPage openPage(String pageAddress) {
        open(pageAddress);
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressTextArea.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        selectStateDropdown.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCityDropdown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage userFormContainsValidatedClass(String className) {
        userForm.shouldHave(cssClass(className));
        return this;
    }

    public RegistrationPage containsRequiredCssValues(String element) {
        $(element)
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"))
                .shouldHave(attribute("required"));
        return this;
    }


}


//package pages;
//import pages.components.CalendarComponent;
//import com.codeborne.selenide.SelenideElement;
//
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
////import static com.codeborne.selenide.Selenide.open;
//import static io.qameta.allure.Allure.step;
//import static com.codeborne.selenide.Selenide.executeJavaScript;
//
//
//public class RegistrationPage {
//    CalendarComponent calendar = new CalendarComponent();
//    SelenideElement
//            firstNameInput = $("#firstName"),
//            lastNameInput = $("#lastName"),
//            emailInput = $("#userEmail"),
//            genderRadioButton = $("#genterWrapper"),
//            phoneInput = $("#userNumber"),
//            birthDateInput = $("#dateOfBirthInput"),
//            subjectInput = $("#subjectsInput"),
//            hobbyCheckBox = $("#hobbiesWrapper"),
//            uploadFileElement = $("#uploadPicture"),
//            addressInput = $("#currentAddress"),
//            stateField = $("#state"),
//            stateValue = $("#stateCity-wrapper"),
//            cityField = $("#city"),
//            cityValue = $("#stateCity-wrapper"),
//            submitButton = $("#submit");
//
//    public RegistrationPage openPage() {
//        step("Открываем страницу регистрации", () -> {
//            open("/automation-practice-form");
//        });
//        return this;
//    }
//
//    public RegistrationPage removeBanner() {
//        step("Закрываем баннеры", () -> {
//            executeJavaScript("$('#fixedban').remove()");
//            executeJavaScript("$('footer').remove()");
//        });
//        return this;
//    }
//
//    public RegistrationPage setFirstName(String value) {
//        step("Вводим имя студента", () -> {
//            firstNameInput.setValue(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setLastName(String value) {
//        step("Вводим фамилию студента", () -> {
//            lastNameInput.setValue(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setEmail(String value) {
//        step("Вводим email студента", () -> {
//            emailInput.setValue(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setGender(String value) {
//        step("Вводим пол студента", () -> {
//            genderRadioButton.$(byText(value)).click();
//        });
//        return this;
//    }
//
//    public RegistrationPage setPhone(String value) {
//        step("Вводим телефон студента", () -> {
//            phoneInput.setValue(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setBirthDate(String day, String month, String year) {
//        step("Вводим дату рождения студента", () -> {
//            birthDateInput.click();
//            calendar.setDate(day, month, year);
//        });
//        return this;
//    }
//
//    public RegistrationPage setSubject(String value) {
//        step("Вводим предметы", () -> {
//            subjectInput.setValue(value).pressEnter();
//        });
//        return this;
//    }
//
//    public RegistrationPage setHobby(String value) {
//        step("Вводим хобби студента", () -> {
//            hobbyCheckBox.$(byText(value)).click();
//        });
//        return this;
//    }
//
//    public RegistrationPage uploadFile(String value) {
//        step("Загружаем фото студента", () -> {
//            uploadFileElement.uploadFromClasspath(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setAddress(String value) {
//        step("Вводим адрес студента", () -> {
//            addressInput.setValue(value);
//        });
//        return this;
//    }
//
//    public RegistrationPage setState(String value) {
//        step("Вводим название штата", () -> {
//            stateField.click();
//            stateValue.$(byText(value)).click();
//        });
//        return this;
//    }
//
//    public RegistrationPage setCity(String value) {
//        step("Вводим название города", () -> {
//            cityField.click();
//            cityValue.$(byText(value)).click();
//        });
//        return this;
//    }
//
//    public void clickSubmit() {
//        step("Нажимаем кнопку Submit", () -> {
//            submitButton.click();
//        });
//    }
//}
