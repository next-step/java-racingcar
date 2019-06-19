package study.racingcar.model;

import org.junit.jupiter.api.Test;
import study.racingcar.strategy.ManualMovableStrategy;
import study.racingcar.strategy.MovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CarTest {
    private static final int DEFAULT_POSITION = 1;

    @Test
    void run_position_증가() {
        MovableStrategy strategy = new ManualMovableStrategy(true);
        Car car = new Car("test", strategy);

        assertThat(car.run()).isEqualTo(DEFAULT_POSITION + 1);
    }

    @Test
    void run_position_변경없음() {
        MovableStrategy strategy = new ManualMovableStrategy(false);
        Car car = new Car("test", strategy);

        assertThat(car.run()).isEqualTo(DEFAULT_POSITION);
    }
}
