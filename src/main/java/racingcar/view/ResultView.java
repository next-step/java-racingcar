package racingcar.view;

import racingcar.domain.*;

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

    public void printTryResult(RaceResult raceResult) {
        for (CarRecords carRecords : raceResult) {
            printCarRaceResult(carRecords);
            System.out.println();
        }
    }

    private void printCarRaceResult(CarRecords carRecords) {
        for (CarRecord carRecord : carRecords) {
            String carName = carRecord.getName();
            int carDistance = carRecord.getDistance();

            System.out.println(carName + ":" + makeDistanceResult(carDistance));
        }
    }

    private String makeDistanceResult(int distance) {
        String carDistance = CAR_DISTANCE;
        return carDistance.repeat(distance);
    }

    public void printWinnerResult(Winners winners) {
        System.out.println(winners.getWinnersNames()+"이(가) 최종 우승했습니다.");
    }
}
