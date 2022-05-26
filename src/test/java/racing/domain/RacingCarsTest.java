package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @DisplayName("우승자를 찾는다.")
    @Test
    void findWinners() {
        final List<Car> cars = new ArrayList<>();
        cars.add(new Car("solar", new Location(3)));
        cars.add(new Car("kuku", new Location(4)));
        cars.add(new Car("cola", new Location(1)));
        final RacingCars racingCars = RacingCars.of(cars);

        final List<Car> winners = racingCars.findWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).contains(new Car("kuku", new Location(4)));
    }
}
