package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    static Stream<Arguments> calculatorInputAndResultForDelimiter() {
        return Stream.of(
                Arguments.arguments("1,2", 3),
                Arguments.arguments("1,2:3", 6),
                Arguments.arguments("//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("blank 일 경우")
    public void splitAndSum(String input) {
        assertThat(stringAddCalculator.calculate(input)).isEqualTo(0);
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("calculatorInputAndResultForDelimiter")
    @DisplayName("delimiter test")
    public void splitAndSumDelimiter(String input, int result) {
        assertThat(stringAddCalculator.calculate(input)).isEqualTo(result);
    }


    @Test
    public void splitAndSum_숫자하나() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("음수 허용하지 않음")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.NEGATIVE_NOT_SUPPORTED.toString());
    }
}
