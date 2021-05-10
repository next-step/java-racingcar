package calculaor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculationTest {
    // 정상 케이스 테스트
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10","2 + 3 * 4,20","3 * 4 / 2,6"})
    void calculationTest(String inputValue, int expected) {
        // given
        Calculation calculator = new Calculation();

        // when
        int actual = Calculation.calculation(inputValue);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    // 예외 테스트
    @ParameterizedTest
    @ValueSource(strings = {" ","","^","%"})
    void calculationExceptionTest(String exceptionValue) {
        // given
        Calculation calculation = new Calculation();

        //then
        assertThatIllegalArgumentException().isThrownBy(()
                -> calculation.calculation(exceptionValue));
    }

}
