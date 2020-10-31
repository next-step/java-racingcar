package step2;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("Testing for the four arithmetical operations")
    @ParameterizedTest
    @CsvSource(value  ={"2 + 3 * 4 / 2 : 10"},delimiter = ':')
    void calculator(final String str, final int result){
        assertThat(stringCalculator.calculate(str)).isEqualTo(result);
    }

    @DisplayName("Testing for value is null or blank")
    @ParameterizedTest
    @ValueSource(strings = {""," ","null"})
    void shouldExceptionForNullOrEmptyStrings(String str){
        assertThatIllegalArgumentException()
                .isThrownBy(()->stringCalculator.calculate(str));
    }

    @DisplayName("Testing for if it isn't operator")
    @ParameterizedTest
    @ValueSource(strings = {"2 & 3 $ 4"})
    void shouldExceptionByWrongsStrings(final String str){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(str));
    }

    @DisplayName("Testing for dividing zero test")
    @ParameterizedTest
    @ValueSource(strings = "5 + 3 * 4 / 0")
    void shouldExceptionDivideByZero(final String str){
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(()->stringCalculator.calculate(str))
                .isInstanceOf(ArithmeticException.class)
                .withMessage("0으로 나눌 수 없습니다.");

    }
}
