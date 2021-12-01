package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryNoTest {
    @Test
    void race() {
        TryNo tryNo = new TryNo(2);

        // first race
        tryNo.race();
        assertThat(tryNo.racing()).isTrue();

        // second race
        tryNo.race();
        assertThat(tryNo.racing()).isFalse();
    }
}
