package racingcar;

import racingcar.car.Car;
import racingcar.car.CarCollection;

public class OutputView {
    private static final String TEXT_OUTPUT_RESULT = "실행 결과";
    private static final String TEXT_RACE_DISTANCE_TOKEN = "-";
    private static final String TEXT_OUTPUT_WINNER_NAMES = "%s가 최종 우승했습니다.";

    public static void print(RacingGameResult result) {
        System.out.println(TEXT_OUTPUT_RESULT);

        int numberOfTry = result.getRecordOfCar(0).size();
        for (int timeLab = 0; timeLab < numberOfTry; timeLab++) {
            printDashInTimeLab(result, timeLab);
        }

        CarCollection winners = result.getWinners();
        System.out.println(String.format(TEXT_OUTPUT_WINNER_NAMES, winners.getNames()));
    }

    private static void printDashInTimeLab(RacingGameResult result, int timeLab) {
        for (Car car : result.getCars()) {
            printDash(car, timeLab);
        }

        System.out.println();
    }

    private static void printDash(Car car, int timeLab) {
        int count = car.getRecord(timeLab);

        System.out.print(car.getName() + " ");
        for (int i = 0; i < count; i++) {
            System.out.print(TEXT_RACE_DISTANCE_TOKEN);
        }
        System.out.println();
    }
}
