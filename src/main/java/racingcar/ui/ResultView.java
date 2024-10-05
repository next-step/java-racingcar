package racingcar.ui;

import racingcar.dto.RacingCarStateDTO;
import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    private static final String RESULT_PRINT_HEADER = "실행 결과";

    public static void printRacingResult(RacingResultDTO result) {
        printHeader();
        printWrapResults(result);
    }

    private static void printWrapResults(RacingResultDTO result) {
        for (RacingWrapResultDTO wrapResult : result.getWrapResults()) {
            printWrapResult(wrapResult);
            addBlankLine();
        }
    }

    private static void printWrapResult(RacingWrapResultDTO wrapResult) {
        List<RacingCarStateDTO> orderedCarStates = decideCarStateOrders(wrapResult);
        printCarSates(orderedCarStates);
    }

    private static List<RacingCarStateDTO> decideCarStateOrders(RacingWrapResultDTO wrapResult) {
        RacingCarStatesDTO carStates = wrapResult.getCarStates();
        List<RacingCarStateDTO> orderedCarStates = new ArrayList<>(carStates.getCarStates());
        orderedCarStates.sort(Comparator.comparingInt(RacingCarStateDTO::getCarNo));
        return orderedCarStates;
    }

    private static void printCarSates(List<RacingCarStateDTO> carStates) {
        for (RacingCarStateDTO carState : carStates) {
            printCarSate(carState);
        }
    }

    private static void printCarSate(RacingCarStateDTO carState) {
        String dashes = "-".repeat(carState.getPosition());
        System.out.println(dashes);
    }

    private static void printHeader() {
        System.out.println(RESULT_PRINT_HEADER);
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
