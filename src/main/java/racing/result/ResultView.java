package racing.result;

import racing.race.Car;

import java.util.Arrays;
import java.util.List;

import static racing.Constants.FORWARD;

public class ResultView {

    public static final String FORWARD_MARK = "-";

    public void result(int numOfAttempt, List<Car> racingCars) {
        System.out.println("실행 결과");

        String[] results = new String[racingCars.size()];
        Arrays.fill(results, "");
        for (int i = 0; i < numOfAttempt; i++) {
            printResult(racingCars, results);
            System.out.println();
        }
    }

    private void printResult(List<Car> racingCars, String[] results) {
        for (int j = 0; j < racingCars.size(); j++) {
            results[j] += racingCars.get(j).raceResult() == FORWARD ? FORWARD_MARK : "";
            System.out.println((j + 1) + "번 : " + results[j]);
        }
    }
}
