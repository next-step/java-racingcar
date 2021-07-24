package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


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
    @DisplayName("공백 문자 입력 예외 처리 단위 테스트")
    void emptyStringTest(){
        // given
        String problem = "";
        // when, then
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> {
            stringCalculator.calculate(problem);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 문자");
    }

    @Test
    @DisplayName("비연산자 예외 처리 단위 테스트")
    void nonOperatorTest(){
        // given
        String a = "1";
        String b = "2";
        String nonOperator = "&";
        // when, then
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> {
            stringCalculator.calculateOne(a, b, nonOperator);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아닌 문자");
    }


    @Test
    @DisplayName("덧셈 메서드 단위 테스트")
    void sumTest() {
        // given
        String a = "1";
        String b = "2";
        // when
        String answer = FourOperation.PLUS.apply(a,b);
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
        String answer = FourOperation.MINUS.apply(a,b);
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
        String answer = FourOperation.MULT.apply(a,b);
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
        String answer = FourOperation.DIVIDE.apply(a,b);
        // then
        assertThat(answer).isEqualTo("1");
    }

}