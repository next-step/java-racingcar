package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Car;
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
public class WinPlayer {
    private Winner winner;

    public WinPlayer(Winner Winner) {
        this.winner = Winner;
    }

    public Winner getWinners() {
        return this.winner;
    }

    public int getWinScore() {
        return this.winner.getWinScore();
    }

    public void doWinnerCheck() {
        calculateWinScore(this.winner.getWinners());

        this.winner.setWinners(this.winner.getWinners().stream()
                .filter(car -> car.currentPosition() >= this.winner.getWinScore())
                .collect(Collectors.toList()));
    }

    private void calculateWinScore(List<Car> cars) {
        for (Car car : cars) {
            this.winner.setWinScore(NumberUtils.getMax(this.winner.getWinScore(), car.currentPosition()));
        }
    }
}
