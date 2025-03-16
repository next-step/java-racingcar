package calculator;

import static org.assertj.core.api.Assertions.*;

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
    void delimiterTest() {
        int result = StringCalculator.calculate("1, 2");
        assertThat(result).isEqualTo(3);
    }
}
