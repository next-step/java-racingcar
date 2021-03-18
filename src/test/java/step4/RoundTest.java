package step4;

import org.junit.jupiter.api.Test;
import step4.model.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @Test
    void create() {
        assertThat(new Round(1)).isEqualTo(new Round(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        Round round = new Round(1);
        round.race();
        assertThat(round.racing()).isFalse();
    }
}
