package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    Cars cars;

    @BeforeEach
    void createCars() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("Kim");
        Car car2 = new Car("Lee");
        Car car3 = new Car("Cha");
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        cars = new Cars(carList);
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