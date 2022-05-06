package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnersTest {

    @DisplayName("우승 자동차 확인")
    @Test
    void findWinners() {
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("car1", 1));
        racingCarList.add(new RacingCar("car2", 2));
        racingCarList.add(new RacingCar("car3", 3));
        RacingCars racingCars = new RacingCars(racingCarList);

        RacingWinners winners = RacingWinners.findWinners(racingCars);
        assertThat(winners.getWinners()).contains(new RacingCar("car3", new RacingPosition(3)));
    }
}
