package edu.nextstep.racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        CarName name1 = new CarName("TEST1");
        CarName name2 = new CarName("TEST2");
        CarName name3 = new CarName("TEST3");

        Position position1 = new Position(5);
        Position position2 = new Position(4);
        Position position3 = new Position(5);

        Car car1 = new Car(name1, position1);
        Car car2 = new Car(name2, position2);
        Car car3 = new Car(name3, position3);

        List<Car> candinateWinners = new ArrayList<>(Arrays.asList(car1, car2, car3));
        Cars candinateCars = new Cars(candinateWinners);

        Winner winner = Winner.checkPosition(candinateCars);
        assertThat(winner.getCarNames().getNames().contains(winners)).isTrue();
    }
}
