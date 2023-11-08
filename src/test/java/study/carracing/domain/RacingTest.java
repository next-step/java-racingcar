package study.carracing.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    @DisplayName("문자열의 콤마(,)를 기준으로 split한 배열의 length만큼 자동차가 생성된다.")
    void split_car_name() {
        RacingCars racingCars = new RacingCars();

        racingCars.addCar("car1,car2,car3".split(","));

        assertThat(racingCars.getCars().size()).isEqualTo(3);
    }
}