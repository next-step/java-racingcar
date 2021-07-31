package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class UserInputTest {

    @ParameterizedTest(name="입력에서 null이나 공백은 에러남")
    @ValueSource(strings = {"", " "})
    void userInputCanNotBeBlankStringOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new UserInput(input)).withMessageMatching("사용자 입력은 null이거나 빈 공백 문자열일 수 없습니다.");
    }

    @DisplayName("입력 값의 첫번째 ")
    @Nested
    class firstValueOfInput {
        @DisplayName("피연산자를 꺼내온다.")
        @Test
        void getFirstNumberOfInput() {
            assertThat(new UserInput("1 + 2").getNumber()).isEqualTo(1);
        }

        @DisplayName("연산자를 꺼내온다.")
        @Test
        void getFirstOperatorOfInput() {
            UserInput userInput = new UserInput("1 + 2");
            userInput.getNumber();
            assertThat(userInput.getOperator()).isEqualTo("+");
        }
    }

    @DisplayName("입력값을 모두 사용했는지 확인")
    @Test
    void checkIfAllElementOfInputIsUsedUp() {
        UserInput userInput = new UserInput("1 + 2");
        assertThat(userInput.inputToCalculateIsRemaining()).isEqualTo(true);
        userInput.getNumber();
        userInput.getOperator();
        userInput.getNumber();
        assertThat(userInput.inputToCalculateIsRemaining()).isEqualTo(false);
    }
}
