package racingcar.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.strategy.MovingStrategyType.RANDOM;

public class MovingStrategyFactoryTest {

    @Test
    void randomMovingStrategy() {
        assertThat(MovingStrategyFactory.getInstance(RANDOM))
                .isInstanceOf(RandomMovingStrategy.class);
    }

}
