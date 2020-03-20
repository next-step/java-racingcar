package StringCalculatorTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculationTests {

    @DisplayName("계산식 : {0} , 결과 : {1}")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3,5", "3 + 4 + 1,8", "1 + 2 + 3 + 4,10",
            "3 - 2,1", "4 - 2 - 2,0", "9 - 3 - 2 - 1,3",
            "3 * 2,6", "4 * 2 * 2,16", "9 * 3 * 2 * 2,108",
            "4 / 2,2", "15 / 5 / 3,1", "60 / 3 / 5 / 2,2",
            "2 + 3 * 4 / 2,10", "6 + 3 / 9 - 1 + 8 * 4 / 2,16"
    })
    public void stringAddTest(String expression, Integer expectedResult) {
        Integer actualResult = StringCalculator.calculate.operate(expression);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
