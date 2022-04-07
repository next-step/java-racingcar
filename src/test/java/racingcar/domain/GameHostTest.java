package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameHostTest {

    private final int rounds = 10;
    private GameHost host = new GameHost(Collections.emptyList(), rounds);

    @Test
    void rounds_만큼_proceedRound_호출하면_정상동작() {

        assertThatNoException().isThrownBy(() -> {
            for (int i = 0; i < rounds; i++) {
                host.proceedRound();
            }
        });
    }

    @Test
    void rounds_보다_proceedRound_많이_호출하면_예외() {

        assertThatThrownBy(() -> {
            for (int i = 0; i < rounds + 1; i++) {
                host.proceedRound();
            }
        }).isInstanceOf(IllegalStateException.class);
    }
}