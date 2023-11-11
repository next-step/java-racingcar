package step4.view;

import step4.domain.Car;

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
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
