package step3and4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositiveTest {

    @DisplayName("양수가 아니면 예외를 던진다.")
    @Test
    void create() {
        assertThatThrownBy(() -> new Positive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가지고 있는 원시값이 마이너스가 될 경우 0으로 초기화를 한다.")
    @Test
    void move() {
        Positive positive = new Positive();
        positive.move(-1);
        assertThat(positive.number()).isEqualTo(0);
    }
}
