package edu.nextstep.racing.utils;

import java.util.Objects;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 20:38
 */
public final class ValidationUtils {

    public static void checkObject(Object obj) {
        checkEmpty(obj);
        checkNull(obj);
    }

    public static void checkNull(Object obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("Object is NULL" + obj);
        }
    }

    public static void checkEmpty(Object obj) {
        if ("".equals(obj)) {
            throw new IllegalArgumentException("Object is Empty" + obj);
        }
    }

    public static void checkMinValue(int minValue, int originValue) {
        if (minValue >= originValue) {
            throw new IllegalArgumentException(minValue + "보다 " + originValue + " 가 더 작습니다.");
        }
    }
}