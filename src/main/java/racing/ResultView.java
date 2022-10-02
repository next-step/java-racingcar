package racing;

import java.util.List;

public class ResultView {
    public static final String MOVE_SYMBOL = "-";

    private ResultView() {

    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printCar);
        System.out.println();
    }

    private static void printCar(Car car) {
        for (int i = 0; i < car.getMoves(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }
}
