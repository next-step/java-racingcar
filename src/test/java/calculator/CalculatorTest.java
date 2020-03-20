package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @DisplayName("잘못된 수식일때 IllegalArgumentException 테스트")
    @ValueSource(strings = {"1 $ 2 - 3", "1 / 2 # 3", "1 ! 2 @ 3", "1 > 2"})
    void validationInvalidFormulaWithInputTest(String input) {
        assertThatThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일때 IllegalArgumentException 테스트")
    @MethodSource("blankStrings")
    void validationEmptyWithInputTest(String input) {
        assertThatThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }
}
