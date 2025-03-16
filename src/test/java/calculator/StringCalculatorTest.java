package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
1. 쉼표 구분자의 경우 구분자 기준으로 분리한 각 숫자의 합
2. 콜론 구분자의 경우 구분자 기준으로 분리한 각 숫자의 합
3. 커스텀 구분자를 지정할 수있다(“//;\n) 사이의 값
4. 음수의 경우 RuntimeException 예외를 처리한다
7. 숫자 하나(숫자만) 문자열로 입력할 경우 해당 숫자를 반환

5. 빈문자열의 경우 0을 반환
6. Null 값을 입력할 경우 0 을 반환
 */
public class StringCalculatorTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("빈 문자열, null 테스트")
    void null_empty_test(String input) {
        int result = StringCalculator.cal(input);
        assertThat(result).isEqualTo(0);
    }

}
