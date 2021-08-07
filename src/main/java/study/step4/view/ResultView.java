package study.step4.view;

import java.util.List;
import study.step4.model.car.Car;

public class ResultView {

    private static final String DISTANCE_SEPERATOR = "-";

    public void printResult(List<Car> racingGameCars) {
        for (Car car : racingGameCars) {
            printCarDistance(car);
        }
        System.out.println();
    }

    public void printCarDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(DISTANCE_SEPERATOR);
        }
        System.out.println();
    }
}
