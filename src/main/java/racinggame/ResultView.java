package racinggame;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getDashesByCount(car.getPosition()));
        }
    }

    private static String getDashesByCount(int count) {
        return "-".repeat(count);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
