package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.strategy.NormalMove;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStrategy {
    @Test
    void NormalMove_경계선값_4_true_반환() {
        assertThat(new NormalMove(4).movable()).isTrue();
    }

    @Test
    void NormalMove_경계선값_9_true_반환() {
        assertThat(new NormalMove(9).movable()).isTrue();
    }

    @Test
    void NormalMove_값_10_false_반환() {
        assertThat(new NormalMove(10).movable()).isFalse();
    }

    @Test
    void NormalMove_음수값_false_반환() {
        assertThat(new NormalMove(-1).movable()).isFalse();
    }
}
