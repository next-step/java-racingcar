package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositiveTest {

    @Test
    void 정상생성_테스트한다() {
        Positive positive = new Positive(1);
        assertThat(positive.getPositiveNumber()).isEqualTo(1);
    }

    @Test
    void 음수생성_실패한다() {
        assertThatThrownBy(() -> {
            new Positive(-1);
        }).isInstanceOf(RuntimeException.class);
    }

}