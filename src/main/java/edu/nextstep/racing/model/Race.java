package edu.nextstep.racing.model;

import edu.nextstep.racing.utils.ValidationUtils;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:33
 */
public class Race {
    private int time;
    private static final int MIN_VALUE = 0;

    public Race(int time) {
        ValidationUtils.checkMinValue(MIN_VALUE, time);
        this.time = time;
    }

    public int getGameTime() {
        return this.time;
    }
}
