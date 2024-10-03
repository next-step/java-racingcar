package racingcar.ui;

import racingcar.dto.RacingCarStateDTO;
import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;

public class ResultView {
    private static String RESULT_PRINT_HEADER = "실행 결과";

    public static void printRacingResult(RacingResultDTO result) {
        printHeader();
        printWrapResults(result);
    }

    private static void printWrapResults(RacingResultDTO result) {
        for (RacingWrapResultDTO wrapResult: result.wrapResults) {
            RacingCarStatesDTO carStates = wrapResult.carStates;
            printCarSates(carStates);
            addBlankLine();
        }
    }

    private static void printCarSates(RacingCarStatesDTO carStates) {
        for(RacingCarStateDTO carState : carStates.catStates) {
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
