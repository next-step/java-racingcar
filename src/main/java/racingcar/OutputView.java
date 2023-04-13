package racingcar;

import static racingcar.RaceWinner.raceWinner;

import java.util.List;

public class OutputView {

    public static final String POSITION_INDICATOR = "-";
    public static final String NEW_LINE = "\n";
    public static final String NAME_DELIMITER = ", ";

    public static void announceRaceResults(RaceResults raceResults) {
        printResult(raceResults.raceResultsString());
        printRaceWinner(raceResults);
    }

    private static void printRaceWinner(RaceResults raceResults) {
        String result = "";
        List<String> winners = raceWinner(raceResults);
        int size = winners.size();
        for (int i = 0; i < size; i++) {
            result += winners.get(i);
            result += nameDelimiter(size, i);
        }
        System.out.print(result + "가 최종 우승했습니다.\n");
    }

    private static String nameDelimiter(int size, int i) {
        return (i == size - 1) ? "" : NAME_DELIMITER;
    }

    private static void printResult(String result) {
        System.out.print("[경기 결과]\n" + result);
    }

}
