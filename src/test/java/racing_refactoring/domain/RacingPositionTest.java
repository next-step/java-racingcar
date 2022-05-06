package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingPositionTest {

    @DisplayName("mutable 확인")
    @Test
    void mutable() {
        MovingStrategy movingStrategy = new SequentialMovingStrategy();
        RacingPosition racingPosition = new RacingPosition(1);
        RacingPosition movedPosition = racingPosition.move(movingStrategy);

        assertThat(racingPosition).isEqualTo(new RacingPosition(1));
        assertThat(movedPosition).isEqualTo(new RacingPosition(2));
    }

    @DisplayName("순차적으로 움직임 확인")
    @Test
    void move_sequential() {
        MovingStrategy movingStrategy = new SequentialMovingStrategy();
        RacingPosition racingPosition = new RacingPosition(1);
        RacingPosition movedPosition = racingPosition.move(movingStrategy);

        assertThat(movedPosition).isEqualTo(new RacingPosition(2));
    }
}