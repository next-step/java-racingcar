package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("계산식(Expression) 테스트")
public class ExpressionTest {

    private static final String SEPARATOR = " ";

    @DisplayName("문자열 배열을 통해 계산식을 만들 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 3",
            "1 + 2 - 4 / 2 * 10"})
    void create(String value) {
        // given
        Expression expression = Expression.of(value.split(SEPARATOR));

        // when / then
        assertThat(expression).isNotNull();
    }

    @DisplayName("숫자가 아닌 다른 문자열이 있을 경우 예외처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 + &",
            "1 + 2 - a / 2 * 10"})
    void createInvalidNumber(String value) {
        // when / then
        assertThrows(NumberFormatException.class, () -> {
            Expression.of(value.split(SEPARATOR));
        });
    }

    @DisplayName("연산자가 아닌 다른 문자열이 있을 경우 예외처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "# + 3",
            "b + 2 - 5 / 2 * 10"})
    void createInvalidOperator(String value) {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> {
            Expression.of(value.split(SEPARATOR));
        });
    }

    @DisplayName("계산식의 결과를 얻을 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1 + 3,4",
            "1 + 2 - 4 / 2 * 10,0",
            "3 + 14 - 2 / 5 * 3,9"})
    void calculate(String value, String expected) {
        // when
        Expression expression = Expression.of(value.split(SEPARATOR));
        Number calculate = expression.calculate();

        // then
        assertThat(calculate).isEqualTo(Number.valueOf(expected));
    }
}
