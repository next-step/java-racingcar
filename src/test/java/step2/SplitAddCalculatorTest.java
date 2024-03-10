package step2;

import error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SplitAddCalculatorTest {


    static Stream<Arguments> testWithDefaultLocalMethodSource() {
        return Stream.of(
                arguments(null, 0),
                arguments("", 0),
                arguments("1", 1),
                arguments("1,2", 3),
                arguments("1,2:3", 6),
                arguments("//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest(name = "[{index}]{0} 를 입력하면, {1} 값이 반환된다")
    @MethodSource("testWithDefaultLocalMethodSource")
    @DisplayName("구분자가 포함된 문자열을 입력하면, 구분자를 제외한 숫자들의 합을 반환한다.")
    void splitAndSum(String text, int answer) {
        int result = SplitAddCalculator.calculate(text);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("음수를 전달할 경우 IndexOutOfBoundsException 예외가 발생해야 한다.")
    void 음수시_예외처리() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하면, IllegalArgumentException 예외를 반환한다.")
    void 문자열_예외처리() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("k,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_FORMAT_MESSAGE.print());
    }
}