package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일때 IllegalArgumentException 테스트")
    @MethodSource("blankStrings")
    void validationEmptyWithFormula(String input) {
        assertThatThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }
}
