package com.jaenyeong.mission2.racingcar.view;

import com.jaenyeong.mission2.racingcar.domain.Car;
import com.jaenyeong.mission2.racingcar.dto.RacingHistoryDto;

import java.util.StringJoiner;

import static com.jaenyeong.mission2.racingcar.util.Parser.parseToPrintFormatFromRacingHistory;

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
            printMessage(parseToPrintFormatFromRacingHistory(car.getName(), car.getDistanceByTurn(turn)));
        }
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
