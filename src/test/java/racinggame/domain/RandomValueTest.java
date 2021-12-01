package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomValueTest {
    @Test
    void create() {
        assertThat(new RandomValue(3)).isEqualTo(new RandomValue(3));

        assertThatThrownBy(() -> {
            new RandomValue(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new RandomValue(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isMovable() {
        assertThat(new RandomValue(3).isMovable()).isFalse();
        assertThat(new RandomValue(4).isMovable()).isTrue();
    }
}
