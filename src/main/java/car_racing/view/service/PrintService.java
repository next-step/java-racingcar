package car_racing.view.service;

import car_racing.domain.model.RaceResults;
import car_racing.view.model.UserInput;

import java.util.List;

public class PrintService {
    private static final String WINNER_DELIMITER = ",";

    public static void showRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRaceResult(RaceResults raceResults, UserInput userInput) {
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            System.out.println(raceResults.getRaceResultOfNthRound(i));
        }
        showRaceWinners(raceResults.getWinnersName());
    }

    private static void showRaceWinners(List<String> winnerList) {
        String winners = String.join(WINNER_DELIMITER, winnerList);
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }
}
