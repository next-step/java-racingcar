package car_racing;

import java.util.List;

public class ResultView {
    static void printMovingOfCars(List<Car> cars) {
        for (Car car : cars) {
            for (int i = 0; i < car.moveCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
