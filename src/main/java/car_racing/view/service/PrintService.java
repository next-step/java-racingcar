package car_racing.view.service;

import car_racing.domain.model.Car;
import car_racing.domain.model.RaceResults;
import car_racing.view.model.UserInput;

import java.util.List;
import java.util.stream.Collectors;

public class PrintService {
    private static final String WINNER_DELIMITER = ",";

    public static void showRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRaceResult(RaceResults raceResults, UserInput userInput) {
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            showEachRound(raceResults.getRaceResultOfNthRound(i));
            System.out.println();
        }
        showRaceWinners(raceResults.getWinners());
    }

    private static void showEachRound(List<String> roundResults) {
        for (String roundResult: roundResults) {
            System.out.println(roundResult);
        }
    }

    private static void showRaceWinners(List<Car> winnerList) {
        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.printf("%s가 최종 우승했습니다.", winners);
    }
}
