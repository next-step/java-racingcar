package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @DisplayName("\"\" 를 입력하면 0을 반환한다")
    @Test
    void emptyInput() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 을 입력하면 0을 반환한다")
    @Test
    void nullInput() {
        int result = StringCalculator.add(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("\"1\" 을 입력하면 1을 반환한다")
    @Test
    void singleNumber() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("\"1,2\" 를 입력하면 3을 반환한다")
    @Test
    void commaDelimiter() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("\"1:2\" 를 입력하면 3을 반환한다")
    @Test
    void colonDelimiter() {
        int result = StringCalculator.add("1:2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("\"1,2:3\" 을 입력하면 6을 반환한다")
    @Test
    void multipleNumbers() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }
}
