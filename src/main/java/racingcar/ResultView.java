package racingcar;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars, int n) {
        System.out.printf("Race result(phase: %d)\n", n);
        for (Car car : cars) {
            String track = createTrack(car.getPosition());
            System.out.printf("%s\t: %s\n", car.name, track);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.printf("🎉 Winner: %s\n", winners);
    }

    public static String createTrack(int position) {
        return "-".repeat(position);
    }
}
