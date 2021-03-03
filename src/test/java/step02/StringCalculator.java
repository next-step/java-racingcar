package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
    생각하면서 할 것!
    * 중복코드가 없도록 Test 어노테이션 종류를 잘 활용할 것
 */
public class StringCalculator {

    private final Calculations calculator = new Calculations();

    @Test
    @DisplayName("덧셈에 대한 테스트")
    void sum() {
        // given
        int first = 1;
        int second = 2;
        int expected = 3;

        // when
        int result = calculator.sum(first, second);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("numTestValue")
    @DisplayName("뻴셈에 대한 테스트")
    void num(int first, int second, int expected) {
        assertThat(calculator.num(first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> numTestValue() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(5, 1, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("multiTestValue")
    @DisplayName("곱셈에 대한 테스트")
    void multi(int first, int second, int expected) {
        assertThat(calculator.multi(first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> multiTestValue() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(0, 5, 0),
                Arguments.of(0, 3, 0),
                Arguments.of(-3, 6, -18)
        );
    }

    @ParameterizedTest
    @MethodSource("divTestValue")
    @DisplayName("나눗셈에 대한 테스트")
    void div(int first, int second, int expected) {
        assertThat(calculator.div(first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> divTestValue() {
        return Stream.of(
                Arguments.of(1, 3, 0),
                Arguments.of(5, 3, 1),
                Arguments.of(0, 1, 0)
        );
    }

}
