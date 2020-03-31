package racingcar;

import racingcar.car.Car;

import java.util.List;

public class OutputView {

    public static void print(RacingGameResult result) {
        System.out.println("실행 결과");
        int numberOfTry = result.getRecordOfCar(0).size();
        for (int timeLab = 0; timeLab < numberOfTry; timeLab++) {
            printDashInTimeLab(result, timeLab);
        }
    }

    private static void printDashInTimeLab(RacingGameResult result, int timeLab) {
        int numberOfCars = result.getNumberOfCars();
        List<Car> records = result.getRecords();

        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
            int count = records.get(carIndex).getRecord().get(timeLab);
            printDash(count);
        }
        System.out.println();
    }

    private static void printDash(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
