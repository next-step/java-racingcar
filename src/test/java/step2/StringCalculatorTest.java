package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void plus() {
        assertThat(Calculator.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    void minus() {

    }

    @Test
    void times() {

    }

    @Test
    void divideBy() {

    }

    @Test
    void nullOrBlankInput() {

    }

    @Test
    void illegalOperationChar() {

    }

    @Test
    void multipleOperation() {

    }
}
