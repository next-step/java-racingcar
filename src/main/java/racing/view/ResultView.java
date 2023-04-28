package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {

        for (Car car : cars) {
            printName(car);
            printDash(car);
            System.out.println();
        }

        System.out.println();
    }

    public static void printResultInfoMessage() {
        System.out.println("실행 결과");
    }

    private static void printDash(Car car) {
        int num = car.getPosition();
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    private static void printName(Car car) {
        String name = car.getName();
        System.out.print(name + " : ");
    }
}
