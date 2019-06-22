package edu.nextstep.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 19:50
 */
public class WinnerTest {

    @ParameterizedTest
    @ValueSource(strings = {"TEST1", "TEST3"})
    void 우승자_생성(String winners) {
        Car car1 = new Car("TEST1", 5);
        Car car2 = new Car("TEST2", 4);
        Car car3 = new Car("TEST3", 5);

        List<Car> candinateWinners = new ArrayList<>(Arrays.asList(car1, car2, car3));
        Winner winner = Winner.checkPosition(candinateWinners);
        assertThat(winner.getCarNames().contains(winners)).isTrue();
    }
}
