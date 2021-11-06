package level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest()
    @ValueSource(strings = {"2 ^ 3"})
    void illegalOperator(String input){
        String[] inputs = input.split(" ");

        assertThatThrownBy(() -> {
                    Operator operator = Arrays.stream(Operator.values())
                            .filter(o -> o.isEqualTo(inputs[1]))
                            .findAny().orElseThrow(() -> new IllegalArgumentException());
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }

    //덧셈
    @ParameterizedTest()
    @ValueSource(strings = {"2 + 3"})
    void plus(String input) {
        String[] inputs = input.split(" ");

        Number number1 = new Number(inputs[0]);
        Number number2 = new Number(inputs[2]);

        Operator operator = Arrays.stream(Operator.values())
                                .filter(o ->o.isEqualTo(inputs[1]))
                                .findAny().orElseThrow(() -> new IllegalArgumentException());

        int result = stringCalculator.calculate(number1, operator, number2);
        assertThat(result).isEqualTo(5);
    }

    //뺄셈
    @ParameterizedTest()
    @ValueSource(strings = {"10 - 3"})
    void minus(String input) {
        String[] inputs = input.split(" ");

        Number number1 = new Number(inputs[0]);
        Number number2 = new Number(inputs[2]);

        Operator operator = Arrays.stream(Operator.values())
                .filter(o ->o.isEqualTo(inputs[1]))
                .findAny().orElseThrow(() -> new IllegalArgumentException());

        int result = stringCalculator.calculate(number1, operator, number2);
        assertThat(result).isEqualTo(7);
    }

    //곱셈
    @ParameterizedTest()
    @ValueSource(strings = {"211 * 3"})
    void multiply(String input) {
        String[] inputs = input.split(" ");

        Number number1 = new Number(inputs[0]);
        Number number2 = new Number(inputs[2]);

        Operator operator = Arrays.stream(Operator.values())
                .filter(o ->o.isEqualTo(inputs[1]))
                .findAny().orElseThrow(() -> new IllegalArgumentException());

        int result = stringCalculator.calculate(number1, operator, number2);
        assertThat(result).isEqualTo(633);
    }

    //나눗셈
    @ParameterizedTest()
    @ValueSource(strings = {"1230 / 10"})
    void divide(String input) {
        String[] inputs = input.split(" ");

        Number number1 = new Number(inputs[0]);
        Number number2 = new Number(inputs[2]);

        Operator operator = Arrays.stream(Operator.values())
                .filter(o ->o.isEqualTo(inputs[1]))
                .findAny().orElseThrow(() -> new IllegalArgumentException());

        int result = stringCalculator.calculate(number1, operator, number2);
        assertThat(result).isEqualTo(123);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculate(String input) {
        Factor factor = new Factor(input);
        int result = stringCalculator.calculate(factor);
        assertThat(result).isEqualTo(10);
    }
}