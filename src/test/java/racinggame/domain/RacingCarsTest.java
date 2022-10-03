package racinggame.domain;

import org.junit.jupiter.api.Test;
import racinggame.dto.WinCarsDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    void 우승자_찾기() {
        List<Car> cars = List.of(
                new Car("car1", randomNumber -> true),
                new Car("car2", randomNumber -> false),
                new Car("car3", randomNumber -> false));

        RacingCars racingCars = new RacingCars(cars);
        racingCars.move();
        List<WinCarsDTO> winners = racingCars.winners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getCarName()).isEqualTo(new CarName("car1"));
    }
}