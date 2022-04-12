package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(OutputView::printCar);
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(car);
    }
}
