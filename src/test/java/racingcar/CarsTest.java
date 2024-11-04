package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @BeforeEach
    void createCars() {
        cars = new Cars("Kim,Lee,Cha");
    }

    @Test
    void moveCars_when_movable() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kim", 1);
        map.put("Lee", 1);
        map.put("Cha", 1);
        cars.moveCarsByStrategy(() -> true);

        assertThat(cars.showCarsPositions()).isEqualTo(map);
    }

    @Test
    void moveCars_when_not_movable() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kim", 0);
        map.put("Lee", 0);
        map.put("Cha", 0);
        cars.moveCarsByStrategy(() -> false);

        assertThat(cars.showCarsPositions()).isEqualTo(map);
    }
}