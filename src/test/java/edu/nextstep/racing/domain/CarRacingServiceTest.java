package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
 * create date  : 2019-06-16 15:22
 */
class CarRacingServiceTest {

    private CarRacingService carRacingService;
    private Cars cars;
    private List<String> carName;

    @BeforeEach
    void setUp() {
        carName = new ArrayList<>();
        carName.add("TEST1");
        carName.add("TEST2");
        carName.add("TEST3");
        cars = new Cars(carName);
        carRacingService = new CarRacingService(cars);
    }

    @Test
    void 자동차_전진() {
        assertThat(carRacingService.starRoundGame().stream()
                .map(car -> car.currentPosition())
                .min((o1, o2) -> o1 < o2 ? o1 : o2)
                .get()
        ).isBetween(0,1);

        assertThat(carRacingService.starRoundGame().stream()
                .map(car -> car.currentPosition())
                .max((o1, o2) -> o1 > o2 ? o1 : o2)
                .get()
        ).isBetween(0,2);
    }

    @Test
    void 자동차_경주종료_자동차들_반환() {
        carRacingService.starRoundGame();
        Cars finishCars = carRacingService.finishGame();

        assertThat(finishCars.getCars().size()).isEqualTo(3);
    }
}