package javaracingcarwinner.view;

import javaracingcarwinner.controller.JavaRacingGame;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.entity.Round;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DEFAULT_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_LOCATION_DELIMITER = " : ";
    private static final String LOCATION_UNIT = "-";
    private static final String WINNER_DELIMITER = ",";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public ResultView(List<Round> rounds) {
        startMessage();
        for (Round round : rounds) {
            List<RacingCar> roundCars = round.getRoundCars();
            printRound(roundCars);
        }
        printGameResult(rounds);
    }

    private void printGameResult(List<Round> rounds) {
        Round lastRound = rounds.get(rounds.size() - 1);
        List<RacingCar> winners = JavaRacingGame.whoIsWinners(lastRound.getRoundCars());
        printWinners(winners);
    }

    private void startMessage() {
        System.out.println(DEFAULT_RESULT_MESSAGE);
    }

    private void printRound(List<RacingCar> cars) {
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

    private void printWinners(List<RacingCar> cars) {
        List<String> carNames = cars.stream().map(car -> car.name()).collect(Collectors.toList());
        String includeDelimiterWinners = String.join(WINNER_DELIMITER, carNames);
        System.out.print(includeDelimiterWinners);
        System.out.println(WINNER_MESSAGE);
    }

}
