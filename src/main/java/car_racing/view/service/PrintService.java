package car_racing.view.service;

import car_racing.domain.model.RaceResults;
import car_racing.view.model.UserInput;

import java.util.List;

public class PrintService {
    public static void showRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRaceResult(RaceResults raceResults, UserInput userInput) {
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            showEachRound(raceResults.getRaceResultOfNthRound(i));
            System.out.println();
        }
    }

    private static void showEachRound(List<String> roundResults) {
        for (String roundResult: roundResults) {
            System.out.println(roundResult);
        }
    }
}
