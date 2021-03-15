package carRacing.view;

import carRacing.model.Car;

import java.util.List;

public class OutputView {
    public void printResult(List<Car> result) {
        for (Car car : result) {
            System.out.println(car);
        }
        System.out.println();
    }
}
