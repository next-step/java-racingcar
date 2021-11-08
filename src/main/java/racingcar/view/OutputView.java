package racingcar.view;

import racingcar.Car;
import racingcar.collection.RaceResult;
import racingcar.collection.Race;

import java.util.stream.Collectors;

public class OutputView {
    private final static String SKID_MARK_CHARACTER = "-";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";

    private final static String WINNERS_MESSAGE = "가 최종 우승했습니다.";

    public void printRaceHistories(RaceResult result) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        result.getHistories().forEach(this::printRaceResult);


        System.out.println(getWinnersNameString(result) + WINNERS_MESSAGE);
    }

    private String getWinnersNameString(RaceResult result) {
        return result.getWinners()
                .getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
    private void printRaceResult(Race race) {
        StringBuilder stringBuilder = new StringBuilder();
        race.getCars().forEach(car -> {
            stringBuilder.append(car.getName()).append(": ");
            appendSkidMark(stringBuilder, race.getCarPositionResult(car));
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
