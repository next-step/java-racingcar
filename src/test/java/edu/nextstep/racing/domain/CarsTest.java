package edu.nextstep.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<Car> finishGameCars = new ArrayList<>(carList);
        Cars cars = new Cars(finishGameCars);
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

    @Test
    void 자동차들_위치_가져오기() {
        Car car1 = new Car(new CarName("TEST1"), new Position(3));
        Car car2 = new Car(new CarName("TEST2"), new Position(3));
        List<Car> positionCars = new ArrayList<>(Arrays.asList(car1, car2));

        Cars cars = new Cars(positionCars);
        assertThat(cars.getCarsPosition().get(0)).isEqualTo(3);
    }

    @Test
    void 자동차_리스트_사이즈() {
        Car car1 = new Car(new CarName("TEST1"), new Position(3));
        Car car2 = new Car(new CarName("TEST2"), new Position(3));
        List<Car> carsList = new ArrayList<>(Arrays.asList(car1, car2));

        Cars cars = new Cars(carsList);
        assertThat(cars.size()).isEqualTo(2);
    }
}