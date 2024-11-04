package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void generate_car() {
        car = new Car("Car");
    }

    @Test
    void move_when_movable() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Car", 1);
        car.move(() -> true);

        assertThat(car.showCurrentPosition()).isEqualTo(map);
    }

    @Test
    void stop_when_not_movable() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Car", 0);
        car.move(() -> false);

        assertThat(car.showCurrentPosition()).isEqualTo(map);
    }
}