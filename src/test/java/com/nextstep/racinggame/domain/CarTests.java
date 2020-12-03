package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTests {
    private final GasStation moveGasStation = new FourFuelGasStation();
    private final GasStation notMoveGasStation = new ThreeFuelGasStation();

    @DisplayName("주유할 주유소를 인자로 받아서 객체 생성 가능")
    @Test
    void createTest() {
        assertThat(new Car(moveGasStation)).isNotNull();
    }
}