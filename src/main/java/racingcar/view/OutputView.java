package racingcar.view;

import racingcar.collection.RaceResult;
import racingcar.collection.LapResult;

public class OutputView {
    private final static String SKID_MARK_CHARACTER = "-";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";

    private final static String WINNERS_MESSAGE = "가 최종 우승했습니다.";
    private final static String WINNER_JOINING_DELIMITER = ",";
    private final static String CAR_NAME_DELIMITER = ": ";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printRaceHistories(RaceResult result) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        result.getLabResults().forEach(this::printRaceResult);


        System.out.println(getWinnersNameString(result) + WINNERS_MESSAGE);
    }

    private String getWinnersNameString(RaceResult result) {
        return String.join(WINNER_JOINING_DELIMITER, result.getWinnerNames());
    }

    private void printRaceResult(LapResult lapResult) {
        lapResult.getCarNames().forEach(carName -> {
            stringBuilder.setLength(0);
            stringBuilder.append(carName).append(CAR_NAME_DELIMITER);
            appendSkidMark(stringBuilder, lapResult.getCarPositionResult(carName));
            System.out.println(stringBuilder);
        });

        System.out.println();
    }

    private void appendSkidMark(StringBuilder stringBuilder, Integer currentPosition) {
        for (int i = 0; i <= currentPosition; i++) {
            stringBuilder.append(SKID_MARK_CHARACTER);
        }
    }
}
