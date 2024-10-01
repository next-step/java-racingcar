package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 시 해당 숫자를 반환하는지 확인")
    void oneStringNumTest() {
        int result = StringAddCalculator.cal("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마를 구분자로 나뉘어 각 숫자의 합을 반환하는지 확인")
    void sumWithCommaDelimiter() {
        int result = StringAddCalculator.cal("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론을 구분자로 나뉘어 각 숫자의 합을 반환하는지 확인")
    void sumWithColonDelimiter() {
        int result = StringAddCalculator.cal("1:2");
        assertThat(result).isEqualTo(3);
    }
}
