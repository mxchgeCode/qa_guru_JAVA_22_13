package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyTextResultComponent {


    SelenideElement resultWindowTitle = $("#example-modal-sizes-title-lg");

    public VerifyTextResultComponent checkResultWindowHaveText(String text) {
        resultWindowTitle.shouldHave(text(text));
        return this;
    }

    public VerifyTextResultComponent verifyTableResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

}
