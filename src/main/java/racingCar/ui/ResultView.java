package racingCar.ui;

import racingCar.Car;

import java.util.List;

public class ResultView {
    public void printCarRace(List<Car> raceCar) {
        for (Car car : raceCar) {
            car.move();
            System.out.println(printRace(car));
        }
        System.out.println();
    }

    private String printRace(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        int moveCount = car.getMoveCount();

        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}

