import kr.co.techmoa.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    void setup(){

    }

    @Test
    @DisplayName("덧셈 연산 결과")
    void add_test() {
        //given
        String str = "1 + 2";
        Calculator calculator = new Calculator();

        assertEquals(3, calculator.judge(str));
    }

    @Test
    @DisplayName("뺄셈 연산 결과")
    void minus_test() {
        //given
        String str = "5 - 1";
        Calculator calculator = new Calculator();

        assertEquals(4, calculator.judge(str));
    }

    @Test
    @DisplayName("복수 연산 결과")
    void multi_opation_test() {
        //given
        String str = "9 * 2 - 8 / 2";

        assertEquals(5, calculator.judge(str));
    }

    @Test
    @DisplayName("공백 문자열 예외 처리")
    void error_string_test(){
        String str = " ";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    calculator.judge(str);
                }
        ).withMessageMatching("문자열이 비어있습니다.");
    }

    @Test
    @DisplayName("사칙연산외 문자열 예외 처리")
    void error_operation_test(){
        String str = "1 $ 2";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    calculator.judge(str);
                }
        ).withMessageMatching("사칙연산 문자가 아닙니다");
    }
}