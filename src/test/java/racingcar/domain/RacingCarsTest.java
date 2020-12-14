package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차의 이름과 위치를 가지고 우승자를 판별하는 기능 테스트")
    void pickWinners() {
        RacingCars cars = new RacingCars(
                Arrays.asList(
                        new RacingCar(new CarName("a"), 4),
                        new RacingCar(new CarName("b"), 5),
                        new RacingCar(new CarName("c"), 5)
                )
        );
        assertThat(cars.pickWinners()).isEqualTo(
                new RacingCars(
                    Arrays.asList(
                        new RacingCar(new CarName("b"), 5),
                        new RacingCar(new CarName("c"), 5)
                    )
                )
        );
    }

}