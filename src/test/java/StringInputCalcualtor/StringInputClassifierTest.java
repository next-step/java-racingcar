package StringInputCalcualtor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringInputClassifierTest {
    private final StringInputClassifier stringInputClassifier = new StringInputClassifier();

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
    void testOperandOperatorClassifyFail() {
        assertThatThrownBy(() -> {
            String[] sampleInput = {"2", "%", "3", "*", "4", "/", "2"};
            stringInputClassifier.classify(sampleInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void testInputWithFail(String value) {
        assertThatThrownBy(() -> {
            stringInputClassifier.input(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input() {
        String sampleInput = "2 + 3 * 4 / 2";
        stringInputClassifier.input(sampleInput);
        List<BigDecimal> operands = stringInputClassifier.getOperands();
        List<String> operators = stringInputClassifier.getOperators();

        assertThat(stringInputClassifier.getInput()).isEqualTo(sampleInput);
        assertThat(operands).containsExactly(BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4), BigDecimal.valueOf(2));
        assertThat(operators).containsExactly("+", "*", "/");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "1.1,true", "200,true", "0,true", "sdfg,false", "+,false"})
    void isOperand(String input, boolean expectedResult) {
        boolean result = stringInputClassifier.isOperand(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", "34,false", "e,false", "^,false", "%,false"})
    void isOperator(String input, boolean expectedResult) {
        boolean result = stringInputClassifier.isOperator(input);
        assertThat(result).isEqualTo(expectedResult);
    }
}
