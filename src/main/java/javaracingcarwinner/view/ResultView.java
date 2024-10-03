package javaracingcarwinner.view;

import javaracingcarwinner.entity.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DEFAULT_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_LOCATION_DELIMITER = " : ";
    private static final String LOCATION_UNIT = "-";
    private static final String WINNER_DELIMITER = ",";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public ResultView() {
    }

    public void startMessage() {
        System.out.println(DEFAULT_RESULT_MESSAGE);
    }

    public void printRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            print(car);
        }
        System.out.println();
    }

    private void print(RacingCar car) {
        System.out.print(car.name());
        System.out.print(NAME_LOCATION_DELIMITER);
        printLocation(car.location());
    }

    private void printLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print(LOCATION_UNIT);
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> cars) {
        List<String> carNames = cars.stream().map(car -> car.name()).collect(Collectors.toList());
        String includeDelimiterWinners = String.join(WINNER_DELIMITER, carNames);
        System.out.print(includeDelimiterWinners);
        System.out.println(WINNER_MESSAGE);
    }
}
