package edu.nextstep.racingcar.car;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 경주 참여 Cars 일급컬렉션 생성 test")
    void createCarListTest() {
        //given
        int carNum = 3;

        // when
        Cars racingCars = Cars.createCarList(3);

        // then
        assertThat(racingCars.getCar(0) instanceof RacingCar).isTrue();
        assertThat(racingCars.size()).isEqualTo(carNum);
    }


}