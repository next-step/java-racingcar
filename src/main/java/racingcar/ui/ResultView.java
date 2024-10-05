package racingcar.ui;

import racingcar.dto.RacingCarStateDTO;
import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;

import java.util.Arrays;
import java.util.Comparator;

public class ResultView {
    private static final String RESULT_PRINT_HEADER = "실행 결과";

    public static void printRacingResult(RacingResultDTO result) {
        printHeader();
        printWrapResults(result);
    }

    private static void printWrapResults(RacingResultDTO result) {
        for (RacingWrapResultDTO wrapResult : result.wrapResults) {
            printWrapResult(wrapResult);
            addBlankLine();
        }
    }

    private static void printWrapResult(RacingWrapResultDTO wrapResult) {
        RacingCarStateDTO[] orderedCarStates = decideCarStateOrders(wrapResult);
        printCarSates(orderedCarStates);
    }

    private static RacingCarStateDTO[] decideCarStateOrders(RacingWrapResultDTO wrapResult) {
        RacingCarStatesDTO carStates = wrapResult.carStates;
        Arrays.sort(carStates.carStates, Comparator.comparingInt(carState -> carState.carNo));
        return carStates.carStates;
    }

    private static void printCarSates(RacingCarStateDTO[] carStates) {
        for (RacingCarStateDTO carState : carStates) {
            printCarSate(carState);
        }
    }

    private static void printCarSate(RacingCarStateDTO carState) {
        String dashes = "-".repeat(carState.position);
        System.out.println(dashes);
    }

    private static void printHeader() {
        System.out.println(RESULT_PRINT_HEADER);
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
