package view;

import model.Car;

import java.util.List;

public class ResultView {
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
