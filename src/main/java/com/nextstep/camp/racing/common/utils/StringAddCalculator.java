package com.nextstep.camp.racing.common.utils;

import com.nextstep.camp.racing.common.vo.*;
import com.nextstep.camp.racing.domain.exception.UtilInstantiationException;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new UtilInstantiationException();
    }

    public static int splitAndSum(String value) {
        SplitTarget target = SplitTarget.of(value);
        SplitStrings splitStrings =  target.split();
        PositiveIntegers positiveIntegers = splitStrings.toIntegers();
        return positiveIntegers.sum();
    }
}
