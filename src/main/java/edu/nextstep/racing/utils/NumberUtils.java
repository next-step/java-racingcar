package edu.nextstep.racing.utils;

import java.util.Random;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:25
 */
public final class NumberUtils {

    private static final int MOVE_MAX_VALUE = 9;

    public static int getMax(int target, int source) {
        return target > source ? target : source;
    }

    public static int getRandomNumber() {
        Random generator = new Random();
        return generator.nextInt(MOVE_MAX_VALUE);
    }
}
