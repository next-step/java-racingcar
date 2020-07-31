package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stringcalculator.CommonException;
import stringcalculator.StringCarculator;
import stringcalculator.CommonConstant;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private StringCarculator stringCarculator;

    @BeforeEach
    void setUp() {
        stringCarculator = new StringCarculator();
    }

    @Test
    void claculatorTest() {
        String testCase = "2 + 3 * 4 / 2";
        CommonException.inputExpressionInValidException(testCase);

        List<String> inputArray = Arrays.asList(testCase.split(CommonConstant.DELIMITER));
        int result = Integer.parseInt(inputArray.get(0));

        for (int i = 1; i < inputArray.size(); i += 2) {
            String operator = inputArray.get(i);
            int number = Integer.parseInt(inputArray.get(i + 1));
            result = stringCarculator.getStringCalculator(operator, result, number);
        }
        
        assertThat(result).isEqualTo(10);
    }
}
