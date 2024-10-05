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
        printWinners(result);
    }

    private static void printHeader() {
        System.out.println(RESULT_PRINT_HEADER);
    }

    private static void printWrapResults(RacingResultDTO result) {
        for (RacingWrapResultDTO wrapResult : result.getWrapResults().getWrapResults()) {
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
        String carName = carState.getCarName();
        String dashes = "-".repeat(carState.getPosition() + 1);
        System.out.printf("%s : %s%n", carName, dashes);
    }

    private static void printWinners(RacingResultDTO result) {
        String winnerNames = String.join(", ", result.getWinners().getWinners());
        System.out.printf("%s가 최종 우승했습니다.%n", winnerNames);
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
