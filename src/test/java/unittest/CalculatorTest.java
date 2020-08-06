package unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    static Calculator cal;


    @BeforeAll
    public static void set() {
        cal = new Calculator();
    }

    @DisplayName("문자열 split 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 - 4", "2 * 3"})
    public void splitTest(String input) {
        assertThat(cal.splitInput(input).length).isEqualTo(3);
    }

    @DisplayName("문자열 split Null이랑 Empty 문자열 테스트 --> Exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitTestByNullOrEmptyValue(String input) {
        assertThatThrownBy(
                () -> cal.splitInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 배열 더하기 테스트")
    @ParameterizedTest
    @MethodSource("getStringArrayParameter")
    public void calcuate(String[] input, int expected) {
        assertThat(cal.calculate(input)).isEqualTo(expected);
    }

    static Stream<Arguments> getStringArrayParameter() {
        return Stream.of(
                Arguments.of(new String[]{"1", "+", "2"}, 3),
                Arguments.of(new String[]{"1", "*", "2"}, 2),
                Arguments.of(new String[]{"1", "-", "2"}, -1),
                Arguments.of(new String[]{"4", "/", "2"}, 2)
        );
    }
}
