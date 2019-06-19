package edu.nextstep.racing.model;

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

    private Cars winners;
    private int winScore;

    public Winner(Cars winners, int winScore) {
        this.winners = winners;
        this.winScore = winScore;
    }

    public Cars getWinners() {
        return winners;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }
}
