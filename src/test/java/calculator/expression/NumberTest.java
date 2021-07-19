package calculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 (식)")
class NumberTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열을 받아 숫자 객체를 생성한다.")
    void of(String numberString, Number expectedNumber) {
        assertThat(Number.of(numberString)).isEqualTo(expectedNumber);
    }

    private static Stream<Arguments> of() {
        return Stream.of(
                Arguments.of("1", Number.of("1")),
                Arguments.of("0", Number.of("0")),
                Arguments.of("-1", Number.of("-1"))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자는 계산 결과 그 숫자를 그대로 반환한다.")
    void calculateNumber(Number number, int expectedNumber) {
        assertThat(number.calculate()).isEqualTo(expectedNumber);
    }

    private static Stream<Arguments> calculateNumber() {
        return Stream.of(
                Arguments.of(Number.of("0"), 0),
                Arguments.of(Number.of("5"), 5),
                Arguments.of(Number.of("-5"), -5),
                Arguments.of(Number.of("10"), 10),
                Arguments.of(Number.of("-10"), -10)
        );
    }

}