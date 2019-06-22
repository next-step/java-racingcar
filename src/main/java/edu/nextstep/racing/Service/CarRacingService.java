package edu.nextstep.racing.Service;

import edu.nextstep.racing.domain.Car;
import edu.nextstep.racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 15:59
 */
public class CarRacingService {

    private Cars cars;
    private int round;

    public CarRacingService(List<String> carNames, int round) {
        this.cars = Cars.of(carNames);
        this.round = round;
    }

    public void raceStart() {
        for (int i = 0; i < round; i++) {
            cars.doMoveGame().stream();
        }
    }
}
