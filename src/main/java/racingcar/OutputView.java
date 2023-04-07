package racingcar;

import java.util.List;

public class OutputView {

    public static final String POSITION_INDICATOR = "-";
    public static final String NEW_LINE = "\n";

    public static void endRace() {
        printResult(aggregateRacingResults(Racing.raceResults));
    }

    private static void printResult(String result) {
        System.out.print("[경기 결과]\n" + result);
    }

    private static String aggregateRacingResults(List<List<Integer>> results) {
        String result = "";
        for (int race = 0; race < results.size(); race++) {
            result += aggregateRacing(results.get(race));
        }
        return result;
    }

    private static String aggregateRacing(List<Integer> raceResult) {
        String result = "";
        for (int car = 0; car < raceResult.size(); car++) {
            result += indicateCarPosition(raceResult.get(car));
        }
        result += NEW_LINE;
        return result;
    }

    private static String indicateCarPosition(int carPosition) {
        String result = "";
        for (int p = 0 ; p < carPosition; p++) {
            result += POSITION_INDICATOR;
        }
        result += NEW_LINE;
        return result;
    }

}
