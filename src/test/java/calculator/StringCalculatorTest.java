package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
3. 커스텀 구분자를 지정할 수있다(“//;\n) 사이의 값
4. 음수의 경우 RuntimeException 예외를 처리한다
7. 숫자 하나(숫자만) 문자열로 입력할 경우 해당 숫자를 반환
 */
public class StringCalculatorTest {

    @Test
    @DisplayName("콜론 구분자")
    void test2() {
        int result = StringCalculator.cal("1:2");
        assertThat(result).isEqualTo(3);
    }
    @Test
    @DisplayName("쉼표 구분자")
    void test1() {
        int result = StringCalculator.cal("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("빈 문자열, null 테스트")
    void null_empty_test(String input) {
        int result = StringCalculator.cal(input);
        assertThat(result).isEqualTo(0);
    }
}
