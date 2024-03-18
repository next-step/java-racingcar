package step3_racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3_racing_car.domain.RacingCar;
import step3_racing_car.domain.RacingCars;
import step3_racing_car.domain.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승 경주차 확인한다.")
    void findWinner() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("자동차1", 3));
        cars.add(new RacingCar("자동차2", 4));
        cars.add(new RacingCar("자동차3", 5));
        RacingCars racingCars = new RacingCars(cars);
        Winners winners = new Winners(racingCars);

        assertThat(winners.findWinners())
                .usingRecursiveComparison()
                .isEqualTo(List.of(("자동차3")));
    }
}
