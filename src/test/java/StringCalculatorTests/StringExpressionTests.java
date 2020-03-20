package StringCalculatorTests;

import domain.StringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계산식 자체 검증을 위한 테스트")
public class StringExpressionTests {

    @DisplayName("정상 계산식")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "6 - 4", "1 * 5", "8 / 2", "2 + 3 * 4 / 2"})
    public void normalExpressionTests(String input) {
        assertThatCode(() -> StringExpression.newInstance(input)).doesNotThrowAnyException();
    }

    @DisplayName("빈 계산식")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    public void nullOrEmptyTests(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringExpression.newInstance(input))
                .withMessageMatching("Expression is null or empty.");
    }

    @DisplayName("사칙연산 기호가 아닌 기호가 포함된 계산식")
    @ParameterizedTest
    @ValueSource(strings = {"2 ^ 3", "3 @ 1", "7 & 2"})
    public void unKnownSignTests(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringExpression.newInstance(input))
                .withMessageMatching("Expression contains unknown operation.");
    }

    @DisplayName("숫자 대신 다른 문자가 포함된 계산식")
    @ParameterizedTest
    @ValueSource(strings = {"a + 3", "031 - 2"})
    public void notNumberExpressionTests(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringExpression.newInstance(input))
                .withMessageMatching("Expression contains character (not number)");
    }

    @DisplayName("기타 비정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"2 + + 3", "2 +", "- 3", " 2 2 ", " 5 7 -", "2 + 3 3 -"})
    public void etcTests(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringExpression.newInstance(input))
                .withMessageMatching("Expression is abnormal case. " + input);
    }

}
