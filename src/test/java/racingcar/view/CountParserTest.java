package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountParserTest {
    @Test
    @DisplayName("숫자 문자열을 정수로 변환한다")
    void parseCount() {
        CountParser countParser = new CountParser();

        int result = countParser.parse("3");

        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    @DisplayName("숫자가 아닌 입력은 IllegalArgumentException")
    void throwIllegalArgumentExceptionWithNonNumericInput(String input) {
        CountParser countParser = new CountParser();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> countParser.parse(input))
                .withMessage("only numeric inputs are allowed here");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    @DisplayName("음수인 입력은 IllegalArgumentException")
    void throwIllegalArgumentExceptionWithNegativeInput(String input) {
        CountParser countParser = new CountParser();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> countParser.parse(input))
                .withMessage("negative integer inputs are not allowed here [" + input + "]");
    }
}
