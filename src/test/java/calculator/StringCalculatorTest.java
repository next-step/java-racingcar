package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    @DisplayName("숫자 하나를 문자로 입력받아서 그대로 숫자로 반환")
    void parseTest() {
        int result = StringCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 합을 반환")
    void commaDelimiterTest() {
        int result = StringCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 여러개를 컴마 또는 콜론 구분자로 입력할 경우에도 합을 반환")
    void complexDelimiterTest() {
        int result = StringCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    void emptyOrNullTest() {
        int resultEmpty = StringCalculator.calculate("");
        int resultOfNull = StringCalculator.calculate(null);
        Assertions.assertAll(
            () -> assertThat(resultEmpty).isEqualTo(0),
            () -> assertThat(resultOfNull).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 지정 시 해당 구분자로 숫자를 분리하여 합을 반환")
    void customDelimiterTest() {
        int result = StringCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 시 RuntimeException 발생")
    void negativeNumberTest() {
        Assertions.assertAll(
            () -> assertThatThrownBy(
                () -> StringCalculator.calculate("-1,2,3")
            ).isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(
                () -> StringCalculator.calculate("-1")
            ).isInstanceOf(RuntimeException.class)
        );
    }
}
