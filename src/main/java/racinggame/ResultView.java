package racinggame;

import java.util.Map;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printCarPosition(Map<Car, Integer> carPosition) {
        for (Car car : carPosition.keySet()) {
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
