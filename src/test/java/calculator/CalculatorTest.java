package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
public class CalculatorTest {
    Calculator calculator;


    @DisplayName("사칙연산을 사용하여 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3:9" , "2 + 4 / 2:3" , "5 + 5 - 1:9"}, delimiter = ':')
    public void calculator(String input , int result) {
        //GIVE
        String[] inputArray = input.split(" ");
        //WHEN
        int num = calculator.calculate(inputArray);
        //THEN
        assertThat(num).isEqualTo(result);
    }

    @BeforeEach
    void createInstance() {
        calculator = new Calculator();
    }
}
