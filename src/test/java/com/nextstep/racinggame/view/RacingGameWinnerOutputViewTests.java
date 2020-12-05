package com.nextstep.racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nextstep.racinggame.domain.CarsFixtures.TEST1_TEST2_WINNING_CARS;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameWinnerOutputViewTests {
    @DisplayName("제시된 차량 목록을 우승자 목록으로 파싱할 수 있다.")
    @Test
    void parseToWinnerResultTest() {
        String expected = "test1, test2가 최종 우승했습니다.";

        assertThat(RacingGameWinnerOutputView.parseToWinnerResult(TEST1_TEST2_WINNING_CARS)).isEqualTo(expected);
    }
}
