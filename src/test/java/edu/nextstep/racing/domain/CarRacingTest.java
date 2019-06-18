package edu.nextstep.racing.domain;

import edu.nextstep.racing.domain.CarRacing;
import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
 * create date  : 2019-06-16 15:22
 */
class CarRacingTest {

    private CarRacing carRacing;
    private Cars cars;
    private List<String> carName;

    @BeforeEach
    void setUp() {
        carName = new ArrayList<>();
        carName.add("TEST1");
        carName.add("TEST2");
        carName.add("TEST3");
        cars = new Cars(carName);
        carRacing = new CarRacing(cars);
    }

    @Test
    void 자동차_전진() {
        assertThat(cars.getCars().get(0).currentPosition()).isEqualTo(0);
        carRacing.starRoundGame();
        assertThat(cars.getCars().get(0).currentPosition()).isBetween(0,1);
    }

    @Test
    void 자동차_대수데이터_초기화작업_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarRacing carRacing = new CarRacing(0, 10);
        });
    }

    @Test
    void 전진_시도데이터_초기화작업_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarRacing carRacing = new CarRacing(10, 0);
        });
    }
}