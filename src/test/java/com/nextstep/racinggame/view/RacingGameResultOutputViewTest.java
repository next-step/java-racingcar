package com.nextstep.racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nextstep.racinggame.domain.CarsFixtures.ALL_ONE_MOVED_TEST123_CARS;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultOutputViewTest {
    @DisplayName("사용자에게 보여줄 경주 결과를 만들 수 있다.")
    @Test
    void drawTest() {
        String expected = "test1 : -\ntest2 : -\ntest3 : -\n";

        assertThat(RacingGameResultOutputView.drawGameProgress(ALL_ONE_MOVED_TEST123_CARS)).isEqualTo(expected);
    }
}
