package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;
import racingcar.domain.movable.RandomForwardStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class MovableStrategyTest {

    @Test
    void moveForwardTest() {
        FixedForwardStrategy fixedForwardStrategy = new FixedForwardStrategy(true);

        assertThat(fixedForwardStrategy.move(1)).isTrue();
    }

    @Test
    void noMoveForwardTest() {
        FixedForwardStrategy fixedForwardStrategy = new FixedForwardStrategy(false);

        assertThat(fixedForwardStrategy.move(1)).isFalse();
    }

    @Test
    void randomForwardStrategyTest() {
        RandomForwardStrategy randomForwardStrategy = new RandomForwardStrategy();
        assertThat(randomForwardStrategy.move(5)).isTrue();
        assertThat(randomForwardStrategy.move(2)).isFalse();
    }

}
