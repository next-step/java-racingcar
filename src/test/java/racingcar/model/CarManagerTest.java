package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarManagerTest {
    @Test
    void 우승자_1인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(13));

        CarManager carManager = new CarManager(Arrays.asList(a, b, c));

        assertThat(carManager.findWinner()).contains("a");
    }

    @Test
    void 우승자_2인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(12));

        CarManager carManager = new CarManager(Arrays.asList(a, b, c));

        assertThat(carManager.findWinner()).contains("b", "c");
    }
}