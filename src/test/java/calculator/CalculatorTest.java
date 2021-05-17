package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

//    @Test
//    @BeforeEach
//    void test() {
//        Calculator cal = new Calculator();
//        String sentence = "2 + 3 * 4 / 2";
//        final String[] arr = sentence.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            if (!cal.isStringDouble(arr[i].toString())) {
//                int num1 = Integer.valueOf(arr[i - 1]);
//                int num2 = Integer.valueOf(arr[i + 1]);
//            }
//        }
//    }
//
//    @DisplayName("사칙연산의 종류를 파악하는 함수")
//    @ParameterizedTest
//    @CsvSource(value = {"+:1:2:3", "-:3:4:-1", "*:4:30:120", "/:5:40:"}, delimiter = ':')
//    void test(String input, int num1, int num2, int result) {
//        Calculator cal = new Calculator();
//        int idx = cal.calculatorInput(input);
//        String plus = cal.plus(idx, num1, num2);
//        String minus = cal.minus(idx, num1, num2);
//        String multiply = cal.multiply(idx, num1, num2);
//        String divide = cal.divide(idx, num1, num2);
//        assertThat(cal.plus(idx, num1, num2)).isEqualTo(result);
//    }

    @Test
    void 더하기() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(3, 5);
        assertThat(result).isEqualTo(8);

        int result2 = calculator.plus(-9, 5);
        assertThat(result2).isEqualTo(-4);
    }

    @Test
    void 빼기() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(9, 8);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱하기() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(9, 8);
        assertThat(result).isEqualTo(72);
    }

    @Test
    void 나누기() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(9, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 나누기_실패() {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(
                () -> calculator.divide(9, 0)
        );
    }
}
