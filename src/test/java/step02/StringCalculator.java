package step02;

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

    private final Operation operation = new Operation();

    @Test
    @DisplayName("덧셈에 대한 테스트")
    void sum() {
        // given
        int first = 1;
        int second = 2;
        int expected = 3;

        // when
        int result = operation.sum(first, second);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("numTestValue")
    @DisplayName("뻴셈에 대한 테스트")
    void num(int first, int second, int expected) {
        assertThat(operation.num(first, second)).isEqualTo(expected);
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
        assertThat(operation.multi(first, second)).isEqualTo(expected);
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
        assertThat(operation.div(first, second)).isEqualTo(expected);
    }

    private static Stream<Arguments> divTestValue() {
        return Stream.of(
                Arguments.of(1, 3, 0),
                Arguments.of(5, 3, 1),
                Arguments.of(0, 1, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,0"})
    @DisplayName("나눗셈 0으로 나누기 Exception 테스트")
    void divArithmeticException(int first, int second) {
        assertThatThrownBy(() -> {
            operation.div(first, second);
        }).isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 Null이거나 Empty 때의 테스트")
    void isNullOrEmpty() {

    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", "^,false"})
    @DisplayName("유효한 사칙연산 기호인지 테스트")
    void isValidSymbol(String symbol, boolean expected) {
        List<String> symbols = Arrays.asList("+", "-", "*", "/");
        assertThat(symbols.contains(symbol)).isEqualTo(expected);
    }

    // 한개 이상의 사칙연산 기호가 들어올 경우


    // 숫자, 사칙 연산 순서로 들어와야 함 (숫자 다음 숫자, 혹은 연산기호 다음 연산기호는 허용하지 않는다)

}
