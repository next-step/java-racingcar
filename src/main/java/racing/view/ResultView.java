package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {
    private static final String DELIMITER = " : ";

    public static void resultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarName(String carName) {
        System.out.print(carName + DELIMITER);
    }

    public static void printPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(List<Car> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            printCarName(carPositions.get(i).getCarName());
            printPosition(carPositions.get(i).getPosition());
        }
        System.out.println();
    }
}
