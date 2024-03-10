package racingcar.view;

import racingcar.model.RaceResult;

import java.util.List;

public class ResultView {

    public static final String CAR_DISTANCE = "-";

    public void printResultNotice() {
        System.out.println("실행 결과");
    }

    public void printTryResult(RaceResult raceResult) {
        for (List<Integer> carRecords : raceResult) {
            printCarRaceResult(carRecords);
            System.out.println("\n");
        }
    }

    private void printCarRaceResult(List<Integer> carRecords) {
        for (Integer carRecord : carRecords) {
            System.out.println(makeDistanceResult(carRecord));
        }
    }

    private String makeDistanceResult(Integer carRecord) {
        String carDistance = CAR_DISTANCE;
        return carDistance.repeat(carRecord);
    }
}
