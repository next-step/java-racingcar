package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest(name = "빈 문자열 또는 null 값을 입력할 경우 0 반환")
    @NullAndEmptySource
    public void checkNull(String checkStr) {
        int result = stringCalculator.numberStringSum(checkStr);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.numberStringSum(checkStr);
        assertThat(result).isEqualTo(0);
    }

    /**
     * 요구사항 4개 한번에 테스트
     * 1.하나의 숫자를 문자열로 입력할 경우 해당 숫자 반환
     * 2.숫자 두개를 콤마 구분자로 입력할 경우 두 숫자의 합을 반환
     * 3.콜론으로도 구분자 사용
     * 4.// 와 \n문자 사이에 커스텀 구분자 사용
     */
    @ParameterizedTest(name = "numberStringSum 테스트")
    @MethodSource("numberStringSumTest")
    void numberStringSumTest(String checkStr,int result) {
        int sumNum = stringCalculator.numberStringSum(checkStr);
        assertThat(sumNum).isEqualTo(result);
    }

    static Stream<Arguments> numberStringSumTest() {
        return Stream.of(
                    Arguments.of("3",3),
                    Arguments.of("1,2",3),
                    Arguments.of("1,2:3",6),
                    Arguments.of("//;\n1;2,3",6));

    }

    @Test
    @DisplayName("음수입력시 RuntimeException 예외발생")
    public void negative() {
        assertThatThrownBy(() -> stringCalculator.numberStringSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
