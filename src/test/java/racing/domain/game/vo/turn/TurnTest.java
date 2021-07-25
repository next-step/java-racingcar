package racing.domain.game.vo.turn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class TurnTest {
    @DisplayName("Turn ctor Test")
    @Test
    public void ctorTest() {
        assertThat(new Turn().isWaiting())
                .isTrue();
    }

    @DisplayName("Turn Finish Test")
    @Test
    public void finishTest() {
        Turn turn = new Turn();
        //turn.finish();
        assertThat(turn.isWaiting())
                .isFalse();
    }
}