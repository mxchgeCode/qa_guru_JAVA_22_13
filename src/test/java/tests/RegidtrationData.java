package tests;
import utils.RandomStudent;
public class RegidtrationData {
    RandomStudent randomStudent = new RandomStudent();
    public String
                userFirstName = randomStudent.getRandomFirstName(),
                userLastName = randomStudent.getRandomLastName(),
                userEmail = randomStudent.getRandomEmail(),
                userGender = randomStudent.getRandomGender(),
                userPhone = randomStudent.getRandomPhone(),
                userBirthDay = randomStudent.getRandomBirthDay("day"),
                userBirthMonth = randomStudent.getRandomBirthDay("month"),
                userBirthYear = randomStudent.getRandomBirthDay("year"),
                userSubject = randomStudent.getRandomSubject(),
                userHobby = randomStudent.getRandomHobby(),
                userAddress = randomStudent.getRandomAddress(),
                userState = randomStudent.getRandomState(),
                userCity = randomStudent.getRandomCity(userState);
}
