package study.racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racinggame.domain.car.Car;
import study.racinggame.domain.car.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("position 값으로 우승자를 구한다")
    void shouldReturnWinner() {
        Car pobi = new Car("pobi", 3);
        Car jake = new Car("jake", 5);
        Car sam = new Car("sam", 5);

        Cars cars = new Cars(Arrays.asList(pobi, jake, sam));

        assertThat(cars.winners()).contains(jake, sam);
    }


}