package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
class StringCalculatorTest {

    private static Stream<Arguments> provideArgumentsForTest() {
        return Stream.of(Arguments.of(null, 0),
                         Arguments.of("", 0),
                         Arguments.of("1,2", 3),
                         Arguments.of("1,2,3", 6),
                         Arguments.of("1,2:3", 6));
    }

    @ParameterizedTest(name = "쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환({0}={1})")
    @MethodSource("provideArgumentsForTest")
    void test(String text, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int result = stringCalculator.calculate(text);

        // then
        assertThat(result).isSameAs(expected);
    }
}