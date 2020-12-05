package com.nextstep.racinggame.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nextstep.racinggame.domain.CarsFixtures.ALL_NOT_MOVED_TEST123_CARS;
import static com.nextstep.racinggame.domain.CarsFixtures.ALL_ONE_MOVED_TEST123_CARS;
import static com.nextstep.racinggame.domain.GasStationFixtures.FOUR_FUEL_GAS_STATION;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @DisplayName("Cars 일급컬렉션을 주입받고 게임을 진행한 뒤 진행이 완료된 Cars 일급컬렉션을 반환한다.")
    @Test
    void raceTest() {
        assertThat(RacingGame.race(ALL_NOT_MOVED_TEST123_CARS, FOUR_FUEL_GAS_STATION)).isEqualTo(ALL_ONE_MOVED_TEST123_CARS);
    }
}
