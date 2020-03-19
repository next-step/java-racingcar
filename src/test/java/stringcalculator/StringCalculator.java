package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculator {

    @DisplayName("사용자 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void init(String source) {
        Expression expression = new Expression(source);

        assertThat(expression.getSource()).isEqualTo(source);
    }

    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void nullOrEmptyStringThrowIllegalArgumentException(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }
}
