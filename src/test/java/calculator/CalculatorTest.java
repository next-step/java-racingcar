package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    static Stream<String> blankOrNullStrings() {
        return Stream.of("", " ", null);
    }

    @DisplayName("null이나 빈 문자열인 경우 0을 반환한다")
    @ParameterizedTest()
    @MethodSource("blankOrNullStrings")
    public void null이나_빈_문자열인_경우_0을_반환한다(String input) throws Exception {
        int result = Calculator.sum(input);

        Assertions.assertThat(result).isEqualTo(0);
    }
}
