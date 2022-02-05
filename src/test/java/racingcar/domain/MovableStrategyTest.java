package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovableStrategyTest {
    List<String> inputs = new ArrayList<>(Arrays.asList("c", "java"));

    @Test
    void moveForwardTest() {
        Car jpa = Car.of("jpa", new FixedForwardStrategy(true));
        jpa.moveForward();

        assertThat(jpa.getStep()).isEqualTo(1);
    }

    @Test
    void noMoveForwardTest() {
        Car jpa = Car.of("jpa", new FixedForwardStrategy(false));
        jpa.moveForward();

        assertThat(jpa.getStep()).isEqualTo(0);
    }

    @Test
    void randomForwardStrategyTest() {
        RandomForwardStrategy randomForwardStrategy = new RandomForwardStrategy();
        assertThat(randomForwardStrategy.move(5)).isTrue();
        assertThat(randomForwardStrategy.move(2)).isFalse();
    }

}
