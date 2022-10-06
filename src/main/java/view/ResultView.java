package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printRacingResult(List<Car> cars) {
        cars.forEach(Car::toString);
        System.out.println();
    }
}
