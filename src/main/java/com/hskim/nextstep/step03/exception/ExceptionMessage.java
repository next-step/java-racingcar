package com.hskim.nextstep.step03.exception;

import com.hskim.nextstep.step03.model.RacingCar;

/**
 * Created by hs kim on 2020/08/05
 */
public enum ExceptionMessage {

    DEFAULT_EXCEPTION_MESSAGE("Exception occurred!"),
    EXCEED_CAR_NAME_LENGTH("Car name length can't exceed " + RacingCar.CAR_NAME_LIMIT + "."),
    FAIL_TO_FIND_WINNER("Fail to find winner. Check state.");

    ExceptionMessage(String exceptionMessage) {

        this.exceptionMessage = exceptionMessage;
    }

    private String exceptionMessage;

    public String getExceptionMessage() {

        return exceptionMessage;
    }
}
