package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(Car.of("c", new FixedForwardStrategy(true)));
        cars.add(Car.of("java", new FixedForwardStrategy(false)));
    }

    @Test
    void moveForwardTest() {
        Racing.instance().drive(cars);
        assertThat(cars.get(0).getStep()).isEqualTo(1);
    }

    @Test
    void noMoveForwardTest() {
        Racing.instance().drive(cars);
        assertThat(cars.get(1).getStep()).isEqualTo(0);
    }

}
