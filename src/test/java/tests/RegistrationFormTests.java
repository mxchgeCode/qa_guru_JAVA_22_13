package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    RegidtrationData rd = new RegidtrationData();

    @Test
    void fillFormTest() {
                registrationPage.openPage()
                .setFirstName(rd.userFirstName)
                .setLastName(rd.userLastName)
                .setEmail(rd.userEmail)
                .setGender(rd.userGender)
                .setPhone(rd.userPhone)
                .setBirthDate(rd.userBirthDay, rd.userBirthMonth, rd.userBirthYear)
                .setSubject(rd.userSubject)
                .setHobby(rd.userHobby)
                .uploadFile(rd.randomStudent.getFileName())
                .setAddress(rd.userAddress)
                .setState(rd.userState)
                .setCity(rd.userCity)
                .clickSubmit();

        registrationResultsModal.verifyModalAppears()
                .verifyResult("Student Name", rd.userFirstName + " " + rd.userLastName)
                .verifyResult("Student Email", rd.userEmail)
                .verifyResult("Gender", rd.userGender)
                .verifyResult("Mobile", rd.userPhone)
                .verifyResult("Date of Birth", rd.userBirthDay + " " + rd.userBirthMonth + "," + rd.userBirthYear)
                .verifyResult("Subjects", rd.userSubject)
                .verifyResult("Hobbies", rd.userHobby)
                .verifyResult("Address", rd.userAddress)
                .verifyResult("State and City", rd.userState + " " + rd.userCity)
                .verifyResult("Picture", rd.randomStudent.getFileName());
    }
}