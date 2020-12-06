package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

public class OutputView implements Output {

    @Override
    public void printHowManyUseCars() {
        printMessage(HOW_MANY_USE_CARS);
    }

    @Override
    public void printHowManyTryTimes() {
        printMessage(HOW_MANY_TRY_TIMES);
    }

    @Override
    public void printErrWhenInvalidDataTypeInput() {
        printMessage(ERR_INVALID_INPUT_DATA_TYPE);
    }

    @Override
    public void printExecutionResult() {
        printMessage(EXECUTION_RESULT);
    }

    @Override
    public void printRacingResult(final RacingHistoryDto cars) {
        // TODO print cars distance
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
