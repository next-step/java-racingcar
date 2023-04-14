package racingcar.view;

import static racingcar.domain.RaceWinner.raceWinner;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.LapResult;
import racingcar.domain.RaceResults;

public class OutputView {

    public static final String NAME_POSITION_DELIMITER = " : ";
    public static final String POSITION_INDICATOR = "-";
    public static final String NEW_LINE = "\n";
    public static final String NAME_DELIMITER = ", ";

    public static void announceRaceResults(RaceResults raceResults) {
        printResult(raceResultsString(raceResults.lapResults()));
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

    private static String raceResultsString(List<LapResult> lapResults) {
        String result = "";
        for (LapResult lapResult : lapResults) {
            result += lapResultString(lapResult);
        }
        return result;
    }

    private static String lapResultString(LapResult lapResult) {
        String result = "";
        for (Car car : lapResult.cars()) {
            result += carPosition(car);
        }
        result += NEW_LINE;
        return result;
    }

    private static String carPosition(Car car) {
        return car.name() + NAME_POSITION_DELIMITER + carPositionIndicator(car);
    }

    private static String carPositionIndicator(Car car) {
        String result = "";
        for (int p = 0; p < car.position(); p++) {
            result += POSITION_INDICATOR;
        }
        result += NEW_LINE;
        return result;
    }

    private static String nameDelimiter(int size, int i) {
        return (i == size - 1) ? "" : NAME_DELIMITER;
    }

    private static void printResult(String result) {
        System.out.print("[경기 결과]\n" + result);
    }

}
