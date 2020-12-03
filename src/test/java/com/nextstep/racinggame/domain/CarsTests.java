package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTests {
    @DisplayName("생성하고 싶은 Car의 수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int carDemand = 3;
        Cars cars = Cars.of(carDemand);

        assertThat(cars).isNotNull();
        assertThat(cars.size()).isEqualTo(carDemand);
    }
}