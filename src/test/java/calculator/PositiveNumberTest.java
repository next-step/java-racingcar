package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
    @Test
    void 객체_생성() {
        assertThat(PositiveNumber.from("1")).isEqualTo(PositiveNumber.from(1));
    }

    @Test
    void 덧셈() {
        PositiveNumber positive = PositiveNumber.from(1);
        PositiveNumber result = positive.plus(2);
        assertThat(result).isEqualTo(PositiveNumber.from(3));
    }

    @Test
    void 뺄셈() {
        assertThatThrownBy(() -> PositiveNumber.from(-1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> PositiveNumber.from("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
