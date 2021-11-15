package edu.nextstep.camp.racinggame.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TurnTest {
    @Test
    @DisplayName("create turn")
    public void create() {
        final int testTurn = 0;
        assertThat(Turn.of(testTurn).toInt()).isEqualTo(testTurn);
        assertThat(Turn.of(testTurn)).isEqualTo(Turn.of(testTurn));
    }

    @Test
    @DisplayName("creation failed")
    public void createFailed() {
        assertThatIllegalArgumentException().isThrownBy(() -> Turn.of(-1));
    }
}
