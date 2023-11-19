package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            printLine(car);
        }
        System.out.println();
    }

    private static void printLine(Car car) {
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }
}
