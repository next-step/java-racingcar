package car_racing.domain.model;

import car_racing.domain.strategy.AlwaysMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    @DisplayName("moveAll 호출시 모든 차량이 1만큼 움직이는지")
    void shouldMoveAll() {
        Cars cars = new Cars(3, new AlwaysMovingStrategy());
        cars.moveAll();

        cars.forEach(car -> assertEquals(1, car.getDistance()));
    }
}
