package study.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.strategy.ManualMovableStrategy;
import study.racingcar.strategy.MovableStrategy;
import study.racingcar.strategy.RandomMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CarTest {
    private static final int DEFAULT_POSITION = 1;

    @ParameterizedTest
    @CsvSource({
            "pobi",
            "crong",
            "honux"
    })
    void 자동차_이름(String name) {
        RandomMovableStrategy strategy = new RandomMovableStrategy();
        Car car = new Car(name, strategy);

        assertThat(car.getName()).isEqualTo(name);
    }

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
