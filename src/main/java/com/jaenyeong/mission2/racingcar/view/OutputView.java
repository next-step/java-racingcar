package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.domain.Car;
import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

import java.util.StringJoiner;

public class OutputView implements Output {

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
    public void printTextExecutionResult() {
        printMessage(EMPTY);
        printMessage(EXECUTION_RESULT);
    }

    @Override
    public void printAllRacingHistoriesResult(final RacingHistoryDto historyDto) {
        for (int turn = START_TURN; turn <= historyDto.getMaxTurn(); turn++) {
            printCarByTurn(historyDto, turn);
            printMessage(EMPTY);
        }
    }

    private void printCarByTurn(final RacingHistoryDto history, final int turn) {
        for (Car car : history.getCarList()) {
            printMessage(convertFormatPrintRacingHistory(car.getName(), car.getDistanceByTurn(turn)));
        }
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

    @Override
    public void printWinner(final RacingHistoryDto historyDto) {
        final StringJoiner sj = new StringJoiner(", ");
        historyDto.getWinners().forEach(sj::add);
        printMessage(sj.toString() + FINALLY_WINNER);
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
