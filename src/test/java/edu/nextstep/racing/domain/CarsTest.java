package edu.nextstep.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 15:26
 */
class CarsTest {
    private List<String> carNames;
    private List<Car> carList;

    @BeforeEach
    void 사전설정() {
        carNames = new ArrayList<>();
        carNames.add("TEST1");
        carNames.add("TEST2");

        carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    @Test
    void 자동차들의_경기결과() {
        Cars cars = new Cars(carList);
        cars = cars.doMoveGame();

        List<Integer> carPositionList = cars.stream()
                .distinct()
                .map(car -> car.getCarPosition())
                .collect(Collectors.toList());

        int maxPosition = carPositionList.stream()
                .reduce((integer1, integer2) -> Math.max(integer1, integer2))
                .orElse(0);

        assertThat(maxPosition).isBetween(0, 1);
    }
}