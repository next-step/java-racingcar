package racingCar.domain;

import org.junit.jupiter.api.Test;
import racingCar.domain.car.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void findWinners() {
        RacingCar car1 = new RacingCar("Frodo", 2);
        RacingCar car2 = new RacingCar("Tube", 2);
        RacingCar car3 = new RacingCar("Con", 1);
        List<RacingCar> racingCarList = Arrays.asList(car1, car2, car3);

        List<RacingCar> winnerList = Winners.findWinners(racingCarList);

        assertThat(winnerList).hasSize(2).hasSameElementsAs(Arrays.asList(car1, car2));
    }
}
