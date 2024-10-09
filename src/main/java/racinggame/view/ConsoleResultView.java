package racinggame.view;

import java.util.List;
import java.util.Map;

public class ConsoleResultView implements ResultView {
    private static final String EXECUTION_ANNOUNCEMENT_MESSAGE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_SUFFIX = "가 최종 우승했습니다.";

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
    public void printExecutionAnnouncementMessage() {
        printMessage(EXECUTION_ANNOUNCEMENT_MESSAGE);
    }

    @Override
    public void printWinners(List<String> winners) {
        String winnersMessage = formatWinnersMessage(winners);
        printMessage(winnersMessage);
    }

    private String formatWinnersMessage(List<String> winners) {
        String winnersNames = joinNames(winners);
        return winnersNames + WINNER_ANNOUNCEMENT_SUFFIX;
    }

    private String joinNames(List<String> names) {
        return String.join(", ", names);
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
