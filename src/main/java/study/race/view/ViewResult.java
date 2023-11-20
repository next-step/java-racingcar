package study.race.view;

import study.race.model.RaceResult;

import java.util.List;
import java.util.Map;

public class ViewResult {

    public void printRacingResult(RaceResult raceResult) {
        for (Map.Entry<String, Integer> result : raceResult.getResult().entrySet()) {
            System.out.println(result.getKey() + " : " + "-".repeat(result.getValue()));
        }
        System.out.println();
    }

    public void printRacingWinners(String winners) {
        System.out.println(winners + " won in the racing.");
    }
}
