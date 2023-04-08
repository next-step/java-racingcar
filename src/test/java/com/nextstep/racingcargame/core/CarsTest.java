package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("사용자 입력한 값에 따라 자동차 객체가 생성된다")
    void createNumberOfCarsTest() {
        ClientInput clientInput = new ClientInput(4, 5);
        Cars cars = clientInput.createCarsByUserCarNumberInput();
        assertThat(cars.carSize()).isEqualTo(4);
    }


}