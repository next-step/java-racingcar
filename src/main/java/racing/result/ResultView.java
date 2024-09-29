package racing.result;

import racing.race.RaceRecord;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public static final String FORWARD_MARK = "-";

    public void result(int numOfAttempt, List<RaceRecord> racingCars) {
        System.out.println("실행 결과");

        String[] results = new String[racingCars.size()];
        Arrays.fill(results, "");
        for (int i = 0; i < numOfAttempt; i++) {
            printResult(racingCars, results, i);
            System.out.println();
        }
    }

    private void printResult(List<RaceRecord> racingCars, String[] results, int attempt) {
        for (int j = 0; j < racingCars.size(); j++) {
            results[j] += racingCars.get(j).raceResult(attempt).getResultMark();
            System.out.println((j + 1) + "번 : " + results[j]);
        }
    }
}
