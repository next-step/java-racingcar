package carRacing.view;

import carRacing.model.Car;

import java.util.List;

public class OutputView {
    public void printRacingResultExcutedCycle(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
