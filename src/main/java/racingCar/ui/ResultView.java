package racingCar.ui;

import racingCar.Car;

import java.util.List;

public class ResultView {
    List<Car> raceCar;

    public ResultView(List<Car> raceCar) {
        this.raceCar = raceCar;
    }

    public void printRace() {
        for (Car car : raceCar) {
            car.move();
            System.out.println(car.printRace());
        }
        System.out.println();
    }
}
