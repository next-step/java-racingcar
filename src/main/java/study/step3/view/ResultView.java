package study.step3.view;

import study.step3.Car;

import java.util.List;

public class ResultView {

    public static void show(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car.getPosition().value());
        }
    }

    private static void printPosition(int value) {
        String car = "";
        for (int i = 0; i < value; i++) {
            car += "-";
        }
        System.out.println(car);
    }

    public static void printStart() {
        System.out.println("실행 결과");
    }

    public static void printEnd() {
        System.out.println("");
    }
}
