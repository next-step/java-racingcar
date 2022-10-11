package racinggame.domain;

import org.junit.jupiter.api.Test;
import racinggame.domain.embeded.CarDistance;
import racinggame.domain.embeded.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    void 우승자_찾기() {
        List<Car> cars = List.of(
                new Car("car1", new CarDistance(4)),
                new Car("car2", new CarDistance(0)),
                new Car("car3", new CarDistance(0)));

        RacingCars racingCars = new RacingCars(cars);
        racingCars.move();
        List<Car> winners = racingCars.winners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getCarName()).isEqualTo(new CarName("car1"));
    }
}