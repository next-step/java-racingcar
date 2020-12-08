package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

import java.util.Map;

public class OutputView implements Output {

    public static final String DASH = "-";

    @Override
    public void printHowManyUseCars() {
        printMessage(HOW_MANY_USE_CARS);
    }

    @Override
    public void printHowManyTryTimes() {
        printMessage(HOW_MANY_TRY_TIMES);
    }

    @Override
    public void printNamesOfTheCarsToBeRaced() {
        printMessage(NAMES_OF_CARS_TO_BE_RACED);
    }

    @Override
    public void printErrWhenInvalidDataTypeInput() {
        printMessage(ERR_INVALID_INPUT_DATA_TYPE);
    }

    @Override
    public void printExecutionResult() {
        printMessage("");
        printMessage(EXECUTION_RESULT);
    }

    @Override
    public void printAllRacingHistoriesResult(final RacingHistoryDto historyDto) {
        final Map<Integer, Map<String, Integer>> history = historyDto.parsePrintFormat();

        history.forEach((turn, car) -> {
                car.forEach((carName, dist) -> printMessage(convertFormatPrintRacingHistory(carName, dist)));
                printMessage("");
            }
        );
    }

    private String convertFormatPrintRacingHistory(final String carName, final int distance) {
        final StringBuilder sb = new StringBuilder();
        sb.append(carName)
            .append(" : ");

        for (int i = 0; i < distance; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
