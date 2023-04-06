package calculator;

import static calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 기능 요구사항
 * <pre>
 *     1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 *     2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 *        커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 *        예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 *     3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 * </pre>
 * 프로그래밍 요구사항
 * <pre>
 *     메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 * </pre>
 */
@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
class StringCalculatorTest {

    private static Stream<Arguments> provideArgumentsForSuccessTest() {
        return Stream.of(
            Arguments.of(null, 0, "null은 0을 리턴"),
            Arguments.of("", 0, "빈값은 0을 리턴"),
            Arguments.of("5", 5, "숫자가 하나라면 해당숫자 그대로 리턴"),
            Arguments.of("1,2", 3, "콤마구분자"),
            Arguments.of("1,2,3", 6, "콤마구분자"),
            Arguments.of("1,2:3", 6, "콜론구분자포함"),
            Arguments.of("//;\n1;2", 3, "커스텀 딜리미터 더하기"),
            Arguments.of("//;\n1;2;3", 6, "커스텀 딜리미터 더하기")
        );
    }

    @ParameterizedTest(name = "input={0} / expected={1} ({2})")
    @MethodSource("provideArgumentsForSuccessTest")
    @DisplayName("특정 구분자를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환합니다.")
    void success_test(String text, int expected, String desc) {
        assertThat(calculate(text)).isSameAs(expected);
    }

    @ParameterizedTest(name = "input={0} ({1})")
    @CsvSource(value = {"a,1:영문자포함 예외발생",
                        "2,-1:음수포함",
                        "adsf:숫자없음 예외발생"}, delimiter = ':')
    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 합니다.")
    void failed_test(String text, String desc) {
        assertThatThrownBy(() -> calculate(text))
            .isInstanceOf(RuntimeException.class);
    }
}