package edu.nextstep.racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:12
 */
class CarsTest {

    private List<Car> car;
    private List<Car> exceptionCarName;

    @BeforeEach
    void 사전설정() {
        Car car1 = new Car("TEST1");
        Car car2 = new Car("TEST2");
        Car car3 = new Car("TEST3");

        car = new ArrayList<>();
        car.add(car1);
        car.add(car2);
        car.add(car3);

        Car exceptionCar1 = new Car("EXCEP1");
        Car exceptionCar2 = new Car("");
        Car exceptionCar3 = new Car("EXCEP3");

        exceptionCarName = new ArrayList<>();
        exceptionCarName.add(exceptionCar1);
        exceptionCarName.add(exceptionCar2);
        exceptionCarName.add(exceptionCar3);
    }

    @Test
    void 자동차그룹_객체_생성_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars cars = new Cars(exceptionCarName);
        });
    }

    @Test
    void 자동차그룹_대수() {

        List<Car> carTest = new ArrayList<>();
        carTest.add(new Car("TEST1"));
        carTest.add(new Car("TEST2"));
        carTest.add(new Car("TEST3"));

        Cars cars = new Cars(carTest);

        assertThat(cars.getNumberOfCars()).isEqualTo(3);
    }

}