package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGasStationTest {
    @DisplayName("주유를 하고 연료를 받을 수 있다.")
    @Test
    void refuelTest() {
        RandomGasStation randomGasStation = new RandomGasStation();

        assertThat(randomGasStation.refuel()).isInstanceOf(Fuel.class);
    }
}
