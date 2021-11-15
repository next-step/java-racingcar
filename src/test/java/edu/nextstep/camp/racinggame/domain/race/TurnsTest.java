package edu.nextstep.camp.racinggame.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TurnsTest {

    @Test
    public void create() {
        assertThat(Turns.of(1).total()).isEqualTo(Turn.of(1));
    }

    @Test
    public void createFailed() {
        assertThatIllegalArgumentException().isThrownBy(() -> Turns.of(0));
    }

    @Test
    @DisplayName("get current turn")
    public void current() {
        Turns testTurns = Turns.of(1);
        assertThat(testTurns.current()).isEqualTo(Turn.of(0));
    }

    @Test
    @DisplayName("go to next turn")
    public void next() {
        final Turns testTurns = Turns.of(1);
        assertThat(testTurns.current()).isEqualTo(Turn.of(0));
        testTurns.next();
        assertThat(testTurns.current()).isEqualTo(Turn.of(1));
    }

    @Test
    @DisplayName("check end")
    public void isEnded() {
        final Turns testTurns = Turns.of(1);
        assertThat(testTurns.hasNext()).isTrue();
        assertThat(testTurns.current()).isEqualTo(Turn.of(0));
        testTurns.next();
        assertThat(testTurns.current()).isEqualTo(Turn.of(1));
        assertThat(testTurns.hasNext()).isFalse();
    }
}
