package game;


import java.util.List;

public class OutputView {
    public static void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printMovingCount(car.getLocation());
        }
        System.out.println();
    }

    private static void printMovingCount(int movingCount) {
        for (int i = 0; i < movingCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
