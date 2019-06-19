package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.model.Winner;
import edu.nextstep.racing.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:22
 */
public class WinPlayerService {
    private Winner winner;

    public WinPlayerService(Winner Winner) {
        this.winner = Winner;
    }

    public Winner getWinners() {
        return this.winner;
    }

    public void doWinnerCheck() {
        calculateWinScore(this.winner.getWinners());
        calculateWinPlayer(this.winner.getWinners());
    }

    private void calculateWinScore(Cars cars) {
        int winnerScore = 0;

        for (Car car : cars.getCars()) {
            winnerScore = NumberUtils.getMax(this.winner.getWinScore(), car.currentPosition());
        }
        this.winner.setWinScore(winnerScore);
    }

    private Cars calculateWinPlayer(Cars cars) {
        List<Car> tempCars = this.winner.getWinners().getCars().stream()
                .filter(car -> car.currentPosition() >= this.winner.getWinScore())
                .collect(Collectors.toList());

        cars.setCars(tempCars);
        return cars;
    }
}
