package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {
        printResultInfoMessage();
        for (Car car : cars) {
            printDash(car);
            System.out.println();
        }

        System.out.println();
    }

    private static void printResultInfoMessage() {
        System.out.println("실행 결과");
    }

    private static void printDash(Car car) {
        int num = car.getPosition();
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }
}
