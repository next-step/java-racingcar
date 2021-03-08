package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
    생각하면서 할 것!
    * 중복코드가 없도록 Test 어노테이션 종류를 잘 활용할 것
 */
public class CalculatorTest {

    private final StringCalculations calculations = new StringCalculations();

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 + 5,10", "4 - 2 * 5,10"})
    @DisplayName("여러 연산자가 들어왔을 경우 테스트")
    void calculateTest(String data, int expected) {
        assertThat(calculations.calculate(data)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "^"})
    @DisplayName("잘못된 연산자에 대한 테스트")
    void getOperator(String symbol) {
        assertThatThrownBy(() -> {
            OperationManager.getOperator(symbol);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
