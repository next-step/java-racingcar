package racingcar;

import java.util.List;

public class ResultView {
    public static void printResult(Cars cars, int n) {
        System.out.printf("Race result(phase: %d)\n", n);
        for (Car car : cars) {
            String track = createTrack(car);
            System.out.printf("%s\t: %s\n", car.name, track);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.printf("🎉 Winners: %s\n", winners);
    }

    public static String createTrack(Car car) {
        return "-".repeat(car.position().at());
    }


}
