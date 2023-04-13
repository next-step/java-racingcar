package racingcar;

public class OutputView {

    public static final String POSITION_INDICATOR = "-";
    public static final String NEW_LINE = "\n";

    public static void announceRaceResults(RaceResults raceResults) {
        printResult(raceResults.raceResultsString());
    }

    private static void printResult(String result) {
        System.out.print("[경기 결과]\n" + result);
    }

}
