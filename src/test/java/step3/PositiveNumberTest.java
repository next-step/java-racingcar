package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.PositiveNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step3.game.PositiveNumber.POSITIVE_EXCEPTION_MESSAGE;

public class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "테스트"})
    @DisplayName("양의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    void inputNegativeNumbers(String input) {
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(POSITIVE_EXCEPTION_MESSAGE + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10"})
    @DisplayName("양의 숫자를 입력할 수 있다.")
    void inputPositiveNumbers(String input) {
        PositiveNumber output = new PositiveNumber(input);
        assertThat(output.number)
                .isEqualTo(Integer.parseInt(input));
    }
}
