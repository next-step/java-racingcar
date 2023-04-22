import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 숫자_하나를_전달하는_경우() {
        String input = "1";

        final StringCalculator calculator = new StringCalculator();
        final int actual = calculator.sum(input);

        assertEquals(1, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;2;$;(", "-1;2;3"})
    @DisplayName("숫자 이외의 값이나 음수를 전달하면 RuntimeException 이 발생한다.")
    void 숫자_이외의_값_또는_음수_전달(String invalidNumber) {
        assertThrows(RuntimeException.class, () -> new StringCalculator().sum(invalidNumber));
    }

    @ParameterizedTest(name = "유효하지 않은 숫자 : {0}")
    @NullAndEmptySource
    void null_또는_빈문자열을_입력하면_0_반환(String invalidNumber) {
        final StringCalculator calculator = new StringCalculator();
        int actual = calculator.sum(invalidNumber);

        assertEquals(0, actual);
    }

    @ParameterizedTest(name = "구분자가 포함된 문자열 : {0}")
    @MethodSource("rawString")
    void 구분자_또는_커스텀_구분자가_포함된_문자열_합_반환(String rawString) {
        final StringCalculator calculator = new StringCalculator();
        final int actual = calculator.sum(rawString);

        assertEquals(6, actual);
    }


    @ParameterizedTest(name = "구분자가 포함된 문자열 : {0}")
    @MethodSource("rawString")
    void 구분자_또는_커스텀_구분자를_기준으로_문자열_분리(String rawString) {
        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(rawString);

        assertEquals("1", components[0]);
        assertEquals("2", components[1]);
        assertEquals("3", components[2]);
    }

    static Stream<Arguments> rawString() {
        return Stream.of(
                Arguments.arguments("//;\\n1;2;3"),
                Arguments.arguments("1;2;3"),
                Arguments.arguments("1,2,3")
        );
    }
}
