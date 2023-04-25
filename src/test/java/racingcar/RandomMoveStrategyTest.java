package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {
    @Test
    @DisplayName("4 이상일 때 이동한다")
    public void isMovable_True() {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new MockRandom(4));
        assertThat(randomMoveStrategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("3 미만일 때 이동하지 않는다")
    public void isMovable_False() {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new MockRandom(3));
        assertThat(randomMoveStrategy.isMovable()).isFalse();
    }
}
