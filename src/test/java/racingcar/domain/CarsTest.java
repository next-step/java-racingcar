package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    void findMaxPosition() {
        Cars cars = getCars();

        Car maxPositionCar = cars.findMaxPositionCar();

        assertThat(maxPositionCar).isEqualTo(new Car("max", 2));
    }

    @Test
    void findWinners() {
        Cars cars = getCars();

        Car winner = new Car("win", 2);
        Cars winners = cars.findWinners(winner);

        assertThat(winners.toStringNames()).contains("carB");
    }

    @Test
    void toStringNames() {
        Cars cars = getCars();

        assertThat(cars.toStringNames()).contains("carA,carB");
    }

    @Test
    void testToString() {
        Cars cars = getCars();

        assertThat(cars.toString())
                .contains("carA:")
                .contains("carB:");
    }

    private Cars getCars() {
        Car carA = new Car("carA", 1);
        Car carB = new Car("carB", 2);
        return new Cars(List.of(carA, carB));
    }
}