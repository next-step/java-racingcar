package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    private static final char CAR_DISTANCE_CHARACTER = '-';

    private OutputView() {
    }

    public static void printAllCar(List<Car> cars) {
        cars.forEach(OutputView::printCarDistance);

        System.out.println();
    }

    private static void printCarDistance(Car car) {
        for (int j = 0; j < car.getCarDistance(); j++) {
            System.out.print(CAR_DISTANCE_CHARACTER);
        }
        System.out.println();
    }

}
