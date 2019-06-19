package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Cars;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 23:33
 */
public class CarRacingService {

    private Cars player;

    /*
    CarRacing 생성자
    @parameter carCount, moveCount
     */
    public CarRacingService(Cars player) {
        this.player = player;
    }

    public Cars startRoundGame() {
        return this.player.goForward();
    }

    public Cars finishGame() {
        return this.player;
    }
}