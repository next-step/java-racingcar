package nextstep;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    static Stream<Arguments> calculatorInputAndResult() {
        return Stream.of(
                Arguments.arguments("1", 1),
                Arguments.arguments("1,2", 3),
                Arguments.arguments("1,2:3", 6),
                Arguments.arguments("//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void calc_null_또는_빈문자(String input) {
        int result = stringAddCalculator.calc(input);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calc("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "input: {0}, result: {1}")
    @MethodSource("calculatorInputAndResult")
    public void calc(String input, int result) {
        assertThat(stringAddCalculator.calc(input)).isEqualTo(result);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.calc("-1,2,3"))
                .isInstanceOf(RuntimeException.class);

    }
}
