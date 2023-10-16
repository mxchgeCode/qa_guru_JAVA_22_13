package tests;


import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Проверка формы регистрации")
public class RegistrationFormTests extends TestBase {

    @Test
    void fillAllFormsAndVerifyResultTest() {
        step("Открываем страницу регистрации", () -> {
            registrationPage.openPage(testData.AUTOMATION_PRACTICE_URL);
        });
        step("Заполняем форму", () -> registrationPage.openPage(testData.AUTOMATION_PRACTICE_URL)
                .setFirstName(testData.USER_NAME)
                .setLastName(testData.USER_SURNAME)
                .setEmail(testData.USER_EMAIL)
                .setGender(testData.USER_GENDER)
                .setUserNumber(testData.USER_NUMBER)
                .setDateOfBirth(testData.DAY_OF_BIRTH, testData.MONTH_OF_BIRTH, testData.YEAR_OF_BIRTH)
                .setSubject(testData.SUBJECT)
                .selectHobby(testData.HOBBY)
                .uploadImage(testData.FILE_NAME)
                .setAddress(testData.CURRENT_ADDRESS)
                .setState(testData.USER_STATE)
                .setCity(testData.USER_CITY)
                .clickSubmitButton());

        step("Проверяем данные", () -> {
            step("Проверяем появление окна результатов", () -> {
                verifyTextResultComponent.checkResultWindowHaveText(testData.TEXT_IN_RESULT_WINDOW);
            });
            step("Проверяем имя и фамилию студента", () -> {
                verifyTextResultComponent.verifyTableResult("Student Name", testData.USER_NAME + " " + testData.USER_SURNAME);
            });
            step("Проверяем адрес почты студента", () -> {
            verifyTextResultComponent.verifyTableResult("Student Email", testData.USER_EMAIL);
            });
            step("Проверяем пол студента", () -> {
            verifyTextResultComponent.verifyTableResult("Gender", testData.USER_GENDER);
            });
            step("Проверяем телефон студента", () -> {
                verifyTextResultComponent.verifyTableResult("Mobile", testData.USER_NUMBER);
            });
            step("Проверяем день рождения студента", () -> {
                verifyTextResultComponent.verifyTableResult("Date of Birth", testData.DAY_OF_BIRTH + " " + testData.MONTH_OF_BIRTH + "," + testData.YEAR_OF_BIRTH);
            });
            step("Проверяем предметы студента", () -> {
                verifyTextResultComponent.verifyTableResult("Subjects", testData.SUBJECT);
            });
            step("Проверяем хобби студента", () -> {
                verifyTextResultComponent.verifyTableResult("Hobbies", testData.HOBBY);
            });
            step("Проверяем изображение", () -> {
                verifyTextResultComponent.verifyTableResult("Picture", testData.FILE_NAME);
            });
            step("Проверяем адрес", () -> {
                verifyTextResultComponent.verifyTableResult("Address", testData.CURRENT_ADDRESS);
            });
            step("Проверяем штат и город", () -> {
                verifyTextResultComponent.verifyTableResult("State and City", testData.USER_STATE + " " + testData.USER_CITY);
            });
        });

    }
}
