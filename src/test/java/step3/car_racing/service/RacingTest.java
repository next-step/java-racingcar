package step3.car_racing.service;

import org.junit.jupiter.api.Test;
import step3.car_racing.model.Cars;

class RacingTest {

    @Test
    void race() {

        // given
        int carSize = 5;
        Cars cars = new Cars(carSize);

        // when
        Racing racing = new Racing(cars);

        // then

    }

}