package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static final Calculator CALCULATOR = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 4 * 2=10" ,
            "5 - 2 * 2 / 3=2" ,
            "9 / 5 + 2=3"
    }, delimiter = '=')
    @DisplayName("입력 문자열을 통한 사칙 연산 수행")
    public void calculate(String formula, int expected){
        //when
        int result = CALCULATOR.calculate(formula);

        //then
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("사칙 연산 중 예외 테스트 ")
    public void calculateException(){
        //given
        String formula = "5 - 2 * 2 / 3 *";

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CALCULATOR.calculate(formula))
                .withMessageMatching("입력값이 잘못되었습니다.");
    }

    @Test
    @DisplayName("사칙 연산 중 연산자 예외 테스트")
    public void operatorException(){
        //given
        String formula = "5 - 2 * 2 / 3 # 2";

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CALCULATOR.calculate(formula))
                .withMessageMatching("연산자가 잘못 입력 되었습니다.");
    }
}
