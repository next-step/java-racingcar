package com.nextstep.racinggame.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nextstep.racinggame.domain.CarsFixtures.ALL_ONE_MOVED_CARS;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultDrawerTests {
    @DisplayName("사용자에게 보여줄 경주 결과를 만들 수 있다.")
    @Test
    void drawTest() {
        String expected = "-\n-\n-\n";

        assertThat(RacingGameResultDrawer.drawGameResult(ALL_ONE_MOVED_CARS)).isEqualTo(expected);
    }
}