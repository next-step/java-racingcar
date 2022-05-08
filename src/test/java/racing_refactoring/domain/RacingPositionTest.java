package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingPositionTest {
    @DisplayName("순차적으로 움직임 확인")
    @Test
    void move_sequential() {
        RacingPosition racingPosition = new RacingPosition(1);
        RacingPosition movedPosition = racingPosition.move();

        assertThat(movedPosition).isEqualTo(new RacingPosition(2));
    }
}