package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.console.InputExpression;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("입력되는 전체 수식에 대한 테스트")
class InputExpressionTest {

    @DisplayName("수식의 계산 결과 변수로 int 값의 범위 안에 있는 값이 할당되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "1 + 2 * 4 / 2 + 6"})
    void checkValidInputExpressionTest(String expression) {
        // When
        InputExpression inputExpression = new InputExpression(expression);

        // Then
        assertThat(inputExpression.getExpression()).isEqualTo(expression);
    }

    @DisplayName("수식의 계산 결과 변수로 int 값의 범위 안에 있는 값이 할당되는지 확인")
    @ParameterizedTest
    @MethodSource("invalidExpression")
    void checkInvalidInputExpressionTest(String expression) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(() ->
            new InputExpression(expression)
        );
    }

    private static List<String> invalidExpression() {
        return Arrays.asList("", null);
    }
}
