package car_racing.domain.model;

import car_racing.domain.strategy.AlwaysMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CarsTest {
    @Test
    @DisplayName("moveAll 호출시 모든 차량이 1만큼 움직이는지")
    void shouldMoveAll() {
        Cars cars = new Cars(List.of("", "", ""), new AlwaysMovingStrategy());
        cars.moveAll();

        cars.forEach(car -> assertThat(car.getDistance()).isEqualTo(1));
    }
}
