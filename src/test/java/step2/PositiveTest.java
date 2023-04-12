package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/13
 */
public class PositiveTest {

    @Test
    void 양수로_생성() {
        Positive positive = new Positive(1);
        assertThat(positive.value()).isEqualTo(1);
    }

    @Test
    void 음수로_생성시_예외() {
        assertThatThrownBy(() -> new Positive(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
