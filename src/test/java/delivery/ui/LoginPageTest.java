package delivery.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import delivery.utils.RandomDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageTest {

    @BeforeEach
    public void openLoginPage() {

        Selenide.open("http://35.208.34.242:3000/signin");

    }

    //1.1  Login with incorrect data and implement error checking
    @Test
    public void loginWithIncorrectCredentialsAndCheckTheIncorrectCredentialsPopUp() {

//        SelenideElement usernameInputField = $(By.xpath("//*[@data-name=\"username-input\"]"));
//        usernameInputField.sendKeys("username");

        $x("//*[@data-name=\"username-input\"]").sendKeys(RandomDataGenerator.getRandomString(5));

//        SelenideElement passwordInputField = $(By.xpath("//*[@data-name=\"password-input\"]"));
//        passwordInputField.sendKeys("password");

        $x("//*[@data-name=\"password-input\"]").sendKeys(RandomDataGenerator.getRandomString(10));

//        SelenideElement signInButton = $x("//*[@data-name=\"signIn-button\"]");
//        signInButton.click();

        $x("//*[@data-name=\"signIn-button\"]").click();

//        SelenideElement incorrectCredentialsPopUp = $x("//*[@data-name=\"authorizationError-popup-close-button\"]");
//        incorrectCredentialsPopUp.shouldBe(Condition.visible);

        $x("//*[@data-name=\"authorizationError-popup-close-button\"]").shouldBe(Condition.visible);

    }

    //1.2   Login with the correct data and check order page
    @Test
    public void loginWithCorrectCredentialsAndCheckTheCreateButtonOnTheOrderPage() {

        $x("//*[@data-name=\"username-input\"]").setValue(System.getProperty("username"));
        $x("//*[@data-name=\"password-input\"]").setValue(System.getProperty("password"));
        $x("//*[@data-name=\"signIn-button\"]").click();

        $x("//*[@data-name=\"createOrder-button\"]").shouldBe(Condition.visible);

        $x("//*[@data-name=\"logout-button\"]").click();

    }

    //1.3   Error checking using a minimum number of characters (2 scenario username + password) -
            //try to find tricky selector
    @Test
    public void checkTheErrorMessageIfTheLoginTooShort() {

        $x("//*[@data-name=\"username-input\"]").setValue(RandomDataGenerator.getRandomString(1));

        $x("//*[@data-name=\"username-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.visible);

    }

    @Test
    public void checkTheErrorMessageIfClearLoginField() {

        $x("//*[@data-name=\"username-input\"]").setValue("a");
        $x("//*[@data-name=\"username-input\"]").setValue("");

        $x("//*[@data-name=\"username-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.visible);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6, 7})
    public void checkTheErrorMessageIfThePasswordTooShort(int length) {

        $x("//*[@data-name=\"password-input\"]").setValue(RandomDataGenerator.getRandomString(length));

        $x("//*[@data-name=\"password-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.visible);

    }

    @Test
    public void checkTheErrorMessageIfClearPasswordField() {

        $x("//*[@data-name=\"password-input\"]").setValue("a");
        $x("//*[@data-name=\"password-input\"]").setValue("");

        $x("//*[@data-name=\"password-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.visible);

    }

    @Test
    public void checkTheImpossibilityOfExceedingTheMaximumAllowedLoginLength() {

        String maxLengthLogin = RandomDataGenerator.getRandomString(30);

        $x("//*[@data-name=\"username-input\"]").setValue(maxLengthLogin);

        $x("//*[@data-name=\"username-input\"]").shouldHave(value(maxLengthLogin));

        String maxLengthLoginPlusOneSymbol = maxLengthLogin + "g";

        $x("//*[@data-name=\"username-input\"]").setValue(maxLengthLoginPlusOneSymbol);

        $x("//*[@data-name=\"username-input\"]").shouldHave(value(maxLengthLogin));

    }

    @Test
    public void checkTheImpossibilityOfExceedingTheMaximumAllowedPasswordLength() {

        String maxLengthPassword = RandomDataGenerator.getRandomString(30);

        $x("//*[@data-name=\"password-input\"]").setValue(maxLengthPassword);

        $x("//*[@data-name=\"password-input\"]").shouldHave(value(maxLengthPassword));

        String maxLengthPasswordPlusOneSymbol = maxLengthPassword + "g";

        $x("//*[@data-name=\"password-input\"]").setValue(maxLengthPasswordPlusOneSymbol);

        $x("//*[@data-name=\"password-input\"]").shouldHave(value(maxLengthPassword));

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 15, 29, 30})
    public void checkTheAbsenceOfErrorsIfUsingValidLoginLength(int length) {

        $x("//*[@data-name=\"username-input\"]").setValue(RandomDataGenerator.getRandomString(length));

        $x("//*[@data-name=\"username-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.hidden);

    }

    @ParameterizedTest
    @ValueSource(ints = {8, 9, 15, 29, 30})
    public void checkTheAbsenceOfErrorsIfUsingValidPasswordLength(int length) {

        $x("//*[@data-name=\"password-input\"]").setValue(RandomDataGenerator.getRandomString(length));

        $x("//*[@data-name=\"password-input\"]/..//*[@data-name=\"username-input-error\"]").shouldBe(Condition.hidden);

    }

    @Test
    public void checkOfWorkingTheSignInButtonIfUsingValidLoginAndPassword() {

        $x("//*[@data-name=\"username-input\"]").setValue(RandomDataGenerator.getRandomString(5));
        $x("//*[@data-name=\"password-input\"]").setValue(RandomDataGenerator.getRandomString(10));

        $x("//*[@data-name=\"signIn-button\"]").shouldBe(Condition.clickable);

    }

    @Test
    public void checkOfDeactivationTheSignInButtonIfUsingAnInvalidLogin() {

        $x("//*[@data-name=\"username-input\"]").setValue(RandomDataGenerator.getRandomString(1));
        $x("//*[@data-name=\"password-input\"]").setValue(RandomDataGenerator.getRandomString(10));

        $x("//*[@data-name=\"signIn-button\"]").shouldBe(Condition.disabled);

    }

    @Test
    public void checkOfDeactivationTheSignInButtonIfUsingAnInvalidPassword() {

        $x("//*[@data-name=\"username-input\"]").setValue(RandomDataGenerator.getRandomString(5));
        $x("//*[@data-name=\"password-input\"]").setValue(RandomDataGenerator.getRandomString(4));

        $x("//*[@data-name=\"signIn-button\"]").shouldBe(Condition.disabled);

    }
}