package step4;

import org.junit.jupiter.api.Test;
import step4.model.RemainingRound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RemainingRoundTest {

    @Test
    void create() {
        assertThat(new RemainingRound(1)).isEqualTo(new RemainingRound(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new RemainingRound(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        RemainingRound remainingRound = new RemainingRound(1);
        remainingRound.race();
        assertThat(remainingRound.racing()).isFalse();
    }
}
