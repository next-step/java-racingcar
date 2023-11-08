package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)")
    @ParameterizedTest(name = "입력값: {0}")
    @NullAndEmptySource
    void null_빈문자열_값(String input) {
        assertThat(calculate(input)).isEqualTo(0);
    }

    @DisplayName("2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "0,0", "9,9"})
    void 숫자_하나(String input, int expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @DisplayName("3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "2,3,1,0", "2,2,2"})
    void 콤마_구분자(String input) {
        assertThat(calculate(input)).isEqualTo(6);
    }

    @DisplayName("4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    @Test
    void 콜론_구분자() {
        assertThat(calculate("1:2:3")).isEqualTo(6);
    }

    @DisplayName("5. “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    @Test
    void 커스텀_구분자() {
        assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    @Test
    void 음수() {
        assertThatThrownBy(()-> calculate("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
