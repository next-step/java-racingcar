package racingcar;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars, int n) {
        System.out.printf("Race result(phase: %d)\n", n);
        for (Car car : cars) {
            System.out.printf("%s\t: %s\n", car.name, car.getTrack());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.printf("🎉 Winner: %s\n", winners);
    }
}
