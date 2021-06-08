package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculationTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10","2 + 3 * 4,20","3 * 4 / 2,6"})
    @DisplayName("정상 케이스 테스트")
    void calculationTest(String inputValue, int expected) {
        // given
        Calculation calculation = new Calculation();

        // when
        int actual = calculation.calculation(inputValue);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    // 예외 테스트
    @ParameterizedTest
    @ValueSource(strings = {" ","","^","%"})
    @DisplayName("예외 케이스 테스트")
    void calculationExceptionTest(String exceptionValue) {
        // given
        Calculation calculation = new Calculation();

        //then
        assertThatIllegalArgumentException().isThrownBy(()
                -> calculation.calculation(exceptionValue));
    }

}
