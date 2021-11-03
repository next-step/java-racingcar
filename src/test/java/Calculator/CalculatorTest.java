package Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.zip.DataFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @ParameterizedTest
    @CsvSource(value = {"3 + 2 : 5", "6 + 7 : 13"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(String input, Integer expected) throws DataFormatException {
        calculator = new Calculator(input);
        assertThat(calculator.execute()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 - 2 : 1", "6 - 7 : -1"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtract(String input, Integer expected) throws DataFormatException {
        calculator = new Calculator(input);
        assertThat(calculator.execute()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 * 2 : 6", "6 * 7 : 42"}, delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multiply(String input, Integer expected) throws DataFormatException {
        calculator = new Calculator(input);
        assertThat(calculator.execute()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2 : 2", "6 / 2 : 3"}, delimiter = ':')
    @DisplayName("나눗셈 테스트")
    void divide(String input, Integer expected) throws DataFormatException {
        calculator = new Calculator(input);
        assertThat(calculator.execute()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = "4 / 0")
    @DisplayName("나눗셈을 0으로 나누려고 할 때 예외처리 테스트")
    void divideException(String input) throws DataFormatException {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                calculator = new Calculator(input);
                calculator.execute();
            })
            .withMessage("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "4 - 3 * 4 / 2:2"}, delimiter = ':')
    @DisplayName("다중 연산 테스트")
    void calculate(String input, Integer expected) throws DataFormatException {
        calculator = new Calculator(input);
        assertThat(calculator.execute()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = "2 + 3 * 4 a 2:a", delimiter = ':')
    @DisplayName("연산자가 아닌 다른 값이 들어왔을 경우 DataFormatException 테스트")
    void dataFormatException(String input, String expected) {
        assertThatExceptionOfType(DataFormatException.class)
            .isThrownBy(() -> {
                calculator = new Calculator(input);
                calculator.execute();
            })
            .withMessage("올바르지 않은 연산자 입니다. : %s", expected);
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 * a")
    @DisplayName("숫자가 아닌 다른 값이 들어왔을 경우 NumberFormatException 테스트")
    void numberFormatException(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> {
                calculator = new Calculator(input);
                calculator.execute();
            })
            .withMessage("For input string: %s", "\"a\"");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("파라미터가 빈 값일 경우 IllegalArgumentException 테스트")
    void illegalArgumentExceptionByEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                calculator = new Calculator(input);
                calculator.execute();
            })
            .withMessage("입력 값이 존재하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 * 5 * 2 *"})
    @DisplayName("파라미터가 빈 값일 경우 IllegalArgumentException 테스트")
    void illegalArgumentExceptionByWrongLength(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                calculator = new Calculator(input);
                calculator.execute();
            })
            .withMessage("수식이 올바르지 않습니다.");
    }
}
