package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator Calculator;

    @BeforeEach
    void calculatorSetup(){
        Calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value ={"1 + 2 = 3", "2 + 2 = 4", "3 + 5 = 8"}, delimiter = '=')
    void addTest(String input, String result){
        assertThat(Calculator.cal(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value ={"3 - 2 = 1", "4 - 2 = 2", "5 - 5 = 0"}, delimiter = '=')
    void subtractTest(String input, String result){
        assertThat(Calculator.cal(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value ={"3 * 2 = 6", "4 * 2 = 8", "5 * 5 = 25"}, delimiter = '=')
    void multiplyTest(String input, String result){
        assertThat(Calculator.cal(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value ={"3 / 2 = 1.5", "4 / 2 = 2", "5 / 5 = 1"}, delimiter = '=')
    void divisionTest(String input, String result){
        assertThat(Calculator.cal(input)).isEqualTo(result);
    }

}
