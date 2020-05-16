package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("피연산자 테스트 클래스")
class OperandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "+", "a"})
    @DisplayName("문자열 숫자값 아닐 때 String to Int 실패 테스트")
    void faultValueParse(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operand.stringToInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    @DisplayName("문자열 숫자 변환 테스트")
    void faultValueParse(String input, int expected) {
        assertThat(Operand.stringToInt(input)).isEqualTo(expected);
    }
}