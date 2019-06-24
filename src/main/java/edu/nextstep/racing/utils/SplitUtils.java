package edu.nextstep.racing.utils;

import java.util.Arrays;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 16:00
 */
public class SplitUtils {

    public static List<String> commaSplit(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
