package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("add 테스트 입니다.")
    @CsvSource(value = {"-1:2:1", "1:0:1"}, delimiter = ':')
    void addTest(String value, String value2, String expected){
        assertThat(Operator.add(Integer.parseInt(value),Integer.parseInt(value2)))
                .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("subtract 테스트 입니다.")
    @CsvSource(value = {"1:2:-1", "1:0:1"}, delimiter = ':')
    void subtractTest(String value, String value2, String expected){
        assertThat(Operator.subtract(Integer.parseInt(value),Integer.parseInt(value2)))
                .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("multiply 테스트 입니다.")
    @CsvSource(value = {"1:2:2", "1:0:0"}, delimiter = ':')
    void multiplyTest(String value, String value2, String expected){
        assertThat(Operator.multiply(Integer.parseInt(value),Integer.parseInt(value2)))
                .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @DisplayName("divide 테스트 입니다.")
    @CsvSource(value = {"4:2:2", "1:1:1", "0:1:0", "1:0:0"}, delimiter = ':')
    void divideTest(String value, String value2, String expected){
        assertThat(Operator.divide(Integer.parseInt(value),Integer.parseInt(value2)))
                .isEqualTo(Integer.parseInt(expected));
    }
}
