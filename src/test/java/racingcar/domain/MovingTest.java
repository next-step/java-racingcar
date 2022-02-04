package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
    List<String> inputs = new ArrayList<>(Arrays.asList("c", "java"));

    @Test
    void moveForwardTest() {
        Cars cars = Cars.of(inputs, new FixedForwardStrategy(true));
        RacingGame.from(cars).drive(1, ResultView.instance());
        assertThat(cars.getCars().get(0).getStep()).isEqualTo(1);
    }

    @Test
    void noMoveForwardTest() {
        Cars cars = Cars.of(inputs, new FixedForwardStrategy(false));
        RacingGame.from(cars).drive(1, ResultView.instance());
        assertThat(cars.getCars().get(1).getStep()).isEqualTo(0);
    }

    @Test
    void randomForwardStrategyTest() {
        RandomForwardStrategy randomForwardStrategy = new RandomForwardStrategy();
        assertThat(randomForwardStrategy.move(5)).isTrue();
        assertThat(randomForwardStrategy.move(2)).isFalse();
    }

}
