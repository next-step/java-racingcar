package ui;

import domain.GameRecord;
import domain.Location;
import domain.LocationRecord;

import java.util.List;

public class ResultView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String ATTEMPTS_SEPARATOR = "";
    private static final String LOCATION_INDICATOR = "=";

    private GameRecord gameRecord;

    public ResultView(GameRecord gameRecord) {
        this.gameRecord = gameRecord;
    }

    public void printResult(int numberOfAttempts) {
        printStartMessage();

        for (int time = 0; time < numberOfAttempts; time++) {
            printTimeLocation(time);
        }

        printWinners();
    }

    private void printWinners() {
        List<String> winners = gameRecord.getWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (String winner : winners) {
            stringBuilder.append(winner);
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.append(WINNER_MESSAGE);

        printMessage(stringBuilder.toString());
    }

    private void printStartMessage() {
        printMessage(START_MESSAGE);
    }

    private void printTimeLocation(int time) {
        LocationRecord locationRecord = gameRecord.getLocationRecord();
        List<Location> locations = locationRecord.getLocations();
        for (Location location : locations) {
            printMessage(makeLocationMessageForTime(location, time));
        }
        printMessage(ATTEMPTS_SEPARATOR);
    }

    private String makeLocationMessageForTime(Location location, int time) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(location.getName());
        stringBuilder.append(" : ");

        List<Integer> locations = location.getLocations();
        int locationAtTime = locations.get(time);
        for (int k = 0; k < locationAtTime; k++) {
            stringBuilder.append(LOCATION_INDICATOR);
        }

        return stringBuilder.toString();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
