package racingcar.view;

import racingcar.model.RaceResult;

import java.util.List;

public class ResultView {

    public static final String CAR_DISTANCE = "-";

    public void printResultNotice() {
        System.out.println("실행 결과");
    }

    public void printCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printTryResult(RaceResult raceResult) {
        for (List<Integer> carRecords : raceResult) {
            printCarRaceResult(carRecords);
            System.out.println();
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
