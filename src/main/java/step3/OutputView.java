package step3;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printAllCar(List<Car> cars) {
        cars.forEach(OutputView::printCarDistance);

        System.out.println();
    }

    private static void printCarDistance(Car car) {
        for (int j = 0; j < car.getCarDistance(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
