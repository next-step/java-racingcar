package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private Calculator calculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = {"1 * 2 + 3 / 4:2.5", "10 * 3 / 2 + 5:20"}, delimiter = ':')
    @DisplayName("StringCalculator 계산 테스트")
    public void calculateTest(String arg, String expected){
        assertThat(calculator.calculate(arg)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 * 2 + 3", "1 ! 2"})
    @DisplayName("StringCalculator 계산 예외 테스트")
    public void illegalArgumentTest(String arg){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(arg));
    }

}
