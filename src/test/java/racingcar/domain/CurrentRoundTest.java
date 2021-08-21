package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CurrentRoundTest {
    @Test
    void checkValidCurrentRound() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CurrentRound currentRound = new CurrentRound(-1);
                });

        assertThat(new CurrentRound(0));
    }

    @Test
    void runOneRound() {
        CurrentRound currentRound = new CurrentRound();
        assertThat(currentRound.runOneRound()).isEqualToComparingFieldByField(new CurrentRound(1));
    }
}
