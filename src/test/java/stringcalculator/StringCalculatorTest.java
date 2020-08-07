package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("정상 동작 :: 올바른 수식인 경우")
    @Test
    void calculate_Success() {
        String expression = "2 + 3 * 4 / 2";
        int result = stringCalculator.calculate(expression);
        assertThat(result).isEqualTo(10);
    }

    private static Stream<String> testExpression() {
        return Stream.of(
                null,
                "",
                "2+3/5&3"
        );
    }

    @DisplayName("실패 :: 잘못된 수식인 경우")
    @ParameterizedTest
    @MethodSource("testExpression")
    void calculate_fail(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(expression);
        });
    }


}