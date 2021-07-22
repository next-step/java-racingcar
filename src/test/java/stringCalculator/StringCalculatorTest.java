package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    @DisplayName("입력 및 연산 메서드 단위 테스트")
    void calculateTest(){
        // given
        String problem = "1 + 3 - 2 * 5 / 2";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.calculate(problem);
        //then
        assertThat(answer).isEqualTo("5");
    }

    @Test
    @DisplayName("덧셈 메서드 단위 테스트")
    void sumTest() {
        // given
        String a = "1";
        String b = "2";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.sum(a, b);
        // then
        assertThat(answer).isEqualTo("3");
    }

    @Test
    @DisplayName("뺄셈 메서드 단위 테스트")
    void diffTest() {
        // given
        String a = "3";
        String b = "2";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.diff(a, b);
        // then
        assertThat(answer).isEqualTo("1");
    }

    @Test
    @DisplayName("곱셈 메서드 단위 테스트")
    void multTest() {
        // given
        String a = "3";
        String b = "2";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.mult(a, b);
        // then
        assertThat(answer).isEqualTo("6");
    }

    @Test
    @DisplayName("나눗셈 메서드 단위 테스트")
    void divTest() {
        // given
        String a = "6";
        String b = "4";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        String answer = stringCalculator.div(a, b);
        // then
        assertThat(answer).isEqualTo("1");
    }

}