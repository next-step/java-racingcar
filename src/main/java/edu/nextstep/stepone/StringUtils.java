package edu.nextstep.stepone;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-16 16:43
 */
public class StringUtils {
    /*
    문자 -> 숫자 변환
     */
    public int convertInt(String letter) {
        try {
            return Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
