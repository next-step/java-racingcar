package ui;

import java.util.List;

public class ResultView {
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String NAME_LOCATION_DELIMITER = " : ";
    private static final String LOCATION_MARKER = "-";
    private static final String WINNER_DELIMITER = ", ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCurrentLocation(String name, int location) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(NAME_LOCATION_DELIMITER);
        for (int i = 0; i < location; i++) {
            stringBuilder.append(LOCATION_MARKER);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String winner : winners) {
            stringBuilder.append(winner);
            stringBuilder.append(WINNER_DELIMITER);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(WINNER_MESSAGE);
        System.out.println(stringBuilder.toString());
    }
}
