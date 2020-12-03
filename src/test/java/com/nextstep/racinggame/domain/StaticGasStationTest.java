package com.nextstep.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticGasStationTest {
    @DisplayName("테스트를 위해 무조건 값이 5인 연료를 생산한다.")
    @Test
    void refuelTest() {
        StaticGasStation staticGasStation = new StaticGasStation();

        assertThat(staticGasStation.refuel()).isEqualTo(new Fuel(5));
    }
}
