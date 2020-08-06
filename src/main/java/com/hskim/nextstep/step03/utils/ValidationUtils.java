package com.hskim.nextstep.step03.utils;

import com.hskim.nextstep.step03.exception.ExceptionMessage;

import java.util.List;

public class ValidationUtils {

    private ValidationUtils() {

    }

    public static void validateStringLengthLimit(String target, int limit) {

        validateStringLengthLimit(target, limit, ExceptionMessage.DEFAULT_EXCEPTION_MESSAGE);
    }

    public static void validateStringLengthLimit(String target, int limit, ExceptionMessage exceptionMessage) {

        if (target.length() > limit) {

            throw new IllegalArgumentException(exceptionMessage.getExceptionMessage());
        }
    }

    public static void validateStringLengthLimitWithList(List<String> list, int limit) {

        validateStringLengthLimitWithList(list, limit, ExceptionMessage.DEFAULT_EXCEPTION_MESSAGE);
    }

    public static void validateStringLengthLimitWithList(List<String> list, int limit, ExceptionMessage exceptionMessage) {

        list.forEach(element -> validateStringLengthLimit(element, limit, exceptionMessage));
    }
}
