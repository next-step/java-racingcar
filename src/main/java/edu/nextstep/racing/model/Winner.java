package edu.nextstep.racing.model;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:27
 */
public class Winner {

    private List<Car> winners;
    private int winScore;

    public Winner(List<Car> winners, int winScore) {
        this.winners = winners;
        this.winScore = winScore;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void setWinners(List<Car> winners) {
        this.winners = winners;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }
}
