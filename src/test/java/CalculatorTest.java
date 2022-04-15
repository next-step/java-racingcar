import Calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("NULL 또는 공백일 경우 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void ifEmptyReturnZero(String input) {
        assertThat(calculator.add(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나만 넘겼을 때 숫자 하나만 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1" , "2", "3", "4"})
    void oneStringReturnNumber(String input) {
        assertThat((calculator.add(input))).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 2개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "5,8:13", "5,0:5"}, delimiter = ':')
    void twoNumberReturnSum(String input, String expected) {
        assertThat(calculator.add(input)).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("구분자가 콜론일 때")
    @ParameterizedTest
    @CsvSource(value = {"1:2;3", "5:8;13", "5:0;5","1,2:3;6"}, delimiter = ';')
    void separatorColonSum(String input, String expected) {
        assertThat(calculator.add(input)).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("커스텀 구분자를 통한 합계")
    @Test
    void customSeparatorSum() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수 아닌 값 입력시 RuntimeException")
    @ParameterizedTest
    @ValueSource(strings = {"-1:2:5", "-5:8,15"})
    void negativeNumberThrowRuntimeException(String input) throws Exception {
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(RuntimeException.class).hasMessage("음수를 입력할 수 없습니다.");
    }

    @DisplayName("숫자가 아닌 값 입력시 RuntimeException")
    @ParameterizedTest
    @ValueSource(strings = {"x:2:5", "?:y,15"})
    void notNumberThrowRuntimeException(String input) throws Exception {
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(RuntimeException.class).hasMessage("숫자만 입력할 수 있습니다.");
    }
}
