package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    static Stream<String> blankOrNullStrings() {
        return Stream.of("", " ", null);
    }

    static Stream<Arguments> numberStrings() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("1,2:3", 6),
                Arguments.of("1:3:3", 7),
                Arguments.of("1,2,3", 6)
        );
    }

    @DisplayName("null이나 빈 문자열인 경우 0을 반환한다")
    @ParameterizedTest()
    @MethodSource("blankOrNullStrings")
    public void null이나_빈_문자열인_경우_0을_반환한다(String input) throws Exception {
        int result = Calculator.sum(input);

        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest()
    @MethodSource("numberStrings")
    public void 쉼표_또는_콜론을_구분하여_합_구하기(String input, int expected) throws Exception {
        int result = Calculator.sum(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 이용하여 계산한다.")
    public void 문자_사이에_커스텀_구분자를_이용하여_계산한다() throws Exception {
        String s = "//;\n1;2;3";

        int result = Calculator.sum(s);

        Assertions.assertThat(result).isEqualTo(6);
    }
}
