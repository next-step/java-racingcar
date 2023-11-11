package com.racing.game;

import static org.assertj.core.api.Assertions.assertThat;

import com.racing.game.vo.Progress;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void isGreater() {
        assertThat(Progress.from(3).isGreaterThan(2)).isTrue();
        assertThat(Progress.from(3).isGreaterThan(3)).isFalse();
        assertThat(Progress.from(3).isGreaterThan(4)).isFalse();
    }

    @Test
    void isSame() {
        assertThat(Progress.from(3).isSame(2)).isFalse();
        assertThat(Progress.from(3).isSame(3)).isTrue();
        assertThat(Progress.from(3).isSame(4)).isFalse();
    }
}
