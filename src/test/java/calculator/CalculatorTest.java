package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void null이나_빈_문자열인_경우_0을_반환한다(String input) {
        int result = Calculator.sum(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest()
    @MethodSource("numberStrings")
    void 쉼표_또는_콜론을_구분하여_합_구하기(String input, int expected) {
        int result = Calculator.sum(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 이용하여 계산한다.")
    void 문자_사이에_커스텀_구분자를_이용하여_계산한다() {
        String s = "//;\n1;2;3";

        int result = Calculator.sum(s);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다")
    @ParameterizedTest()
    @ValueSource(strings = {"-1,2,3", "a,2,3", "//;\n^2;3;4"})
    void 문자열_계산기에_숫자_이외의_값_또는_음수를_전달하는_경우_RuntimeException_예외를_throw한다(String input) {

        ThrowableAssert.ThrowingCallable callable = () -> Calculator.sum(input);

        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class);
    }
}
