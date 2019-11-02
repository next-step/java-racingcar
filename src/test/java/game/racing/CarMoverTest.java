package game.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/29
 */
public class CarMoverTest {

    @DisplayName("움짐임 전략에 따른 움직임 결정")
    @Test
    void random() {
        MoveStrategy moveStrategy = (number, threshold) -> number >= threshold;
        assertThat(CarMover.movable(moveStrategy, 10, 3)).isTrue();
        assertThat(CarMover.movable(moveStrategy, -10, 3)).isFalse();
    }
}
