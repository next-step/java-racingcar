package racingcar.view;

import racingcar.model.CarNames;
import racingcar.model.CarRecord;
import racingcar.model.RaceResult;

public class ResultView {

    public static final String CAR_DISTANCE = "-";

    public void printResultNotice() {
        System.out.println("실행 결과");
    }

    public void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
    }

    public void printTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printTryResult(CarNames carNames, RaceResult raceResult) {
        for (CarRecord carRecords : raceResult) {
            printCarRaceResult(carNames, carRecords);
            System.out.println();
        }
    }

    private void printCarRaceResult(CarNames carNames, CarRecord carRecords) {
        for (int carIndex = 0; carIndex < carRecords.size(); carIndex++) {
            String carName = carNames.getCarName(carIndex);
            int carRecord = carRecords.getDistance(carName);

            System.out.println(carName + ":" + makeDistanceResult(carRecord));
        }
    }

    private String makeDistanceResult(Integer carRecord) {
        String carDistance = CAR_DISTANCE;
        return carDistance.repeat(carRecord);
    }

    public void printWinnerResult() {
//        System.out.println(+"가 최종 우승했습니다.");
    }
}
