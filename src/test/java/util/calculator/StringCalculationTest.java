package util.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.calculator.Calculator;
import util.calculator.StringCalculator;

import static org.assertj.core.api.Assertions.*;

public class StringCalculationTest {
    /*
        테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
        덧셈
        뺄셈
        곱셈
        나눗셈
        사칙연산 기호가 아닌 경우 IllegalArgumentException throw
        사칙 연산을 모두 포함하는 기능 구현
        공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
        반복적인 패턴을 찾아 반복문으로 구현한다.
    */
    public void stringCalTest(String input, int result) {
        Calculator calculator = new StringCalculator(input);
        int calResult = calculator.calculation();
        assertThat(calResult).isEqualTo(result);
    }

    @CsvSource(value = {
            "5 + 1,6",
            "9 + 2,11",
            "1 + 0,1",
            "0 + 9,9",
    })
    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    public void addTest(String input, int result) {
        stringCalTest(input, result);
    }

    @CsvSource(value = {
            "5 - 1,4",
            "9 - 2,7",
            "1 - 0,1",
            "0 - 9,-9",
    })
    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    public void minTest(String input, int result) {
        stringCalTest(input, result);
    }

    @CsvSource(value = {
            "5 * 1,5",
            "9 * 2,18",
            "1 * 0,0",
            "0 * 9,0",
    })
    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    public void mulTest(String input, int result) {
        stringCalTest(input, result);
    }

    @CsvSource(value = {
            "5 / 1,5",
            "9 / 2,4",
            "1 / 2,0",
            "0 / 9,0",
    })
    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    public void divTest(String input, int result) {
        stringCalTest(input, result);
    }

    @CsvSource(value = {
            "2 + 3 * 4 / 2,10",
            "2 + 3 *  4 / 2 -  9 + 2  -  1 + 2 / 15 /  16,0"
    })
    @DisplayName("복잡한 계산 테스트")
    @ParameterizedTest
    public void calTest(String input, int result) {
        stringCalTest(input, result);
    }

    @ValueSource(strings = {
            "9 / 2 * 2 ) 3",
            "R / 3",
            "",
            " ",
            "  ",
    })
    @DisplayName("IllegalArgumentException 테스트")
    @ParameterizedTest
    public void illegalArgumentExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                stringCalTest(input, -1)
        );
    }

    @ValueSource(strings = {
            "5 / 0",
            "9 / 3 / 4 / 0",
            "2 - 1 - 5 / 0",
            "2 / 0 + 1"
    })
    @DisplayName("ArithmeticException 테스트")
    @ParameterizedTest
    public void arithmeticExceptionTest(String input) {
        assertThatThrownBy(() ->
                stringCalTest(input, -1)
        ).isInstanceOf(ArithmeticException.class);
    }
}
