package StringInputCalcualtor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringInputClassifierTest {
    StringInputClassifier stringInputClassifier = new StringInputClassifier();

    @Test
    void testOperandOperatorClassify() {
        String[] sampleInput = {"2", "+", "3", "*", "4", "/", "2"};
        stringInputClassifier.classify(sampleInput);

        List<BigDecimal> operands = stringInputClassifier.getOperands();
        List<String> operators = stringInputClassifier.getOperators();

        assertThat(operands).containsExactly(BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4), BigDecimal.valueOf(2));
        assertThat(operators).containsExactly("+", "*", "/");
    }

    @Test
    void input() {
    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "=,true", "*,true", "/,true", "34,false", "e,false"}, delimiter = ',')
    void isOperand(String input, boolean expectedResult) {
        boolean result = stringInputClassifier.isOperand(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void isOperator() {
    }
}
