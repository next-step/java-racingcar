package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("2대의 자동차를 각각 1,2만큼 움직일 수 있다.")
    @Test
    void moveCars() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();
        Cars cars = new Cars(List.of(car1, car2));

        // when
        cars.move(List.of(1, 2));

        // then
        assertThat(cars.getCars())
                .extracting(Car::getDistance)
                .containsExactly(1, 2);

    }
}