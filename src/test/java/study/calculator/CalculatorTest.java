package study.calculator;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계산기 종합 테스트")
public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 1 + 2 * 5 / 5 - 111:-106", "10 + 1 + 2 / 5:2"}, delimiter = ':')
    @DisplayName("계산기 확인")
    public void calculatorWorkTest(String input, int checkNumber) throws Exception {
        //given

        //when
        int result = calculator.work(input);

        //then
        assertThat(result).isEqualTo(checkNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("공백 문자열 예외 처리 테스트")
    public void blankValueExceptionTest(String input) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then
    }

    @Test
    @DisplayName("사칙연산 기호가 아닐 경우 예외 처리 테스트")
    public void notArithmeticSymbolExceptionTest() throws Exception {
        //given
        String input = "2 ! 1 x 2 ㅇ 5 / 5";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then

    }

    @Test
    @DisplayName("숫자가 아닐 경우 예외 처리 테스트")
    public void notaNumberExceptionTest() throws Exception {
        //given
        String input = "a + b + c";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.work(input);
        });

        //then
    }

}
