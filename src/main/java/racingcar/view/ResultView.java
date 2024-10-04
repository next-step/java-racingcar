package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    private static final String MOVE_UNIT = "-";

    public static void print(List<Car> cars){
        for (Car car : cars) {
            printCarMovement(car);
        }
        System.out.println();
    }

    private static void printCarMovement(Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(MOVE_UNIT);
        }
        System.out.println();
    }
}
