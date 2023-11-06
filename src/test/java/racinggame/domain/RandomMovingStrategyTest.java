package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.strategy.MovingStrategy;
import racinggame.domain.strategy.RandomMovingStrategy;

public class RandomMovingStrategyTest {

    @ParameterizedTest(name = "random값이 {0}이면 false")
    @ValueSource(ints = {0, 1, 2, 3})
    void false_test(int input) {
        MovingStrategy movingStrategy = new RandomMovingStrategy(new TestRandomHolder(input));
        boolean actual = movingStrategy.movable();

        assertThat(actual).isFalse();
    }

    @ParameterizedTest(name = "random값이 {0}이면 true")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void true_test(int input) {
        MovingStrategy movingStrategy = new RandomMovingStrategy(new TestRandomHolder(input));
        boolean actual = movingStrategy.movable();

        assertThat(actual).isTrue();
    }

}
