package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("add 연산 테스트")
    @CsvSource(value = {"-1:2:1", "1:0:1"}, delimiter = ':')
    void addTest(Double value, Double value2, Double expected){
        assertThat(ADD.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("subtract 연산 테스트")
    @CsvSource(value = {"1:2:-1", "1:0:1"}, delimiter = ':')
    void subTractTest(Double value, Double value2, Double expected){
        assertThat(SUBTRACT.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("multiply 연산 테스트")
    @CsvSource(value = {"1:2:2", "1:0:0"}, delimiter = ':')
    void multiplyTest(Double value, Double value2, Double expected){
        assertThat(MULTIPLY.operate(value, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("divide 연산 테스트")
    @CsvSource(value = {"4:2:2", "1:1:1", "0:1:0"}, delimiter = ':')
    void divideTest(Double value, Double value2, Double expected){
        assertThat(DIVIDE.operate(value, value2)).isEqualTo(expected);
    }
}
