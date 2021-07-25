package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    private final MoveStrategy moveStrategy = new RandomMoveStrategy();

    @DisplayName("숫자가 4 미만이면 전진할 수 없다.")
    @Test
    void stopIfNumberIsUnder4() {
        assertThat(moveStrategy.isMovable(3)).isFalse();
    }

    @DisplayName("숫자가 4 이상이면 전진할 수 있다.")
    @Test
    void movableIfNumberIsMoreThan4() {
        assertThat(moveStrategy.isMovable(4)).isTrue();
    }

}