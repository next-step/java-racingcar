package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

    static Stream<String> blankStrings() {
        return Stream.of(null, "", " ");
    }

    @DisplayName("비어있는 연산 검증")
    @ParameterizedTest
    @MethodSource("blankStrings")
    void errorWhenFormulaIsNullOrBlank(String testValue) {
        assertThatThrownBy(() -> new Calculator(testValue).value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 두 자 검증")
    @Test
    void errorWhenFormulaOverTwoBlank() {
        assertThatThrownBy(() -> new Calculator("2   + 3 * 4 / 2").value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 간 사칙연산 기호 생략 케이스 검증")
    @Test
    void errorWhenFormulaMissingOperator() {
        assertThatThrownBy(() -> new Calculator("2 3 * 4 / 2").value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산 기호 불량 검증")
    @Test
    void errorWhenFormulaInvalidExpByOperator() {
        assertThatThrownBy(() -> new Calculator("+ + 3 * 4 / 2").value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비허용 문자 검증")
    @Test
    void errorWhenFormulaInvalidExpByNotAllowedChar() {
        assertThatThrownBy(() -> new Calculator("2 & 3 * 4 / 2").value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0으로 나누었을 때 에러 검증")
    @Test
    void errorWhenDivideByZero() {
        assertThatThrownBy(() -> new Calculator("2 / 0 + 5 * 3").value())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 formula: `2 + 3 * 4 / 2` 일 때 의도한 값 `10`을 반환한다.")
    @Test
    void correctWhenBasicFormula() {
        assertThat(new Calculator("2 + 3 * 4 / 2").value())
            .isEqualTo(10);
    }
}



