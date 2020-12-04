package com.nextstep.racinggame.view.exceptions;

import com.nextstep.racinggame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.nextstep.racinggame.domain.CarFixtures.ONE_TEST1_CAR;
import static com.nextstep.racinggame.domain.CarFixtures.ONE_TEST2_CAR;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameWinnerOutputViewTests {
    @DisplayName("제시된 차량 목록을 우승자 목록으로 파싱할 수 있다.")
    @Test
    void parseToWinnerResultTest() {
        List<Car> cars = Arrays.asList(ONE_TEST1_CAR, ONE_TEST2_CAR);
        String expected = "test1, test2가 최종 우승했습니다.";

        assertThat(RacingGameWinnerOutputView.parseToWinnerResult(cars)).isEqualTo(expected);
    }
}
