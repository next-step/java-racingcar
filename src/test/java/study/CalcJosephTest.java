
package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.provider.CsvSource;
import study.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CalcJosephTest {

    private CalcJoseph calcJoseph;

    @BeforeEach
    public void setUp() {
        calcJoseph = new CalcJoseph();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "5 * 4 + 3 / 2 - 5"})
    void 문자열_계산을_수행한다(String input) {
        // given
        String[] arrays = input.split(" ");
        float result = Float.parseFloat(arrays[0]);

        // when
        for (int i = 1; i < arrays.length; i += 2) {
            result = calculate(result, arrays[i], Float.parseFloat(arrays[i + 1]));
        }

        // then
        System.out.println("result: " + result);
    }


    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 기호연산이_유효한지_검증한다(String operation) {

        // given
   /*     checkOperation(operation);

        // when
        String unsupportedOpt = ":";

        Assertions.assertThatThrownBy(() -> {
            checkOperation(unsupportedOpt);
        }).isInstanceOf(IllegalArgumentException.class);*/
    }

    private float calculate(float number1, String operation, float number2) {
        switch (operation) {
            case "+":
                return calcJoseph.add(number1, number2);
            case "-":
                return calcJoseph.subtraction(number1, number2);
            case "*":
                return calcJoseph.multiply(number1, number2);
            case "/":
                return calcJoseph.divide(number1, number2);
            default:
                throw new IllegalArgumentException("유효하지 않는 연산입니다. operator: " + operation);
        }
    }

/*    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 8 / 5 * 2 + 3"})
    void calculator_joseph(final String input) {
        CalcJoseph cal1 = new CalcJoseph();
        System.out.println(cal1.calculateFinal(input));
    }*/


    @ParameterizedTest
    @ValueSource(strings = {"2,3,5", "8,2,6", "5,4,20", "6,2,3"})
    void 사칙연산을_계산한다(String input) {

        String[] arrays = input.split(",");
        float number1 = Float.parseFloat(arrays[0]);
        float number2 = Integer.parseInt(arrays[1]);
        float expected = Integer.parseInt(arrays[2]);

        assertThat(expected).isEqualTo(calcJoseph.add(number1, number2));
    }
}