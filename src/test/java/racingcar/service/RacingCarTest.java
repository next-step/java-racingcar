package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 경주 3대 1회")
    void racing() {
        String cars = "pobi,crong,honux";

        RacingCar racingCar = new RacingCar(cars);

        racingCar.start();

        int[] distanceOfCars = racingCar.getStatusOfCars();

        assertThat(distanceOfCars).satisfiesAnyOf(
                actual -> assertThat(distanceOfCars).contains(0),
                actual -> assertThat(distanceOfCars).contains(1)
        );
    }

}
