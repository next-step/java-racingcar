package game;

import java.util.List;

public class OutputView {

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            printMovingCount(car.getMovingCount());
        }
        System.out.println();
    }

    private static void printMovingCount(int movingCount) {
        for (int i = 0; i < movingCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
