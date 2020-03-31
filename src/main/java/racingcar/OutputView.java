package racingcar;

import racingcar.car.Car;

public class OutputView {

    public static void print(RacingGameResult result) {
        System.out.println("실행 결과");
        int numberOfTry = result.getRecordOfCar(0).size();
        for (int timeLab = 0; timeLab < numberOfTry; timeLab++) {
            printDashInTimeLab(result, timeLab);
        }
    }

    private static void printDashInTimeLab(RacingGameResult result, int timeLab) {
        for (Car car : result.getCars()) {
            printDash(car, timeLab);
        }

        System.out.println();
    }

    private static void printDash(Car car, int timeLab) {
        int count = car.getRecord().get(timeLab);

        System.out.print(car.getName() + " ");
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
