package racingcar.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class RacingCarWinnerSelectorTest {

    @Test
    @DisplayName("가장 높은 Position 값을 가진 자동차로 우승자 선별하는지 검증")
    void selectWinners() {
        RacingCar racingCar1 = new RacingCar("test1", 0);
        RacingCar racingCar2 = new RacingCar("test2", 1);
        RacingCar racingCar3 = new RacingCar("test3", 2);
        RacingCar racingCar4 = new RacingCar("test4", 3);
        RacingCar racingCar5 = new RacingCar("test5", 3);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2, racingCar3, racingCar4, racingCar5));
        RacingCars winners = new RacingCars(List.of(racingCar4, racingCar5));
        then(RacingCarWinnerSelector.selectWinners(racingCars)).isEqualTo(winners);
    }
}
