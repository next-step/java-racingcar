package racingcar.view;

import racingcar.collection.RaceHistories;
import racingcar.collection.RaceResult;

public class OutputView {
    private final static String SKID_MARK_CHARACTER = "-";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printRaceHistories(RaceHistories histories) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        histories.getHistories().forEach(this::printRaceResult);
    }

    private void printRaceResult(RaceResult raceResult) {
        StringBuilder stringBuilder = new StringBuilder();
        raceResult.getCars().forEach(car -> {
            appendSkidMark(stringBuilder, raceResult.getCarPositionResult(car));
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        });
        System.out.println();
    }

    private void appendSkidMark(StringBuilder stringBuilder, Integer currentPosition) {
        for (int i = 0; i <= currentPosition; i++) {
            stringBuilder.append(SKID_MARK_CHARACTER);
        }
    }
}
