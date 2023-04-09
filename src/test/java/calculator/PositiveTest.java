package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTest {
    @Test
    void 문자열을_양수로_변환() {
        Positive positive = new Positive("3");
        assertThat(positive.number()).isEqualTo(3);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> new Positive("-3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_입력() {
        assertThatThrownBy(() -> new Positive("string")).isInstanceOf(RuntimeException.class);
    }
}
