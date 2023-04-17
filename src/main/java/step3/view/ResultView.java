package step3.view;

import step3.Car;

import java.util.List;

public class ResultView {

    public static void printRunResultText() {
        System.out.println("실행 결과");
    }

    public static void printCarsRunState(List<Car> cars) {
        cars.forEach(ResultView::printCarRunState);
        System.out.println();
    }

    private static void printCarRunState(Car car) {
        System.out.println("-".repeat(car.getPosition()));
    }
}
