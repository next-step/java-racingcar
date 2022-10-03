package racing;

import java.util.List;

public class ResultView {
    private static final String MOVE_SYMBOL = "-";
    private static final String CAR_FORMAT = "%s : %s\n";

    private ResultView() {

    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printCar);
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.printf(CAR_FORMAT, car.getName(), MOVE_SYMBOL.repeat(car.getMoves()));
    }
}
