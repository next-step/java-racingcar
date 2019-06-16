package edu.nextstep.raing;

import edu.nextstep.raing.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-16 15:22
 */
class CarRacingTest {

    private CarRacing race;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        race = new CarRacing(3, 5);
        cars = race.getCarList();
    }

    @Test
    void 자동차_전진() {
        cars = race.move();
        int position = cars.get(0).currentPosition();
        assertThat(position).isGreaterThan(-1);
        assertThat(position).isLessThan(6);
    }
}