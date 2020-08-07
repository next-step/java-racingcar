package com.hskim.nextstep.step03.utils;

import com.hskim.nextstep.step03.exception.ExceptionMessage;

import java.util.List;

public class ValidationUtils {

    private ValidationUtils() {

    }

    public static void stringLengthLimit(String target, int limit) {

        stringLengthLimit(target, limit, ExceptionMessage.DEFAULT_EXCEPTION_MESSAGE);
    }

    public static void stringLengthLimit(String target, int limit, ExceptionMessage exceptionMessage) {

        if (target.length() > limit) {

            throw new IllegalArgumentException(exceptionMessage.getExceptionMessage());
        }
    }

    public static void stringLengthLimit(List<String> list, int limit) {

        stringLengthLimit(list, limit, ExceptionMessage.DEFAULT_EXCEPTION_MESSAGE);
    }

    public static void stringLengthLimit(List<String> list, int limit, ExceptionMessage exceptionMessage) {

        list.forEach(element -> stringLengthLimit(element, limit, exceptionMessage));
    }
}
