package racingcar;

import java.util.List;

public class RaceView {
    public static final String MOVE_SYMBOL = "-";

    public static void printCars(List<Car> cars) {
        cars.forEach(RaceView::printCarDistance);
    }

    public static void printCarDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(MOVE_SYMBOL);
        }
        System.out.println();
    }
}
