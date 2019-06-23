package edu.nextstep.racing.service;

import edu.nextstep.racing.domain.Cars;
import edu.nextstep.racing.domain.Winner;

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
    private List<Cars> movingHistory = new ArrayList<>();

    public CarRacingService(List<String> carNames, int round) {
        this.cars = Cars.of(carNames);
        this.round = round;
    }

    public List<Cars> raceStart() {
        for (int i = 0; i < round; i++) {
            saveStepStatus();
        }
        return movingHistory;
    }

    public Winner extractWinners() {
        return Winner.checkPosition(this.cars.asList());
    }

    private void saveStepStatus() {
        this.movingHistory.add(cars.doMoveGame());
    }
}