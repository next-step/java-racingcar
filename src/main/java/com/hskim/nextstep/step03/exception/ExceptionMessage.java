package com.hskim.nextstep.step03.exception;

import com.hskim.nextstep.step03.racing.RacingCarSimulator;

/**
 * Created by hs kim on 2020/08/05
 */
public enum ExceptionMessage {

    EXCEED_CAR_NAME_LENGTH("Car name length can't exceed " + RacingCarSimulator.CAR_NAME_LIMIT + ".");

    ExceptionMessage(String exceptionMessage) {

        this.exceptionMessage = exceptionMessage;
    }

    private String exceptionMessage;

    public String getExceptionMessage() {

        return exceptionMessage;
    }
}
