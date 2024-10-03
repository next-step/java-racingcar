package racinggame;

import racinggame.racingcar.RacingCars;

import java.util.List;
import java.util.Map;

public class ConsoleResultView implements ResultView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_MARKER = "-";
    private static final String ROUND_SEPARATOR = "";
    private static final String COLON = ":";

    @Override
    public void printRaceResults(Map<String, Integer> carsInfo) {
        carsInfo.forEach((carName, position) -> {
            String positionMarker = createPositionMarker(position);
            String message = formatRaceResultMessage(carName, positionMarker);
            printMessage(message);
        });
        printRoundSeparator();
    }

    @Override
    public void printResultMessage() {
        printMessage(EXECUTION_RESULT_MESSAGE);
    }

    private String createPositionMarker(int position) {
        return POSITION_MARKER.repeat(position);
    }

    private String formatRaceResultMessage(String carName, String positionMarker) {
        return carName + COLON + positionMarker;
    }

    private void printRoundSeparator() {
        printMessage(ROUND_SEPARATOR);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
