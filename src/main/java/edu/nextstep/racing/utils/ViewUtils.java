package edu.nextstep.racing.utils;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:37
 */
public final class ViewUtils {

    public static void printMessage(String message) {
        assert (message == null || "".equals(message)): "Message is Null -> [" + message + "]";
        System.out.println(message);
    }
}