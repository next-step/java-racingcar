package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Race;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:37
 */
public class RoundGameService {

    private Race race;
    private int currentTime;

    private static final int INIT_CURRENT_TIME = 0;

    public RoundGameService(Race race) {
        this.race = race;
        this.currentTime = INIT_CURRENT_TIME;
    }

    public int getGameTime() {
        return race.getGameTime();
    }

    public void doRace() {
        this.currentTime++;
    }

    public int getRemainTime() {
        return getGameTime() - currentTime;
    }
}