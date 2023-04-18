package calculator;

import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @Test
    void 음수() {
        assertThat(StringCalculator.splitAndSum("1,-2")).isEqualTo(3);
    }
    @Test
    void 콜론구분자() {
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test // cmd + n
    void 빈문자열_null() { // 테스트 코드는 의도를 드러내는게 가장 중요하기때문에 테스트코드 함수명을 한글로 적어도 좋다 (또는 DisplayName 이용)
        // 메서드의 input, output을 정하는 것도 의미가 있다
         //  처음에는 클래스메서드로 구현하자
        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringCalculator.splitAndSum("0")).isEqualTo(0);
    }
}
