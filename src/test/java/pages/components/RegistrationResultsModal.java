package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationResultsModal {
    public RegistrationResultsModal verifyModalAppears() {
        step("Проверяем, что открыто окно Thanks for submitting the form", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        });
        return this;
    }

    public RegistrationResultsModal verifyResult(String key, String value) {
        step("Проверяем поле " + key, () -> {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
        });
        return this;
    }
}
