package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {
    @Test
    void create() {
        assertThat(new TryNo(1)).isEqualTo(new TryNo(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new TryNo(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        TryNo tryNo = new TryNo(1);
        tryNo.race();
        assertThat(tryNo.racing()).isFalse();
    }
}
