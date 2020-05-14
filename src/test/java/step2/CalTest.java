package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalTest {

    Calculator cal = new Calculator();

    @Test
    void plus(){
        String input = "1 + 2 + 5";

        double result = cal.calculator(input);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void minu(){
        String input = "5 - 2 - 2";

        double result = cal.calculator(input);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void mul(){
        String input = "2 * 2 * 5";

        double result = cal.calculator(input);

        assertThat(result).isEqualTo(20);
    }

    @Test
    void div(){
        String input = "6 / 2";

        double result = cal.calculator(input);

        assertThat(result).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(strings = { "", " ", "  " })
    @DisplayName("Null 체크")
    void nullCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            {
                cal.calculator(input);
            }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 ^ 2", "2 ^ 2", "2 % 2" })
    @DisplayName("사칙연산이 기호가 아닌 경우")
    void arithmeticOperationsCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    cal.calculator(input);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 + a", "3 + &"})
    @DisplayName("숫자가 아닌 경우")
    void NumCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    cal.calculator(input);
                }
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForCalculate")
    @DisplayName("다수의 사칙 연산 체크")
    void calculate(String input, double result) {
        assertThat(Calculator.calculator(input)).isEqualTo(result);
    }

    private static Stream<Arguments> provideStringsForCalculate() {
        return Stream.of(
                Arguments.of("2 + 3 - 4 * 2", "2"),
                Arguments.of("4 * 1 / 2 + 5", "7"),
                Arguments.of("6 + 1 * 8 - 2", "54")
        );
    }

    @Test
    void checkOperator(){
        double plusResult = Operator.PLUS.operate(1,2);
        assertThat(plusResult).isEqualTo(3);

        double minusResult = Operator.MINUS.operate(2, 1);
        assertThat(minusResult).isEqualTo(1);

        double multiplyResult = Operator.MULTIPLY.operate(1, 2);
        assertThat(multiplyResult).isEqualTo(2);

        double divideResult = Operator.DIVIDE.operate(4, 2);
        assertThat(divideResult).isEqualTo(2);
    }

}
