package step3.car_racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car_racing.model.Cars;

import java.util.List;

class RacingTest {

    @Test
    @DisplayName("최종 우승자 찾기")
    void findWinner() {
        // given
        List<String> carNameList = List.of("123", "456");
        Cars cars = new Cars().initCars(carNameList);

        // when
        Racing racing = new Racing(5, cars);


        // then

    }
}