package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import step1.racing.data.GameCount;

class GameCountTest {

    @Test
    void throws_exception_if_under_zero_value() {
        assertThatThrownBy(() -> new GameCount(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void playable_only_given_times() {
        GameCount sut = new GameCount(5);

        for (int i = 0; i < 5; i ++) {
            sut.isPlayable();
        }

        assertThat(sut.isPlayable()).isFalse();
    }
}
