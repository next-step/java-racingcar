package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringCalculator.StringCalculator.calculate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void 계산() {
        assertThat(calculate("1 + 2 * 3 / 4")).isEqualTo(2);
    }

    @Test
    void 덧셈(){
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }

    @Test
    void 뺌셈(){
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    void 곱셈(){
        assertThat(calculate("3 * 1")).isEqualTo(3);
    }

    @Test
    void 나눗셈(){
        assertThat(calculate("4 / 2")).isEqualTo(2);
    }



}
