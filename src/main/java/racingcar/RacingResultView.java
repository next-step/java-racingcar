package racingcar;

import java.util.List;
import java.util.StringJoiner;

public class RacingResultView {

    public static void viewResult(RacingCars cars) {
        PrintNamePositionStrategy printStrategy = new PrintNamePositionStrategy();
        for (Car car : cars.getRacingCars()) {
            printPosition(car, printStrategy);
        }
    }

    private static void printPosition(Car car, PrintStrategy printStrategy) {
        printStrategy.print(car);
    }

    public static void viewWinners(List<Car> winners) {
        StringJoiner sj = new StringJoiner(",");
        for (Car winner : winners) {
            sj.add(winner.getName());
        }

        System.out.println(String.format("%s 가 최종 우승했습니다", sj));
    }
}
