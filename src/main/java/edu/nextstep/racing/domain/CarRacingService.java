package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.model.Race;

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
    private Race race;

    public CarRacingService(Cars player, Race race) {
        this.player = player;
        this.race = race;
    }

    public Cars startRoundGame() {
        return this.player.goForward();
    }

    public Cars finishGame() {
        return this.player;
    }

    public int getGameTime() {
        return race.getGameTime();
    }
}